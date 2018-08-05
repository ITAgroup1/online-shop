let merchantServer = "http://localhost:9090/";
// let uploadServer = "http://10.222.29.153:9090/picServer";
let uploadServer = "http://10.222.29.153:10086";
// let uploadServer = "file:///D:/ITA/demo-project/Merchant/src";

Date.prototype.format = function(fmt) { 
    var o = { 
       "M+" : this.getMonth()+1,                 //月份 
       "d+" : this.getDate(),                    //日 
       "h+" : this.getHours(),                   //小时 
       "m+" : this.getMinutes(),                 //分 
       "s+" : this.getSeconds(),                 //秒 
       "q+" : Math.floor((this.getMonth()+3)/3), //季度 
       "S"  : this.getMilliseconds()             //毫秒 
   }; 
   if(/(y+)/.test(fmt)) {
           fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
   }
    for(var k in o) {
       if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
   return fmt; 
}   

// 上传图片
function uploadPic(item,successFunc){
    $(item).click(function() {
       console.log("Hello businessPic");
       let inputPic = $('<input type="file"/>');
       inputPic.on("change", function() {
           let img = inputPic.prop("files")[0];
        //    console.log(img);
           let data = new FormData();
           data.append("img", img);
        //    console.log("hello");
           $.ajax({
               type: "POST",
               url: uploadServer + "/upload",
               data: data,
               dataType: 'json', 
               async: false,
               cache: false,
               contentType: false,
               processData: false,
               success: successFunc,
               error: function(err) {
                    console.log(err);
               }
           });
       });
       inputPic.trigger("click");
    });   
}; 


// true为只可读，false为可读可写
function editable(boolVal) {
    $.each($("#about-shop-input input"), function(index,item) {
        $(item).attr("readOnly",boolVal)
    });
}

// 提交修改后的商店信息
function modifyShop() {
    let data ={};
    let shopImgs =[];

    // get input data
    $.each($("#about-shop-input input"), (index, item)=>{
        let $input = $(item);
        data[$input.prop("name")] = $input.prop("value");
    });

    // get img data
    let firstIndex = 0;
    let lastIndex = $("#about-shop-pic div").length -1;
    $.each($("#about-shop-pic div"), (index, item)=> {
        $img = $(item).find("img");
        if(index == firstIndex) {
            data["businessPic"] = $img.prop("src").replace(uploadServer, "");
        }else if(index != lastIndex) {
            shopImgs.push($img.prop("src").replace(uploadServer, ""));
        }
    });

    data["shopPic"] = shopImgs;
    for(let key of Object.keys(data)) {
        if(key == "serviceStartTime" || key == "serviceEndTime") {
            let dayDate  = (new Date()).format("yyyy/MM/dd");
            data[key] = (new Date(dayDate + " " + data[key])).getTime();
        }
    }

    console.log("------------------------发送Ajax异步请求-----------------------------------");
    console.log(data);
    $.ajax({
        type: "PUT",
        url: merchantServer + "shop",
        data: JSON.stringify(data),
        contentType: 'application/json',
        dataType: 'json',
        success: function(data) {
            console.log(data);
            let result = data;
            console.log(result);
            if(result.status === "1") {
                alert("保存成功!");
            }else {
                alert("保存失败!")
            }
        },
        error: function(err) {
            console.log(err);
        }
    });
}

// 绑定上传事件
function bindUploadPic() {
    let shopImgs = $("#about-shop-pic img");
    let lastIndex = shopImgs.length - 1;
    $.each(shopImgs,function(index, item){
        if(index != 0) {
            console.log(index);
            if(index != lastIndex) {
                console.log(index);
                uploadPic(item,function(data) {
                    console.log(data);
                    console.log($(item).prop("src", uploadServer + data.data.url));
                });
            } else {
                uploadPic(item, function(data) {
                    console.log(data);
                    let newDiv = $(`<div>
                                		<a name="shopPic">
                                            <img class="img-responsive" alt="图片" src="<%=basePath%>assets/img/add_img.png"/>
                                        </a>
                                    </div><hr>`);
                    console.log(newDiv);
                    $($(newDiv.children()[0]).children()[0]).prop("src",  uploadServer + data.data.url);
                    $(item).parent().parent().before(newDiv);
                });
            } 
        }
    });    
}

// 解除上传事件绑定

function unbindUploadPic() {
    let shopImgs = $("#about-shop-pic img");
    let lastIndex = shopImgs.length - 1;
    $.each(shopImgs,function(index, item){
        if(index != 0) {
            console.log(index);
            if(index != lastIndex) {
                // 暂时不弄
            } else {
                // 暂时不弄
            } 
        }
    });    
}
$(function() {
    // 初始化为不可修改
    editable(true)

    console.log("--------------------------Button事件注册添加---------------------------------");
    // 修改按钮事件绑定
    $("[name=btn-modify]").on("click", function(){
        let isModify = confirm("确定要修改？");
        if(isModify == true) {
            // input可编辑
            editable(false);
            // 绑定上传事件
            bindUploadPic();
        }
    });

    // 保存按钮事件绑定
    $("[name=btn-save]").on("click", function(){
        let isSave = confirm("确定要保存?");
        if(isSave == true) {
            modifyShop();
            
        }
    });
})



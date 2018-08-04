let merchantServer = "http://localhost:9090/merchant";
// let uploadServer = "http://10.222.29.153:9090/picServer";
let uploadServer = "http://localhost:9090/picServer";
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
    let submitFormData = new FormData();
    console.log("--------------------------获取input表单数据-------------------------------");
    $.each($("#about-shop-input input"), function(index,item) {
        console.log($(item).prop("name") + ":" + $(item).prop("value"));
        submitFormData.set($(item).prop("name"), $(item).prop("value"))
    });

    console.log("------------------------获取img相对路径-----------------------------------");
    let shopPicName = "";
    let lastIndex = $("#about-shop-pic div").length -1;
    $.each($("#about-shop-pic a"), function(index,item) {
        let a = $(item);
        let img = $(a.children()[0]);
        // console.log(a.prop("name") + ":" + img.prop("src").replace(uploadServer,""));
        if(index == 0) {
            submitFormData.set(a.prop("name"),img.prop("src").replace(uploadServer,""));
        }else{
            if(index != lastIndex) {
                shopPicName = a.prop("name");
                submitFormData.append(a.prop("name"),img.prop("src").replace(uploadServer,""));
            }
        }
    });
    submitFormData.set(shopPicName, submitFormData.getAll(shopPicName).join(";;"))
    data = {}
    for(let key of submitFormData.keys()) { //2011-10-12 12:00:00
        let val = submitFormData.get(key);
        if(key == "serviceStartTime" || key == "servicEndTime") {
            var date = (new Date).getTime();
            var dTime = new Date(date).format("yyyy/MM/dd");
            var lTime = val;
            let newDate = new Date(dTime + " " + lTime).getTime();
            val = newDate;
            console.log(val);
        }
        console.log(key + " : " + val);
        data[key] = val;
    }
    console.log("------------------------发送Ajax异步请求-----------------------------------"); 
    console.log(data);
    $.ajax({
        type: "POST",
        url: merchantServer + "/shop/modify",
        data: data,      
        success: function(data) {
            console.log(data);
            let result = JSON.parse(data);
            if(result.status == true) {
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
                    let newDiv = $('<div class="method1"><a name="shopPic"><img class="test" src="" width="450px" height="330px" /></a></div><hr>');
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



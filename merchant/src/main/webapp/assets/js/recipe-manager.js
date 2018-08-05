let merchantServer = "http://localhost:9090";
let uploadServer = "http://10.222.29.153:10086";

// 上传图片
function uploadPic(item,successFunc){
    $(item).click(function() {
       let inputPic = $('<input type="file"/>');
       inputPic.on("change", function() {
           let img = inputPic.prop("files")[0];
           console.log(img);
           let data = new FormData();
           data.append("img", img);
           $.ajax({
               type: "POST",
               url: uploadServer + "/upload",
               data: data,
               dataType: 'json',
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

// 删除菜
function deleteRecipe() {
    let isDelete = confirm("确定删除？");
    if(isDelete) {
        data = {};
        let div = $(this).parent();
        // console.log(div.html());
        let input = $(div.children()[0]);
        // console.log(input);
        let hr = div.next();
        data[input.prop("name")] = input.prop("value");
        console.log(data);
        $.ajax({
            type: "DELETE",
            url: merchantServer + "/recipe/" + data.id,
            success: function(data) {
                if(data.status == true) {
                    alert(data.message);
                }else{
                    alert(data.message);
                }
            },
            error: function(err) {
                console.log(err);
            }
        });
        div.remove();
        hr.remove();                 
    }
}

// 保存菜
function saveRecipe() {
    let data = {};
    console.log("--------------------------获取input表单数据-------------------------------");
    $.each($("#about-recipe-input input"), function(index,item) {
        data[$(item).prop("name")] = $(item).prop("value");
    });
    data[$("#about-recipe-input textarea").prop("name")] = $("#about-recipe-input textarea").prop("value");
    console.log("------------------------获取img相对路径-----------------------------------");
    data[$("#about-recipe-pic a").prop("name")] = $($("#about-recipe-pic a").children()[0]).prop("src");
    console.log("------------------------发送Ajax异步请求-----------------------------------");

    console.log(data);
    console.log(JSON.stringify(data))
    $.ajax({
        type: "POST",
        url: merchantServer + "/recipe",
        data: JSON.stringify(data),
        contentType: 'application/json',
        dataType: 'json',
        success: function(data) {
            console.log(data);
            let result = data;
            if(result.status === "1") {
                let newDiv = $(`<div>
                                <input type="hidden" name="id" class="form-control" value="">
                                <p>food1</p>
                                <a name="recipePic">
                                <img class="img-responsive" alt="图片" src=""/>
                                </a>
                                <p>25.00(￥)</p>
                                <button type="button" class="btn btn-danger">
                                <i class="fa fa-trash-o">
                                </i> 删除</button>                                                        
                                </div><hr>`);
                console.log(newDiv);
                let input = $(newDiv.children()[0]);
                let p1 = $(newDiv.children()[1]);
                let img = $($(newDiv.children()[2]).children()[0]);
                let p2 = $(newDiv.children()[3]);
                let button1 = $(newDiv.children()[4]); //删除按钮
                let button2 = $(newDiv.children()[5]); //修改按钮
   

                input.prop("value", result.data.recipe.id);
                p1.text(result.data.recipe.recipeName);
                img.prop("src", result.data.recipe.recipePic);
                p2.text(result.data.recipe.price + "(￥)");
                button1.on("click", deleteRecipe);
                button2.on("click", function() {
                    alert("修改");
                });

                $("#recipe-list").append(newDiv);                   
                alert("添加成功!");                
            }else {
                alert("添加失败!")
            }
        },
        error: function(err) {
            console.log(err);
        }
    });
}


$(function() {

    // 添加按钮事件
    $("[name=btn-save]").on("click", function() {
        saveRecipe();
    });
    
    // 添加图片触发事件
    uploadPic($("#about-recipe-pic [name=recipePic]"), function(data) {
        console.log($("#about-recipe-pic img"));
        console.log(data);
        if(data.status == true) {
            let uploadImg = $("#about-recipe-pic img");
            console.log(uploadImg.prop("src", data.data.url));
        }else {
            confirm("上传失败！请重传！");
        }
    });
    
    // 注册删除事件
    $.each($("#recipe-list button"), function(index,item){
        $(item).on("click", deleteRecipe);
    });

})




let merchantServer = "http://localhost:9090/merchant";
let uploadServer = "http://localhost:9090/picServer";

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

// 删除菜
function deleteRecipe() {
    let isDelete = confirm("确定要删除？");
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
            type: "POST",
            url: merchantServer + "/recipe/delete",
            data: data,
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
    data[$("#about-recipe-pic a").prop("name")] = $($("#about-recipe-pic a").children()[0]).prop("src").replace(uploadServer,"");
    console.log("------------------------发送Ajax异步请求-----------------------------------");

    console.log(data);
    $.ajax({
        type: "POST",
        url: merchantServer + "/recipe/save",
        data: data,
        success: function(data) {
            console.log(data);
            let result = JSON.parse(data);
            if(result.status == true) {
                let newDiv = $(`<div class="method1" >
                                <input type="hidden" name="recipeId" class="form-control" value="">
                                <p>food1</p>
                                <a name="recipePic">
                                <img  class="test" src="http://localhost:9090/picServer/31e4230/8b6d2c6/2aeb321/765a3c440db.jpg" width="450px" height="330px" />
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
   

                input.prop("value", result.data.recipe.recipeId);
                p1.prop("value", result.data.recipe.recipeName);
                img.prop("src", uploadServer + result.data.recipe.recipePic);
                p2.prop("value", result.data.recipe.price + "(￥)");
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
            console.log(uploadImg.prop("src", uploadServer + data.data.url));
        }else {
            confirm("上传失败！请重传！");
        }
    });
    
    // 注册删除事件
    $.each($("#recipe-list button"), function(index,item){
        $(item).on("click", deleteRecipe);
    });

})



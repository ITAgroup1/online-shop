$(document).ready(function () {

    let formData = {};
    let imgServer = "http://10.222.29.153:10086/";

    let IDUploadBtn = $("#add-id-img-btn");
    uploadBtn(IDUploadBtn,"idcardPic");
    let ZZUploadBtn = $("#add-zz-img-btn");
    uploadBtn(ZZUploadBtn,"businessPic");
    let SHopUploadBtn = $("#add-shop-img-btn");
    uploadBtn(SHopUploadBtn,"shopPic");

    let $idcardNum = $("input[name=idcardNum]");
    let $merchantName = $("input[name=merchantName]");
    let $address = $("input[name=address]");
    let $introduction = $("textarea[name=introduction]");


    function uploadBtn($btn,key) {
        $btn.on("click",async function () {
            let imgInput = $("<input type='file' accept='image/x-png,image/gif,image/jpeg,image/bmp'/>");
            imgInput.on("change",() => {
                let img = imgInput.prop("files")[0];
                let data = new FormData();
                data.append("img",img);
                console.log($btn);
                $.ajax({
                    url : imgServer + "upload",
                    type: "post",
                    data: data,
                    async: false,
                    cache: false,
                    contentType: false,
                    processData: false,
                    dataType: "json",
                    beforeSend: () =>{
                        console.log("before send");
                    },
                    success: (data) => {
                        if(data.status === "1"){
                            let url = data.data.url;
                            let imgTag = $(`<div class="image-item">
                                <img src="${url}">
                            </div>`);
                            $btn.parent().before(imgTag);
                            if(!formData[key]){
                                formData[key] = [];
                            }
                            formData[key].push(url);
                        }
                    }
                })
            });

            imgInput.trigger("click");
        });
    }

    $("#submit-btn").on("click", () => {
        let data = {};
        data.idcardNum = $idcardNum.val();
        data.merchantName = $merchantName.val();
        data.address = $address.val();
        data.introduction = $introduction.val();
        data.idcardPic = formData.idcardPic[0];
        data.businessPic = formData.businessPic[0];
        data.shopPic = formData.shopPic;
        console.log(formData);


        if(validator.validateAll(formData,true)){
            $.ajax({
                url: window.contextPath + "merchantDetail/setupShop",
                method: "post",
                data: data,
                dataType: "json",
                traditional: true,

                success: (data) => {
                	console.log(data);
                    if(data.status){
                        window.location = window.contextPath + "merchantDetail";
                    }else{
                        let errors = data.data["errors"];
                        console.log(errors);
                        toastr.error(errors[0].message);
                    }
                }
            })
        }
    });

    //init toastr
    toastr.options = {
        closeButton: false,  //是否显示关闭按钮（提示框右上角关闭按钮）
        debug: false,  //是否为调试；
        progressBar: true,  //是否显示进度条（设置关闭的超时时间进度条）
        positionClass: "toast-top-center",  //消息框在页面显示的位置
        onclick: null,  //点击消息框自定义事件
        showDuration: "300",  //显示动作时间
        hideDuration: "1000",  //隐藏动作时间
        timeOut: "2000",  //自动关闭超时时间
        extendedTimeOut: "1000",
        showEasing: "swing",
        hideEasing: "linear",
        showMethod: "fadeIn",  //显示的方式
        hideMethod: "fadeOut"  //隐藏的方式
    };

    //init validator
    let validator = Validator({
        idcardNum: {
            validators: {
                regex: {
                    regex : "\\d{17}(X|\\d){1}",
                    error: () => {
                        toastr.error("请输入有效身份证");
                        $idcardNum.focus();
                    }
                }
            }
        },
        merchantName: {
            validators: {
                length: {
                    min: 1,
                    max: 20,
                    error: () => {
                        toastr.error("请输入有效姓名");
                        $merchantName.focus();
                    }
                }
            }
        },
        address :{
            validators: {
                length: {
                    min: 1,
                    max: 100,
                    error: () => {
                        toastr.error("店铺地址不能为空");
                        $address.focus();
                    }
                }
            }
        },
        introduction :{
            validators: {
                length: {
                    min: 0,
                    max: 200,
                    error: () => {
                        toastr.error("店铺介绍不能多于200字");
                        $introduction.focus();
                    }
                }
            }
        }
    });
});
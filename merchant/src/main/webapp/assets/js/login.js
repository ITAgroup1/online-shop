$(document).ready(function () {
    let formData = {};
    let $loginName = $("input[name=loginName]");
    let $loginPassword = $("input[name=loginPassword]");
    let $submit = $(".submit-btn");
    $submit.on("click",() => {
        formData.loginName = $loginName.val();
        formData.loginPassword = $loginPassword.val();
        console.log(formData);
        if(validator.validateAll(formData,true)){
            $.ajax({
                url: $submit.data("url"),
                method: "post",
                data: formData,
                dataType: "json",
                traditional: true,
                success: (data) => {
                    if(data.status){
                    	if(window.contextPath){
                            window.location = window.contextPath + "merchant/detail";
                    	}else{
                    		window.location = "/merchant/detail";
                    	}
                    }else{
                        if(data.message){
                            toastr.error(data.message);
                        }else if(data.message["errors"]){
                            let errors = data.data["errors"];
                            toastr.error(errors[0].message);
                        }
                    }
                },
                error: () => {
                    toastr.error("网络连接失败");
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
        loginName: {
            validators: {
                length: {
                    min: 1,
                    max: 30,
                    error: () => {
                        toastr.error("用户名在1-30位之间");
                        $loginName.focus();
                    }
                }
            }
        },
        loginPassword: {
            validators:{
                length: {
                    min: 6,
                    max: 50,
                    error: () => {
                        toastr.error("密码在6-50位之间");
                        $loginPassword.focus();
                    }
                }
            }
        }
    });
});
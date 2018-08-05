$(document).ready(function () {
    let formData = {};
    let $loginName = $("input[name=loginName]");
    let $loginPassword = $("input[name=loginPassword]");
    let $submit = $(".submit-btn");
    $submit.on("click",async () => {
        formData.loginName = $loginName.val();
        formData.password = $loginPassword.val();
        if(validator.validateAll(formData,true)){
            try {
                let res = await axios.post($submit.data("url"),formData);
                let params = res.data;
                if(params.status === "1"){
                    if(window.contextPath){
                        window.location = window.contextPath + "merchantDetail";
                    }else{
                        window.location = "merchantDetail";
                    }
                }else{
                    console.log(params);
                    if(params.data['errors']){
                        toastr.error(params.data['errors'][0]['defaultMessage']);
                    }
                }
            }catch (e) {
                toastr.error("网络连接失败");
                console.log(e);
            }
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
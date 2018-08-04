<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri= "http://java.sun.com/jsp/jstl/core" %>  
<%@ page import="com.group1.core.utils.PropertiesUtils" %>
<%
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
String imgServer = PropertiesUtils.getProperty("image.server");
%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>登录</title>
    <link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/vendor/linearicons/style.css">
    <link rel="stylesheet" href="assets/vendor/chartist/css/chartist-custom.css">
    <link rel="stylesheet" href="assets/vendor/toastr/toastr.min.css">
    <link href="assets/css/common.css" rel="stylesheet">
</head>
<style>
    *{
        vertical-align: bottom;
    }
    body{
        overflow: hidden;
    }
    /*.main-content{
        display:flex;
        justify-content: space-between;
    }*/
    .form-wrap{
        margin: 0 auto;
        width: 500px;
        margin-top: 200px;
    }
    input{
    }
    button{
        display: block;
        width: 100%;
        background-color: #00a997;
        height: 42px;
        border: 1px solid #008476;
        color: #FFF;
        font-size: 18px;
        border-radius: 3px;
        cursor: pointer;
        margin: 25px 0;
    }

    body{
        padding: 0;
        margin: 0;
    }

    input{
        border: 1px solid #AAA;
        border-radius: 3px;
        box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
        box-sizing: border-box;

        font-size: 20px;
        padding: 15px;
        width: 100%;
        margin: 25px 0;
    }
</style>
<body>
<div class="main-content row">
    <div class="side col-md-4" style="height:100%">
        <div class="carousel slide" data-ride="carousel" style="height:100%">
            <div class="carousel-inner" role="listbox" style="height:100%">
                <div class="item active" style="height:100%">
                    <img src="assets/img/bg1.jpg" style="height:100%;max-width: none;margin: 0">
                    <div class="carousel-caption">
                    </div>
                </div>
                <div class="item" style="height:100%">
                    <img src="assets/img/bg2.jpg" style="height:100%;max-width: none;">
                    <div class="carousel-caption">
                    </div>
                </div>
            </div>
        </div>
        <!--<div class="side-bg-wrap" style="height:100%;line-height:0px;">
            <img src="assets/img/bg1.jpg" style="height:100%;">
        </div>-->
    </div>

    <div style="box-sizing: border-box" class="col-md-8">
        <div class="form-wrap">
            <div>
                <h1>欢迎登录 Merchant</h1>
            </div>
            <div>
                <input type="text" name="loginName" placeholder="登录名">
            </div>
            <div>
                <input type="password" name="loginPassword" placeholder="密码">
            </div>
            <div>
                <div>还没注册?<a href="<%=basePath%>register.jsp">注册</a></div>
            </div>
            <div>
                <button class="submit-btn"  data-url="<%=basePath%>merchant/login">登录</button>
            </div>
        </div>
    </div>
</div>
<script src="<%=basePath%>assets/vendor/jquery/jquery.js"></script>
<script src="<%=basePath%>assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=basePath%>assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>assets/js/index.js"></script>
<script src="<%=basePath%>assets/js/validator.js"></script>
<script src="<%=basePath%>assets/vendor/toastr/toastr.min.js"></script>
<script src="<%=basePath%>assets/js/axios.min.js"></script>
<script src="<%=basePath%>assets/js/login.js"></script>
<script>
    $(document).ready(function () {
        /*$("body").css("overflow","hidden");*/
        let winHeight=0;
        if (window.innerHeight){
            winHeight = window.innerHeight;
        }else if ((document.body) && (document.body.clientHeight)){
            winHeight = document.body.clientHeight;
        }
        let mainContent = document.getElementsByClassName("main-content")[0];
        mainContent.style.height = (winHeight) + "px";
        window.contextPath = "<%=basePath%>";
    })
</script>
</body>
</html>
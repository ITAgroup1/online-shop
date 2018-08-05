<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.group1.core.utils.PropertiesUtils" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    //String imgServer = PropertiesUtils.getProperty("image.server");
    String imgServer = "";
%>
<!doctype html>
<html lang="en">

<head>
    <title>Home</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="<%=basePath%>assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath%>assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=basePath%>assets/vendor/linearicons/style.css">
    <link rel="stylesheet" href="<%=basePath%>assets/vendor/chartist/css/chartist-custom.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="<%=basePath%>assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="<%=basePath%>assets/css/demo.css">
    <link rel="stylesheet" href="<%=basePath%>assets/css/common.css">
    <!-- GOOGLE FONTS -->
    <!-- <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet"> -->
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="<%=basePath%>assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="<%=basePath%>assets/img/favicon.png">
</head>

<body>
<!-- WRAPPER -->
<div id="wrapper">
    <!-- NAVBAR -->
    <jsp:include page="parts/navbar.jsp"/>
    <!-- END NAVBAR -->
    <!-- LEFT SIDEBAR -->
    <jsp:include page="parts/sidebar.jsp"/>
    <!-- END LEFT SIDEBAR -->
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">商家详细信息</h3>
                <c:choose>
                    <c:when test="${merchantDetail == null}">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="panel panel-headline">
                                    <div class="panel-heading">
                                        <h3 class="panel-title">还没开通店铺? <a href="<%=basePath%>shop_form">申请开通</a></h3>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="row">
                            <div class="col-md-12" style="height: 100%">
                                <!-- PANEL HEADLINE -->
                                <div class="panel panel-headline" style="height: 100%">
                                    <div class="panel-body row" style="height: 100%">
                                        <div class="col-md-4">
                                            <h2>基本信息</h2>
                                            <div class="row">
                                                <h4>商家店铺详情ID : ${merchantDetail.id}</h4>
                                                    <%--<h4>商家ID : ${merchantDetail.merchantID}</h4>--%>
                                                <h4>商家身份证ID : ${merchantDetail.idcardNum}</h4>
                                                <h4>商家姓名 : ${merchantDetail.merchantName}</h4>
                                                <h4>店铺状态 :
                                                    <c:choose>
                                                        <c:when test="${merchantDetail.status == 0}">
                                                            待處理
                                                        </c:when>
                                                        <c:when test="${merchantDetail.status == 1}">
                                                            審核通過 <a href="<%=basePath%>shop/shopIndex">管理商店</a>
                                                        </c:when>
                                                        <c:when test="${merchantDetail.status == 2}">
                                                            駁回 <a href="<%=basePath%>shop/update">修改</a>
                                                        </c:when>
                                                        <c:when test="${merchantDetail.status == 3}">
                                                            不同意
                                                        </c:when>
                                                    </c:choose>
                                                </h4>
                                                <h4>店铺简介 : ${merchantDetail.introduction}</h4>
                                            </div>
                                        </div>
                                        <div class="col-md-8">
                                            <div class="row">
                                                <div class="col-md-6">
                                                    <h2>营业执照</h2>
                                                    <div style="height: 200px;">
                                                        <img style="height: 100%"
                                                             src="<%=imgServer%>${merchantDetail.businessPic}">
                                                    </div>
                                                </div>
                                                <div class="col-md-6">
                                                    <h2>身份证照片</h2>
                                                    <div style="height: 200px;">
                                                        <img style="height: 100%"
                                                             src="<%=imgServer%>${merchantDetail.idcardPic}">
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- END PANEL HEADLINE -->
                            </div>
                            <div class="col-md-12">
                                <!-- PANEL HEADLINE -->
                                <div class="panel panel-headline">
                                    <div class="panel-body">
                                        <div>
                                            <h2>店铺图片</h2>
                                            <div class="row" style="height: 300px;">
                                                <c:forEach items="${merchantDetail.shopPic}" var="pic">
                                                    <div style="height: 100%" class="col-md-4">
                                                        <img style="height: 100%;width: 100%;"
                                                             src="<%=imgServer%>${pic}">
                                                    </div>
                                                </c:forEach>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <!-- END PANEL HEADLINE -->
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
        <!-- END MAIN CONTENT -->
    </div>
    <!-- END MAIN -->
    <div class="clearfix"></div>
    <footer>
        <div class="container-fluid">
            <p class="copyright">Copyright &copy; 2017.Company name All rights reserved.</p>
        </div>
    </footer>
</div>
<!-- END WRAPPER -->
<!-- Javascript -->
<script src="<%=basePath%>assets/vendor/jquery/jquery.min.js"></script>
<script src="<%=basePath%>assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=basePath%>assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
<script src="<%=basePath%>assets/vendor/chartist/js/chartist.min.js"></script>
<script src="<%=basePath%>assets/scripts/klorofil-common.js"></script>
<script>
    window.contextPath = "<%=basePath%>";
</script>


</body>

</html>

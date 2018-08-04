<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.group1.core.utils.PropertiesUtils" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String imgServer = PropertiesUtils.getProperty("image.server");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Home</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <!-- VENDOR CSS -->
    <link rel="stylesheet" href="<%=basePath %>assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=basePath %>assets/vendor/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="<%=basePath %>assets/vendor/linearicons/style.css">
    <link rel="stylesheet" href="<%=basePath %>assets/vendor/chartist/css/chartist-custom.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="<%=basePath %>assets/css/main.css">
    <!-- SHOPMANAGER CSS-->
    <link rel="stylesheet" type="text/css" href="assets/css/shopManager.css" /> 
    
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="<%=basePath %>assets/css/demo.css">
    <link rel="stylesheet" href="<%=basePath %>assets/css/common.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="<%=basePath %>assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="assets/img/favicon.png">
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

                <h3 class="page-title">店铺管理</h3>
                    <div class="rows">
                        <div class="col-md-6">
                            <!-- START INPUTS 1 -->
                            <div class="panel">
                                <div class="panel-heading">
                                    <h2 class="panel-title">店铺描述</h2>
                                </div>
                                <div class="panel-body" id="about-shop-input">
                                    <input type="hidden" name="shopId" class="form-control" value="${shop.shopId}">
                                    <h4>店铺名称：</h4><input type="text" name="shopName" class="form-control" placeholder="店铺名称" value="${shop.shopName}">
                                    <br>
                                    <h4>服务开始时间：</h4><input type="time" name="serviceStartTime" class="form-control" placeholder="服务开始时间" value="${serviceStartTime}" >
                                    <br>
                                    <h4>服务结束时间：</h4><input type="time" name="servicEndTime" class="form-control" placeholder="服务结束时间" value="${servicEndTime}">
                                    <br> 
                                    <h4>配送范围(KM)：</h4><input type="number" name="serviceRange" class="form-control" placeholder="配送范围" min="1" max="20" value="${shop.serviceRange}">
                                    <br>  
                                    <h4>配送費用(￥)：</h4><input type="number" name="distributionCost" class="form-control" placeholder="配送费用" min="1.0" max="30.0" value="${shop.distributionCost}">
                                    <br>   
                                    <h4>店铺地址：</h4><input type="text" name="address" class="form-control" placeholder="店铺地址" value="${shop.address}">
                                    <br> 
                                    <input type="hidden" name="merchantId" class="form-control" value="${shop.merchantId}">                                                                    
                                </div>
                            </div>
                            <!-- END INPUTS 1--> 
                            <!-- START INPUTS 2 -->
                            <div class="panel">
                                <div class="panel-heading">
                                    <h3 class="panel-title"></h3>
                                </div>
                                <div class="panel-body" id="about-shop-pic">
                                    <h3 class="panel-heading">营业执照</h3>
                                    <div class="method1" > 
                                        <a name="businessPic">
                                            <img  class="test" src="<%=imgServer%>${shop.businessPic}" width="450px" height="330px" />
                                        </a>
                                    </div><hr> 
                                    <h3 class="panel-heading">店铺图片</h3>
									<c:forEach items="${shopPics}" var="shopPic">
	                                    <div class="method1">
	                                        <a name="shopPic">
	                                            <img class="test" src="<%=imgServer%>${shopPic}" width="450px" height="330px" />
	                                        </a>
	                                    </div><hr> 									
									</c:forEach>
									<div>
                                		<a name="shopPic">
                                            <img class="test" src="<%=basePath%>assets/img/non-upload-pic.jpg" width="450px" height="330px" />
                                        </a>
                                    </div><hr> 
                                </div>
                            </div>
                            <!-- END INPUTS 2-->                               
                            <!-- START INPUTS 1 -->
                            <div class="panel">
                                <div class="panel-heading">
                                    <h2 class="panel-title"></h2>
                                </div>
                                <div class="panel-body">
                                    <div>
                                        <button type="button" name="btn-modify" class="btn btn-primary btn-block">修改</button>
                                        <!-- <button type="button" name="btn-modify-cancel" class="btn btn-primary btn-block">取消</button> -->
                                        <button type="button" name="btn-save" class="btn btn-primary btn-block">保存</button>
                                    </div>
                                </div>
                            </div>
                            <!-- END INPUTS 1-->                                 
                        </div>
                    </div>
            </div>
        </div>     
        <!-- END MAIN CONTENT -->
    </div>
    <!-- END MAIN -->
    <div class="clearfix"></div>
    <footer>
        <div class="container-fluid">
            <p class="copyright">Copyright &copy; 2017.Company name All rights reserved.More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a></p>
        </div>
    </footer>
</div>
<!-- END WRAPPER -->
<!-- Javascript -->
<script src="<%=basePath %>assets/vendor/jquery/jquery.min.js"></script>
<script src="<%=basePath %>assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=basePath %>assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=basePath %>assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
<script src="<%=basePath %>assets/vendor/chartist/js/chartist.min.js"></script>
<script src="<%=basePath %>assets/scripts/klorofil-common.js"></script>
<script src="<%=basePath %>assets/js/shop-manager.js"></script>
</body>
</html>
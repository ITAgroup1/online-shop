<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri= "http://java.sun.com/jsp/jstl/core" %>  
<%@ page import="com.lames.merchant.config.*" %>  
<%@page import="com.lames.merchant.po.MerchantDetail"%>
<%@page import="com.lames.merchant.model.Merchant"%>
<%@ page isELIgnored="false" %>    
<%
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
String imgServer = WebServiceConfig.getConfig().get("image.server");
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
    <nav class="navbar navbar-default navbar-fixed-top">
        <div class="brand">
            <a href="index.html"><img src="<%=basePath %>assets/img/logo-dark.png" alt="Klorofil Logo" class="img-responsive logo"></a>
        </div>
        <div class="container-fluid">
            <div class="navbar-btn">
                <button type="button" class="btn-toggle-fullwidth"><i class="lnr lnr-arrow-left-circle"></i></button>
            </div>
            <form class="navbar-form navbar-left">
                <div class="input-group">
                    <input type="text" value="" class="form-control" placeholder="Search dashboard...">
                    <span class="input-group-btn"><button type="button" class="btn btn-primary">Go</button></span>
                </div>
            </form>
            <div class="navbar-btn navbar-btn-right">
                <a class="btn btn-success update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
            </div>
            <div id="navbar-menu">
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle icon-menu" data-toggle="dropdown">
                            <i class="lnr lnr-alarm"></i>
                            <span class="badge bg-danger">5</span>
                        </a>
                        <ul class="dropdown-menu notifications">
                            <li><a href="#" class="notification-item"><span class="dot bg-warning"></span>System space is almost full</a></li>
                            <li><a href="#" class="notification-item"><span class="dot bg-danger"></span>You have 9 unfinished tasks</a></li>
                            <li><a href="#" class="notification-item"><span class="dot bg-success"></span>Monthly report is available</a></li>
                            <li><a href="#" class="notification-item"><span class="dot bg-warning"></span>Weekly meeting in 1 hour</a></li>
                            <li><a href="#" class="notification-item"><span class="dot bg-success"></span>Your request has been approved</a></li>
                            <li><a href="#" class="more">See all notifications</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="lnr lnr-question-circle"></i> <span>Help</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Basic Use</a></li>
                            <li><a href="#">Working With Data</a></li>
                            <li><a href="#">Security</a></li>
                            <li><a href="#">Troubleshooting</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown"><img src="assets/img/user.png" class="img-circle" alt="Avatar"> <span>Samuel</span> <i class="icon-submenu lnr lnr-chevron-down"></i></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><i class="lnr lnr-user"></i> <span>My Profile</span></a></li>
                            <li><a href="#"><i class="lnr lnr-envelope"></i> <span>Message</span></a></li>
                            <li><a href="#"><i class="lnr lnr-cog"></i> <span>Settings</span></a></li>
                            <li><a href="#"><i class="lnr lnr-exit"></i> <span>Logout</span></a></li>
                        </ul>
                    </li>
                    <!-- <li>
                        <a class="update-pro" href="#downloads/klorofil-pro-bootstrap-admin-dashboard-template/?utm_source=klorofil&utm_medium=template&utm_campaign=KlorofilPro" title="Upgrade to Pro" target="_blank"><i class="fa fa-rocket"></i> <span>UPGRADE TO PRO</span></a>
                    </li> -->
                </ul>
            </div>
        </div>
    </nav>
    <!-- END NAVBAR -->
    <!-- LEFT SIDEBAR -->
    <div id="sidebar-nav" class="sidebar">
        <div class="sidebar-scroll">
            <nav>
                <ul class="nav">
                    <li><a href="<%=basePath%>merchant/detail" class=""><i class="lnr lnr-home"></i> <span>商家详细信息</span></a></li>
                    <li><a href="<%=basePath%>shop/shopIndex" class="active"><i class="lnr lnr-code"></i> <span>店铺管理</span></a></li>
                    <li><a href="<%=basePath%>recipe/listAll" class=""><i class="lnr lnr-chart-bars"></i> <span>菜单管理</span></a></li>
                    <!--<li><a href="panels.html" class=""><i class="lnr lnr-cog"></i> <span>Panels</span></a></li>
                    <li><a href="notifications.html" class=""><i class="lnr lnr-alarm"></i> <span>Notifications</span></a></li>
                    <li>
                        <a href="#subPages" data-toggle="collapse" class="collapsed"><i class="lnr lnr-file-empty"></i> <span>Pages</span> <i class="icon-submenu lnr lnr-chevron-left"></i></a>
                        <div id="subPages" class="collapse ">
                            <ul class="nav">
                                <li><a href="page-profile.html" class="">Profile</a></li>
                                <li><a href="page-login.html" class="">Login</a></li>
                                <li><a href="page-lockscreen.html" class="">Lockscreen</a></li>
                            </ul>
                        </div>
                    </li>
                    <li><a href="tables.html" class=""><i class="lnr lnr-dice"></i> <span>Tables</span></a></li>
                    <li><a href="typography.html" class=""><i class="lnr lnr-text-format"></i> <span>Typography</span></a></li>
                    <li><a href="icons.html" class=""><i class="lnr lnr-linearicons"></i> <span>Icons</span></a></li>-->
                </ul>
            </nav>
        </div>
    </div> 
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
									<di>     
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
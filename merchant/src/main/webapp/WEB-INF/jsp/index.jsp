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
    <jsp:include page="parts/navbar.jsp"></jsp:include>
    <!-- END NAVBAR -->
    <!-- LEFT SIDEBAR -->
    <jsp:include page="parts/sidebar.jsp"></jsp:include>
    <!-- END LEFT SIDEBAR -->
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">
                <h3 class="page-title">商家详细信息</h3>
	            <c:choose>
				    <c:when test="${merchant.merchantDetail == null}">
		                <div class="row">
		                    <div class="col-md-12">
		                        <div class="panel panel-headline">
		                            <div class="panel-heading">
		                                <h3 class="panel-title">还没开通店铺? <a href="<%=basePath%>shop/new">申请开通</a></h3>
		                            </div>
		                        </div>
		                    </div>
		                </div>
                	</c:when>
                	<c:when test="${merchant.shop != null && merchant.merchantDetail == null}">
		                <div class="row">
		                    <div class="col-md-12">
		                        <div class="panel panel-headline">
		                            <div class="panel-heading">
		                                <h3 class="panel-title">店铺申请成功请等待审核</h3>
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
		                                        <h4>商家店铺详情ID : ${merchant.merchantDetail.merchantDetailID}</h4>
		                                        <h4>商家ID : ${merchant.merchantDetail.merchantID}</h4>
		                                        <h4>商家身份证ID : ${merchant.merchantDetail.idcardNum}</h4>
		                                        <h4>商家姓名 : ${merchant.merchantDetail.merchantName}</h4>
		                                        <h4>店铺状态 : 
		                                        	<c:choose>
														<c:when test="${merchant.merchantDetail.status == 0}"> 
															待處理 
														</c:when>
														<c:when test="${merchant.merchantDetail.status == 1}"> 
															審核通過 <a href="<%=basePath%>shop/shopIndex">管理商店</a>
														</c:when>
														<c:when test="${merchant.merchantDetail.status == 2}"> 
															駁回 <a href="<%=basePath%>shop/update">修改</a>
														</c:when>
														<c:when test="${merchant.merchantDetail.status == 3}"> 
															不同意 
														</c:when>
													</c:choose>
		                                        </h4>
		                                        <h4>店铺简介 : ${merchant.merchantDetail.introduction}</h4>
		                                    </div>
		                                </div>
		                                <div class="col-md-8">
		                                    <div class="row">
		                                        <div class="col-md-6">
		                                            <h2>营业执照</h2>
		                                            <div style="height: 200px;">
		                                                <img style="height: 100%" src="<%=imgServer%>${merchant.merchantDetail.businessPic}">
		                                            </div>
		                                        </div>
		                                        <div class="col-md-6">
		                                            <h2>身份证照片</h2>
		                                            <div style="height: 200px;">
		                                                <img style="height: 100%" src="<%=imgServer%>${merchant.merchantDetail.idcardPic}">
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
			                                    <c:forEach items="${merchant.merchantDetail.shopPic}" var="pic">
				                                    <div  style="height: 100%" class="col-md-4">
			                                            <img style="height: 100%;width: 100%;" src="<%=imgServer%>${pic}">
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
<script>
    /* $(function() {
        var data, options;

        // headline charts
        data = {
            labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
            series: [
                [23, 29, 24, 40, 25, 24, 35],
                [14, 25, 18, 34, 29, 38, 44],
            ]
        };

        options = {
            height: 300,
            showArea: true,
            showLine: false,
            showPoint: false,
            fullWidth: true,
            axisX: {
                showGrid: false
            },
            lineSmooth: false,
        };

        new Chartist.Line('#headline-chart', data, options);


        // visits trend charts
        data = {
            labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec'],
            series: [{
                name: 'series-real',
                data: [200, 380, 350, 320, 410, 450, 570, 400, 555, 620, 750, 900],
            }, {
                name: 'series-projection',
                data: [240, 350, 360, 380, 400, 450, 480, 523, 555, 600, 700, 800],
            }]
        };

        options = {
            fullWidth: true,
            lineSmooth: false,
            height: "270px",
            low: 0,
            high: 'auto',
            series: {
                'series-projection': {
                    showArea: true,
                    showPoint: false,
                    showLine: false
                },
            },
            axisX: {
                showGrid: false,

            },
            axisY: {
                showGrid: false,
                onlyInteger: true,
                offset: 0,
            },
            chartPadding: {
                left: 20,
                right: 20
            }
        };

        new Chartist.Line('#visits-trends-chart', data, options);


        // visits chart
        data = {
            labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
            series: [
                [6384, 6342, 5437, 2764, 3958, 5068, 7654]
            ]
        };

        options = {
            height: 300,
            axisX: {
                showGrid: false
            },
        };

        new Chartist.Bar('#visits-chart', data, options);


        // real-time pie chart
        var sysLoad = $('#system-load').easyPieChart({
            size: 130,
            barColor: function(percent) {
                return "rgb(" + Math.round(200 * percent / 100) + ", " + Math.round(200 * (1.1 - percent / 100)) + ", 0)";
            },
            trackColor: 'rgba(245, 245, 245, 0.8)',
            scaleColor: false,
            lineWidth: 5,
            lineCap: "square",
            animate: 800
        });

        var updateInterval = 3000; // in milliseconds

        setInterval(function() {
            var randomVal;
            randomVal = getRandomInt(0, 100);

            sysLoad.data('easyPieChart').update(randomVal);
            sysLoad.find('.percent').text(randomVal);
        }, updateInterval);

        function getRandomInt(min, max) {
            return Math.floor(Math.random() * (max - min + 1)) + min;
        }

    }); */
</script>

</body>

</html>

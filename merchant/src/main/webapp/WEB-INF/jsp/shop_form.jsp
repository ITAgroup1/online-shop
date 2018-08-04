<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri= "http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.group1.core.utils.PropertiesUtils" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String imgServer = PropertiesUtils.getProperty("image.server");
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
    <link rel="stylesheet" href="<%=basePath%>assets/vendor/toastr/toastr.min.css">
    <!-- MAIN CSS -->
    <link rel="stylesheet" href="<%=basePath%>assets/css/main.css">
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="<%=basePath%>assets/css/demo.css">

    <link rel="stylesheet" href="<%=basePath%>assets/css/common.css">
    <!-- GOOGLE FONTS -->
    <!--<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">-->
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
                <h3 class="page-title">申请商店</h3>
                <div class="row">
                    <div class="col-md-offset-2 col-md-8">
                        <!-- PANEL NO CONTROLS -->
                        <div class="panel">
                            <div class="panel-heading">
                                <h3 class="panel-title">基本信息</h3>
                            </div>
                            <div class="panel-body">
                                <div class="form-group-lg">
                                    <label>身份证号</label>
                                    <input type="text" name="idcardNum" class="form-control input-lg" placeholder="身份证号">
                                </div>
                                <div class="form-group-lg">
                                    <label>商家姓名</label>
                                    <input type="email" name="merchantName" class="form-control input-lg" placeholder="商家姓名">
                                </div>
                                <div class="form-group-lg">
                                    <label>店铺地址</label>
                                    <input type="email" name="address" class="form-control input-lg" placeholder="店铺地址">
                                </div>
                                <div class="form-group-lg">
                                    <label>店铺简介</label>
                                    <textarea class="form-control" name="introduction" placeholder="店铺简介" rows="4"></textarea>
                                </div>
                            </div>
                            <hr>
                            <div class="panel-heading">
                                <h3 class="panel-title">身份证图片</h3>
                                <div class="image-row">
                                    <div>
                                        <a id="add-id-img-btn" class="add-img-btn">
                                            <img src="<%=basePath%>assets/img/add_img.png">
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <hr>
                            <div class="panel-heading">
                                <h3 class="panel-title">执照</h3>
                                <div class="image-row">
                                    <div>
                                        <a id="add-zz-img-btn" class="add-img-btn">
                                            <img src="<%=basePath%>assets/img/add_img.png">
                                        </a>
                                    </div>
                                </div>
                            </div>
                            <hr>
                            <div class="panel-heading">
                                <h3 class="panel-title">店铺照片</h3>
                                <div class="image-row">
                                    <div>
                                        <a id="add-shop-img-btn" class="add-img-btn">
                                            <img src="<%=basePath%>assets/img/add_img.png">
                                        </a>
                                    </div>
                                </div>

                            </div>
                            <div>
                                <button type="button" class="btn btn-primary btn-block btn-lg" id="submit-btn">提交申请</button>
                            </div>
                        </div>
                        <!-- END PANEL NO CONTROLS -->
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
            <p class="copyright">Copyright &copy; 2017.Company name All rights reserved.</p>
        </div>
    </footer>
</div>
<!-- END WRAPPER -->
<!-- Javascript -->
<script>
window.contextPath = "<%=basePath%>";
</script>
<script src="<%=basePath%>assets/vendor/jquery/jquery.min.js"></script>
<script src="<%=basePath%>assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=basePath%>assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>assets/js/index.js"></script>
<script src="<%=basePath%>assets/js/validator.js"></script>
<script src="<%=basePath%>assets/vendor/toastr/toastr.min.js"></script>
<script>
    /*$(function() {
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

    });*/
</script>
<!--<script src="assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
<script src="assets/vendor/chartist/js/chartist.min.js"></script>
<script src="assets/scripts/klorofil-common.js"></script>-->
</body>
</html>
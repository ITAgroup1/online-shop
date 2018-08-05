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
                <div class="row">
                    <div class="col-md-12">
                        <div class="panel panel-headline">
                            <div class="panel-heading">

                            </div>
                            <div class="panel-body">
                                <table class="table table-striped" id="complaint-list">
                                    <tr><th>投诉内容</th></tr>
                                    <tr v-for=""></tr>
                                </table>
                            </div>
                        </div>
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
<script src="<%=basePath%>assets/vendor/jquery/jquery.min.js"></script>
<script src="<%=basePath%>assets/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="<%=basePath%>assets/vendor/jquery-slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>assets/vendor/jquery.easy-pie-chart/jquery.easypiechart.min.js"></script>
<script src="<%=basePath%>assets/vendor/chartist/js/chartist.min.js"></script>
<script src="<%=basePath%>assets/scripts/klorofil-common.js"></script>
<script src="<%=basePath%>assets/js/axios.js"></script>
<script src="<%=basePath%>assets/vendor/toastr/toastr.min.js"></script>
<script src="<%=basePath%>assets/js/vue.js"></script>
<script src="<%=basePath%>assets/js/ClientWS.js"></script>
<script src="<%=basePath%>assets/js/complaint.js"></script>
<script>
    window.contextPath = "<%=basePath%>";
</script>


</body>

</html>

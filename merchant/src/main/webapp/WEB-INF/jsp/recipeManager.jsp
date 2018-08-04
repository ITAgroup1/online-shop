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
    <link rel="stylesheet" type="text/css" href="<%=basePath %>assets/css/shopManager.css" /> 
    
    <!-- FOR DEMO PURPOSES ONLY. You should remove this in your project -->
    <link rel="stylesheet" href="<%=basePath %>assets/css/demo.css">
    <link rel="stylesheet" href="<%=basePath %>assets/css/common.css">
    <!-- GOOGLE FONTS -->
    <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700" rel="stylesheet">
    <!-- ICONS -->
    <link rel="apple-touch-icon" sizes="76x76" href="<%=basePath %>assets/img/apple-icon.png">
    <link rel="icon" type="image/png" sizes="96x96" href="<%=basePath %>assets/img/favicon.png">
</head>
<body>
<!-- WRAPPER -->
<div id="wrapper">
    <!-- NAVBAR -->
    <jsp:include page="parts/navbar.jsp"/>
    <!-- END NAVBAR -->
    <!-- LEFT SIDEBAR -->
    <jsp:include page="parts/sidebar.jsp"/>
    <!-- MAIN -->
    <div class="main">
        <!-- MAIN CONTENT -->
        <div class="main-content">
            <div class="container-fluid">

                <h3 class="page-title">菜管理</h3>
                    <div class="rows">
                        <div class="col-md-6">
                            <!-- START INPUTS 1 -->
                            <div class="panel">
                                <div class="panel-heading">
                                    <h2 class="panel-title">菜描述</h2>
                                </div>
                                <div class="panel-body" id="about-recipe-input">
                                    <!-- <input type="hidden" name="recipeId" class="form-control" value=""> -->
                                    <h4>菜名：</h4><input type="text" name="recipeName" class="form-control" placeholder="菜名" value="${recipe.recipeName}">
                                    <br>
                                    <h4>菜介绍：</h4><textarea name="recipeDetail" class="form-control" placeholder="不少于100字，不超过500字" rows="4" >${recipe.recipeDetail}</textarea>                                    
                                    <br>
                                    <h4>菜价(￥)：</h4><input type="number" name="recipePrice" class="form-control" placeholder="菜价" min="1" max="1000" value="${recipe.recipePrice}">
                                    <br>
                                    <input type="hidden" name="shopId" class="form-control" value="${merchant.shop.shopId}">                                                                    
                                </div>
                            </div>
                            <!-- END INPUTS 1--> 
                            <!-- START INPUTS 2 -->
                            <div class="panel">
                                <div class="panel-heading">
                                    <h3 class="panel-title"></h3>
                                </div>
                                <div class="panel-body" id="about-recipe-pic">
                                    <h3 class="panel-heading">上传菜图片</h3>
                                    <div class="method1" > 
                                        <a name="recipePic">
                                            <img  class="test" src="<%=basePath%>assets/img/non-upload-pic.jpg" width="450px" height="330px" />
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
                                        <button type="button" name="btn-save" class="btn btn-primary btn-block">保存</button>
                                    </div>
                                </div>
                            </div>
<!--                             <div class="panel"> -->
<!--                                     <div class="panel-heading"> -->
<!--                                         <h2 class="panel-title"></h2> -->
<!--                                     </div> -->
<!--                                     <div class="panel-body"> -->
<!--                                         <div> -->
<!--                                             <button type="button" name="btn-new-add" class="btn btn-primary btn-block">新添加</button> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div>                             -->
                            <!-- END INPUTS 1-->                                 
                        </div>
                        <div class="col-md-6">
                                <div class="panel">
                                        <div class="panel-heading">
                                            <h2 class="panel-title">菜描述</h2>
                                        </div>
                                        <div class="panel-body" id="recipe-list">
                                        <c:forEach items="${recipeList}" var="recipe">
                                                <div class="method1" > 
                                                        <input type="hidden" name="recipeId" class="form-control" value="${recipe.recipeId}">
                                                        <p>${recipe.recipeName}</p>                                                                                                        
                                                        <a name="recipePic">
                                                            <img  class="test" src="<%=imgServer%>${recipe.recipePic}" width="450px" height="330px" />
                                                        </a>
                                                        <p>${recipe.recipePrice}(￥)</p>
                                                        <button type="button" class="btn btn-danger">删除</button>                                                        
                                                        <!--<button type="button" class="btn btn-primary">修改</button>-->
                                                </div><hr>                                        
                                        </c:forEach>
<!-- 
                                                <div class="method1" >
                                                        <input type="hidden" name="recipeId" class="form-control" value="2">
                                                        <p>food2</p>                                                                                                        
                                                        <a name="recipePic">
                                                            <img  class="test" src="http://localhost:9090/picServer/d29696c/4df2c06/dd54e26/fb8358646f.jpg" width="450px" height="330px" />
                                                        </a>
                                                        <p>20.00(￥)</p>
                                                        <button type="button" class="btn btn-danger">删除</button>                                                        
                                                        <button type="button" class="btn btn-primary">修改</button>  
                                                </div><hr>  
                                                <div class="method1" > 
                                                        <input type="hidden" name="recipeId" class="form-control" value="3">
                                                        <p>food3</p>                                                                                                        
                                                        <a name="recipePic">
                                                            <img  class="test" src="http://localhost:9090/picServer/fa2b71d/744bd6b/17a4e9c/f8a6d0e57d4.jpg" width="450px" height="330px" />
                                                        </a>
                                                        <p>40.00(￥)</p>
                                                        <button type="button" class="btn btn-danger">删除</button>                                                        
                                                        <button type="button" class="btn btn-primary">修改</button> 
                                                </div><hr>      -->                                                                                                                                               
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
<script src="<%=basePath %>assets/js/recipe-manager.js"></script>

</body>
</html>
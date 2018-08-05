<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="com.group1.core.utils.PropertiesUtils" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
    String imgServer = PropertiesUtils.getProperty("image.server");
    String url = request.getRequestURI();
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="sidebar-nav" class="sidebar">
    <div class="sidebar-scroll">
        <nav>
            <ul class="nav">
                <li><a href="<%=basePath%>merchantDetail" class="<%= url.endsWith("index.jsp") ? "active": "" %>">
                    <i class="lnr lnr-home"></i> <span>商家详细信息</span></a></li>
                <li><a href="<%=basePath%>shop_form" class="<%= url.endsWith("shop_form.jsp") ? "active": "" %>">
                    <i class="lnr lnr-code"></i> <span>申请店铺</span></a></li>
                <li><a href="<%=basePath%>shop" class="<%= url.endsWith("shopManager.jsp") ? "active": "" %>">
                    <i class="lnr lnr-code"></i> <span>店铺管理</span></a></li>
                <li><a href="<%=basePath%>recipe" class="<%= url.endsWith("recipeManager.jsp") ? "active": "" %>">
                    <i class="lnr lnr-code"></i> <span>菜单管理</span></a></li>
                <li><a href="<%=basePath%>orders" class="<%= url.endsWith("orders.jsp") ? "active": "" %>">
                    <i class="lnr lnr-code"></i> <span>订单管理</span></a></li>
                <li><a href="<%=basePath%>complaints" class="<%= url.endsWith("complaints.jsp") ? "active": "" %>">
                    <i class="lnr lnr-code"></i> <span>投诉</span></a></li>
            </ul>
        </nav>
    </div>
</div>
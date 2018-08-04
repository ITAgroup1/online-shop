<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page  import="com.lames.merchant.config.*" %>
<%@page import="com.lames.merchant.po.MerchantDetail"%>
<%@page import="com.lames.merchant.po.Shop"%>
<%@page import="com.lames.merchant.model.Merchant"%>
<%
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
String imgServer = WebServiceConfig.getConfig().get("image.server");
String url = request.getRequestURI();
%>
<%@ taglib prefix="c"  uri= "http://java.sun.com/jsp/jstl/core" %>  
<div id="sidebar-nav" class="sidebar">
     <div class="sidebar-scroll">
         <nav>
             <ul class="nav">
                 <li><a href="<%=basePath%>merchant/detail" class="<%= url.endsWith("index.jsp") ? "active": "" %>"><i class="lnr lnr-home"></i> <span>商家详细信息</span></a></li>
                 <c:if test="${(merchant.merchantDetail == null && merchant.shop == null) || detail.status == 2}"> 
                 	<li><a href="<%=basePath%>shop/new" class="<%= url.endsWith("shop_form.jsp") ? "active": "" %>"><i class="lnr lnr-code"></i> <span>申请店铺</span></a></li>
                 </c:if>
                 <!--<li><a href="charts.html" class=""><i class="lnr lnr-chart-bars"></i> <span>Charts</span></a></li>
                 <li><a href="panels.html" class=""><i class="lnr lnr-cog"></i> <span>Panels</span></a></li>
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
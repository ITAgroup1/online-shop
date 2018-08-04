<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page  import="com.lames.merchant.config.*" %>
<%
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
String imgServer = WebServiceConfig.getConfig().get("image.server");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
	ul{
		list-style: none;
	}
	img{
		height: 300px;
	}
</style>
<body>
	<div>
		<div>
			欢迎登录,${merchant.loginName}
		</div>
		<div>
			<c:choose>
			    <c:when test="${detail != null}">
			        <div>
					<div>
						申请ID : ${detail.merchantDetailID}
					</div>
					<div>
						商家ID : ${detail.merchantID}
					</div>
					<div>
						身份证号 : ${detail.idcardNum}
					</div>
					<div>
						身份证图片 : <img src="<%=imgServer%>${detail.idcardPic}">
					</div>
					<div>
						商家名字 : ${detail.merchantName}
					</div>
					<div>
						店铺ID : ${detail.merchantName}
					</div>
					<div>
						店铺图片: 
						<c:forEach items="${detail.shopPic}" var="pic">
							<img src="<%=imgServer%>${pic}">
						</c:forEach>
					</div>
					<div>
						营业执照 : <img src="<%=imgServer%>${detail.businessPic}">
					</div>
					<div>
						店铺地址 : ${detail.address}
					</div>
					<div>
						店铺介绍 : ${detail.introduction}
					</div>
					<div>
						店铺状态 :
						<c:choose>
							<c:when test="${detail.status == 0}"> 
								待處理 
							</c:when>
							<c:when test="${detail.status == 1}"> 
								審核通過 <a href="<%=basePath%>getRecipe.do">管理商店</a>
							</c:when>
							<c:when test="${detail.status == 2}"> 
								駁回 <a href="<%=basePath%>shop/update">修改</a>
							</c:when>
							<c:when test="${detail.status == 3}"> 
								不同意 
							</c:when>
						</c:choose>
					</div>
				</div>
			    </c:when>
			    <c:otherwise>
			       	 还没开店?<a href="<%=basePath%>shop/new">申请开通店铺</a>
			    </c:otherwise>
			</c:choose>
			 
		</div>
	</div>
</body>
</html>
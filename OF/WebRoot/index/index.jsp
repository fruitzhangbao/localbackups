<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%  
String path = request.getContextPath();  
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";  
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xml:lang="zh-CN" xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>

<base href="<%=basePath%>" />  

<meta http-equiv="content-type" content="text/html; charset=UTF-8" />
<link href="${pageContext.request.contextPath}/css/manage.css" media="screen" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-1.4.4.min.js" type="text/javascript" ></script>
</head>
<body>
	<div class="manage_container">
				<div class="manage_head">
					<%@ include file="/common/_header.jsp"%>
				</div>
		<div class="main">
		
<h1>老朋友(OF)项目首页</h1>
<div class="table_box">
	<p>欢迎来到 JFinal极速开发世界！</p>
	<br><br><br>
	本Demo采用JSP 作为视图文件，您还可以使用FreeMarker、Velocity或自定义类型视图。
	点击<a href="${pageContext.request.contextPath}/blog"><b>此处</b></a>开始试用Demo。
	
</div>
		</div>
	</div>
</body>
</html>

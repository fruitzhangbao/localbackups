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
<h1>
<a href="${pageContext.request.contextPath}/account/deng">登录</a>&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/account/join">注册</a>
</h1>

<fieldset class="solid">
	<legend>注册</legend>
	<form action="${pageContext.request.contextPath}/account/join/o" method="post">
		<div>
			<label>账号</label>
			<input type="text" name="account.name" value="${account.name}" />${nameMsg}
		</div>
		<div>
			<label>邮箱</label>
			<input type="text" name="account.email" value="${account.email}" />${emailMsg}
		</div>
		<div>
			<label>密码</label>
			<input type="password" name="account.pswd" value="${account.pswd}" />${pswdMsg}
		</div>
		<div>
			<label>再输入一遍密码</label>
			<input type="password" name="repswd"/>${pswdErrorMsg}
		</div>
		<div>
			<label>&nbsp;</label>
			<input value="注册" type="submit" />
		</div>
	</form>
	<div>
		<label>已有账号，点这里→<a href="${pageContext.request.contextPath}/account/deng">登录</a></label>
	</div>
</fieldset>

		</div>
	</div>
</body>
</html>
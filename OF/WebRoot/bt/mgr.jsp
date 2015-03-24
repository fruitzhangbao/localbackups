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
		
<%@ include file="/blog/_header.jsp"%>

<div class="table_box">
	<table class="list">
		<tbody>
			<tr>
				<th width="4%">分类id</th>
				<th width="24%">分类名</th>
				<th width="11%">包含博客数</th>
				<th width="12%">操作</th>
			</tr>
			<c:forEach items="${btypes}" var="type" begin="1">
			<tr>
				<td style="text-align:left;"><c:out value="${type.id}" default=""/></td>
				<td style="text-align:left;">${type.name}</td>
				<td style="text-align:left;">
					<c:choose>
						<c:when test="${type.num == null}">0</c:when>
						<c:otherwise>${type.num}</c:otherwise>
					</c:choose>
				</td>
				<td style="text-align:left;">
					&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/blog/bt/delete/${type.id}">删除</a>
					&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/blog/bt/edit/${type.id}">编辑</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
</div>
		</div>
	</div>
</body>
</html>
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
		
<%@ include file="_header.jsp"%>
<c:if test="${keywords != null}">
关键字'${keywords}'的搜索结果：
</c:if>
<div class="table_box">
	<table class="list">
		<tbody>
			<tr>
				<th width="4%">id</th>
				<th width="35%">标题</th>
				<th width="12%">操作</th>
			</tr>
			<c:forEach items="${blogPage.list}" var="blog">
			<tr>
				<td style="text-align:left;"><c:out value="${blog.id}" default=""/></td>
				<td style="text-align:left;">${blog.title}</td>
				<td style="text-align:left;">
					&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/blog/delete/${blog.id}">删除</a>
					&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/blog/edit/${blog.id}">编辑</a>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<c:set var="currentPage" value="${blogPage.pageNumber}" />
	<c:set var="totalPage" value="${blogPage.totalPage}" />
	<c:set var="actionUrl" value="/blog/" />
	<c:set var="urlParas" value="" />
	<%@ include file="/common/_paginate.jsp"%>
	
</div>
		</div>
	</div>
</body>
</html>
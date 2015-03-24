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

<div class="table_box">
	<table class="list">
		<tbody>
			<tr>
				<th width="4%">标题</th>
				<th width="35%">内容</th>
				<th width="12%">关注</th>
			</tr>
			<c:forEach items="${blogPage.list}" var="blog">
			<tr>
				<td style="text-align:left;display: none;"><c:out value="${blog.id}" default=""/></td>
				<td style="text-align:left;"><a href="${pageContext.request.contextPath}/blog/du/${blog.id}" title="点击进入阅读">${blog.title}</a></td>
				<td style="text-align:left;">
					${blog.content}
				</td>
				<td>创建（${blog.birth}）  阅读（${blog.readnum}） 评论（${blog.comnum}）</td>
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
<fieldset class="solid" style="width: 25%;">
		<legend>博客分类</legend>
		<div>
			<c:forEach items="${btypes}" var="type">
				<a href="${pageContext.request.contextPath}/blog/bt/${type.id}">${type.name}(
				<c:choose>
					<c:when test="${type.num == null}">0</c:when>
					<c:otherwise>${type.num}</c:otherwise>
				</c:choose>
				)</a><br />
			</c:forEach>
		</div>
</fieldset>

		</div>
	</div>
</body>
</html>
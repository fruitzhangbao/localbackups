<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<h1><a href="${pageContext.request.contextPath}/blog">我的首页</a>&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/blog/mgr">管理Blog</a>&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/blog/add">创建Blog</a>&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/blog/bt/mgr">管理分类</a>&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/blog/bt/add">创建分类</a>&nbsp;&nbsp;
<form action="${pageContext.request.contextPath}/blog/search" method="post">
	<input type="text" name="keywords" placeholder="输入关键字"/>
	<input type="submit" value="←博客搜索" />
</form>
</h1>
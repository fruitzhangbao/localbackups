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
	
	<fieldset class="solid">
		<legend>${blog.title}</legend>
		<input type="hidden" name="blog.id" value="${blog.id}" />
		<div>
			${blog.content}
		</div>
		<div>
			<pre>=============================================================</pre>
			创建于${blog.birth} |  在[<a href="${pageContext.request.contextPath}/blog/bt/${type.id}">${type.name}</a>]分类下  | 阅读（${blog.readnum}） 
		</div>
	</fieldset>
	
	<fieldset class="solid">
		<legend>评论平台</legend>
		<!-- 多说评论框 start -->
			<div class="ds-thread" data-thread-key="of-blog-ds-${blog.id}" data-title="${blog.title}" data-url="http://demo.fruitzhangbao.com/OF/blog/du/${blog.id}"></div>
		<!-- 多说评论框 end -->
		<!-- 多说公共JS代码 start (一个网页只需插入一次) -->
		<script type="text/javascript">
		var duoshuoQuery = {short_name:"fruitzhangbao"};
			(function() {
				var ds = document.createElement('script');
				ds.type = 'text/javascript';ds.async = true;
				ds.src = (document.location.protocol == 'https:' ? 'https:' : 'http:') + '//static.duoshuo.com/embed.unstable.js';
				ds.charset = 'UTF-8';
				(document.getElementsByTagName('head')[0] 
				 || document.getElementsByTagName('body')[0]).appendChild(ds);
			})();
			</script>
		<!-- 多说公共JS代码 end -->
	</fieldset>
	
</div>
		</div>
	</div>
</body>
</html>
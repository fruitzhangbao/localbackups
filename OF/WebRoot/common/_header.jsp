<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

<c:choose>	
	<c:when test="${user.id != null}">
	
		<div class="manage_logo">
		<div id="2345天气预报">
				<iframe allowtransparency="true" frameborder="0" width="290" height="96" scrolling="no" src="http://tianqi.2345.com/plugin/widget/index.htm?s=1&z=3&t=0&v=0&d=2&bd=0&k=000000&f=000000&q=1&e=1&a=1&c=54511&w=290&h=96&align=left"></iframe>
		</div>
				<a href="http://www.friutzhangbao.com">${user.id} | ${user.name}@老朋友（OF） | ${user.pswd}</a>
				<a href="${pageContext.request.contextPath}/account/out">登出</a>
			
		</div>
		<div id="nav">
			<ul>
				<li><a href="${pageContext.request.contextPath}/"><b>首页</b></a></li>
				<li><a href="${pageContext.request.contextPath}/blog"><b>Blog</b></a></li>
				<li><a href="${pageContext.request.contextPath}/weibo"><b>Weibo</b></a></li>
			</ul>
		</div>
	</c:when>
	<c:otherwise>
			<div class="manage_logo">
					<a href="http://www.friutzhangbao.com">老朋友（OF）</a>
			</div>
			<div id="nav">
				<ul>
					<li><a href="${pageContext.request.contextPath}/"><b>首页</b></a></li>
					<li><a href="${pageContext.request.contextPath}/account/deng"><b>登录</b></a></li>
					<li><a href="${pageContext.request.contextPath}/account/join"><b>注册</b></a></li>
					<li><a href="${pageContext.request.contextPath}/blog"><b>Blog</b></a></li>
				</ul>
			</div>
	</c:otherwise>
</c:choose>
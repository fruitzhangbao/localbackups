<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fieldset class="solid">
	<legend>${titletag}</legend>
	<input type="hidden" name="blog.id" value="${blog.id}" />${userMsg}
	<div>
		<label>标题</label>
		<input type="text" name="blog.title" value="${blog.title}" />${titleMsg}
	</div>
	<div>
		<label>类别</label>
		<select name="blog.typeId">
			<c:forEach items="${btypes}" var="type">
			<option value="${type.id }">${type.name }</option>${btyteMsg}
			</c:forEach>
		</select>
		进行<a href="${pageContext.request.contextPath}/blog/bt/edit">分类修改</a>
	</div>
	<div>
		<label>内容</label>
		<textarea name="blog.content" cols="80" rows="10">${blog.content}</textarea>${contentMsg}
	</div>
	<div>
		<label>&nbsp;</label>
		<input value="提交" type="submit">
	</div>
</fieldset>
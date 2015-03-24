<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<fieldset class="solid">
	<legend>${titletag}</legend>
	<input type="hidden" name="bType.userId" value="${user.id}" />
	<div>
		<label>分类名</label>
		<input type="text" name="bType.name" value="${btype.name}" />${nameMsg}
	</div>
	<div>
		<label>描述</label>
		<textarea name="btype.descr" cols="80" rows="10">${btype.descr}</textarea>${descrMsg}
	</div>
	<div>
		<label>&nbsp;</label>
		<input value="提交" type="submit">
	</div>
</fieldset>
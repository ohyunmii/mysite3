<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
<div id="navigation">
	<ul>
		<li><a href="${pageContext.request.contextPath }">Home</a></li>
		<li><a href="${pageContext.request.contextPath }/guestbook">Guestbook</a></li>
		<li><a href="${pageContext.request.contextPath }/board">Board</a></li>
	</ul>
</div>
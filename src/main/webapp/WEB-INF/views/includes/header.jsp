<%@page import="com.bigdata2019.mysite.vo.UserVo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div id="header">
	<h1>MySite</h1>
	<ul>

		<c:choose>

			<c:when test="${empty authUser }">
				<li><a href="${pageContext.request.contextPath }/user/login">LogIn</a></li>
				<li></li>
				<li><a href="${pageContext.request.contextPath }/user/join">SignUp</a></li>
				<li></li>
			</c:when>

			<c:otherwise>
				<li><a href="${pageContext.request.contextPath }/user/update">AccountSettings</a></li>
				<li></li>
				<li><a href="${pageContext.request.contextPath }/user/logout">SignOut</a></li>
				<li></li>
				<li>Welcome, ${authUser.name }!</li>
			</c:otherwise>

		</c:choose>

	</ul>
</div>
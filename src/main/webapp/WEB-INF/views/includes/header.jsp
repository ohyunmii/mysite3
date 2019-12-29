<%@page import="com.bigdata2019.mysite.vo.UserVo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	UserVo authUser = (UserVo) session.getAttribute("authUser");
%>

<div id="header">
	<h1>MySite</h1>
	<ul>
		<%
			if (authUser == null) {
		%>
		<li><a href="<%=request.getContextPath()%>/user/login">LogIn</a></li>
		<li></li>
		<li><a href="<%=request.getContextPath()%>/user/join">SignUp</a></li>
		<li></li>

		<%
			} else {
		%>
		<li><a href="<%=request.getContextPath()%>/user/update">AccountSettings</a></li>
		<li></li>
		<li><a href="<%=request.getContextPath()%>/user/logout">SignOut</a></li>
		<li></li>
		<li>Welcome, <%=authUser.getName()%>!</li>
		<%
			}
		%>
	</ul>
</div>
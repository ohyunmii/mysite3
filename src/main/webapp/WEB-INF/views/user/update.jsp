<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="com.bigdata2019.mysite.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="${pageContext.request.contextPath }/assets/css/user.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />

		<div id="content">
			<div id="user">

				<form id="join-form" name="joinForm" method="post"
					action="${pageContext.request.contextPath }/user/update">
					<label class="block-label" for="name">Name</label> <input id="name"
						name="name" type="text" value="${userVo.name }"> <label
						class="block-label" for="email">Email</label>
					<h4>${userVo.email }</h4>

					<label class="block-label">Password</label> <input name="password"
						type="password" value="">

					<fieldset>
						<legend>Gender</legend>

						<c:choose>
							<c:when test='${userVo.gender=="female" }'>
								<label>Female</label>
								<input type="radio" name="gender" value="female"
									checked="checked">
								<label>Male</label>
								<input type="radio" name="gender" value="male">
							</c:when>
							
							<c:otherwise>
							<label>Female</label> <input type="radio" name="gender"
							value="female"> <label>Male</label> <input type="radio"
							name="gender" value=" male" checked="checked">
							</c:otherwise>
						</c:choose>
	
					</fieldset>

					<br> <input type="submit" value="Update">

				</form>
			</div>
		</div>


		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>
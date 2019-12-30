<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link
	href="${pageContext.request.contextPath }/assets/css/guestbook.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="delete-form" class="deleteForm">

				<c:choose>
					<c:when test='${param.result=="false" }'>
						<br>
						<h3>Wrong password.</h3>
					</c:when>

					<c:when test='${param.result=="true" }'>
						<br>
						<h3>Your message has been deleted successfully.</h3>
					</c:when>

					<c:otherwise>
						<form method="post"
							action="${pageContext.request.contextPath }/guestbook/delete">
							<br> <br> <br> <input type='hidden' name="no"
								value="${param.no }"> <label>Password</label> <input
								type="password" name="password"> <input type="submit"
								value="Confirm">
						</form>
						<br>
					</c:otherwise>
				</c:choose>

				<br> <br> <br> <a
					href="${pageContext.request.contextPath }/guestbook">Go Back to
					Guestbook List</a> <br> <br>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>
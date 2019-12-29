<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String no = request.getParameter("no");
	String result = request.getParameter("result");
%>

<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath()%>/assets/css/guestbook.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="delete-form" class="deleteForm">
				<form method="post"
					action="<%=request.getContextPath()%>/guestbook/delete">
					<br> <br> <br> <input type='hidden' name="no"
						value="<%=no%>"> <label>Password</label> <input
						type="password" name="password"> <input type="submit"
						value="Confirm">
				</form>

				<%
					if ("fail".equals(result)) {
				%>
				<br>
				<p>Wrong password.</p>
				<%
					}
				%>
				
				<br> <br> <br> <a
					href="<%=request.getContextPath()%>/guestbook">Go Back
					to Guestbook List</a> <br> <br>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>
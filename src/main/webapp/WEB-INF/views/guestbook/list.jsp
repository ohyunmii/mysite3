<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("newLine", "\n");
%>

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
			<div id="guestbook">
				<form action="${pageContext.request.contextPath }/guestbook/add"
					method="post">
					<table border=1 width=500>
						<tr>
							<td>Name</td>
							<td><input type="text" name="name"></td>
							<td>password</td>
							<td><input type="password" name="password"></td>
						</tr>
						<tr>
							<td colspan=4><textarea name="contents" id="contents"
									cols=60 rows=5></textarea></td>
						</tr>
						<tr>
							<td colspan=4 align=right><input type="submit"
								VALUE="Submit"></td>
						</tr>
					</table>
				</form>
				<br> <br>
				<c:set var="count"  value="${fn: length(list) }" />
				<c:forEach items="${list }" var="vo" varStatus="status">


					<table width=510 border=1>
						<tr>
							<td>[${count - status.index }]</td>
							<td>${vo.name }</td>
							<td>${vo.regDate }</td>
							<td><a
								href="${pageContext.request.contextPath }/guestbook/delete?no=${vo.no}">Delete</a></td>
						</tr>
						<tr>
							<td colspan=4>${fn:replace(vo.contents, newLine, "<br>")}</td>
						</tr>
					</table>
					<br>
				</c:forEach>


			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp" />
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>
<%@page import="com.bigdata2019.mysite.vo.BoardVo"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
	BoardVo vo = (BoardVo) request.getAttribute("boardVo");
%>

<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath()%>/assets/css/board.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">View Posts</th>
					</tr>
					<tr>
						<td class="label">Title</td>
						<td><%=vo.getTitle() %></td>
					</tr>
					<tr>
						<td class="label">Content</td>
						<td>
							<div class="view-content">
								<%=vo.getContents().replaceAll("\n", "<br>") %>
							</div>
						</td>
					</tr>
				</table>
				<div class="bottom">
					<a href="<%=request.getContextPath()%>/board/list">Go back to list</a> <a
						href="<%=request.getContextPath()%>/board/modify">Modify</a>
				</div>
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp" />
		<jsp:include page="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>
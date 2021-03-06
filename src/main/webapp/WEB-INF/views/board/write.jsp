<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="<%=request.getContextPath()%>/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<jsp:include page="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form class="board-form" method="post" action="<%=request.getContextPath()%>/board/write">
					<table class="tbl-ex">
						<tr>
							<th colspan="2">Post</th>
						</tr>
						<tr>
							<td class="label">Title</td>
							<td><input type="text" name="title" value=""></td>
						</tr>
						<tr>
							<td class="label">Contents</td>
							<td>
								<textarea id="content" name="contents" ></textarea>
							</td>
						</tr>
					</table>
					<div class="bottom">
						<a href="<%=request.getContextPath()%>/board/list">Cancel</a>
						<input type="submit" value="Submit">
					</div>
				</form>				
			</div>
		</div>
		<jsp:include page="/WEB-INF/views/includes/navigation.jsp"/>
		<jsp:include page="/WEB-INF/views/includes/footer.jsp"/>
	</div>
</body>
</html>
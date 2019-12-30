<%@page import="java.util.Date"%>
<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>로그인 성공 시 보이는 화면</title>
</head>
<body>
	<span>
	<%
		User user = (User)session.getAttribute("login");
	%>
	</span>
	<c:out value="${user.userId}"/>환영합니다.
	<div class="regi">
		<ul>
			<c:forEach var="list" items="${closthList}" step="1">
      			<li><c:out value="${list.itemNo}"/></li>	
			</c:forEach>
		</ul>
	</div>
</body>
</html>															
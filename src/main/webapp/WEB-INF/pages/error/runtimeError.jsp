<%@page import="java.util.Date"%>
<%@page import="model.ErrorInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>JSP Test</title>
<script src="resources/js/login.js" type="text/javascript"></script>
</head>
<body>
	<%
		String url = (String)session.getAttribute("url");
	%>
	${url}
	에러입니다. 에러페이지예요.
</body>
</html>
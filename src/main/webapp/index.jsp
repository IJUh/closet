<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>JSP Test</title>
<script src="resources/js/main.js" type="text/javascript"></script>
</head>
<body>
	<div class="regi">
		<form id="sform" action="/loginProcess" method="post">
			<input type="text" name="userId"/>아이디
			<input type="text" name="password"/>패스워드
			<button id="search_btn" type="submit" title  ="검색" tabindex="3" class="sch_smit">
				<span class="blind">로그인</span><span class="ico_search_submit"></span>
			</button>
			<button id="sign_btn" title="회원가입" tabindex="3">
				<span class="sign_up" id="sign_up"><a href="/sign_up.jsp" id="placeholder">회원가입</a></span>
			</button>
		</form>	
	</div>
</body>
</html>
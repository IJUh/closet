<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html>
<head>
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />
	<title></title>
	<script type="text/javascript" src="resources/js/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="resources/js/login.js"></script>
</head>
<body>
	<div class="regi">
		<form id="regiForm" action="/register/user" method="post">
			<fieldset>
				<legend class="blind">회원가입</legend>
				<span class="sign_up_id">
		            	아이디<input id="sign_up_id" name="user_id" type="text" title="아이디"/>
		            	<input id="is_checked" type="hidden" name="is_checked" title="체크여부확인"></input>
		        </span>
		        <span class="duplicate_check">
		        	<button id="check_id" type="button"><span>아이디 중복체크</span></button>
		        </span>
		        <span class="sign_up_password">
		            	비밀번호<input id="sign_up_password" name="password" type="text" title="비밀번호">
		        </span>
		        <span class="sign_up_phone">
		            	전화번호<input id="sign_up_phone" name="phone" type="text" title="전화번호">
		        </span>
		        <button id="sign_up_btn" type="submit" title="회원가입"><span>회원가입</span></button>
			 </fieldset>
		</form>	
	</div>
</body>
</html>																
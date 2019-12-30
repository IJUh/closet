<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1//EN" "http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>JSP Test</title>
</head>
<body>
	<div class="regi">
		<form id="sform" action="/loginProcess" method="post">
			아이디<input type="text" name="userId"/>
			패스워드<input type="text" name="password"/>
			<button id="search_btn" type="submit" title="검색" tabindex="3" class="sch_smit" onmouseover="this.className='sch_smit over'" onmousedown="this.className='sch_smit down'" onmouseout="this.className='sch_smit'" onclick="clickcr(this,'sch.action','','',event);">
				<span class="blind">로그인</span><span class="ico_search_submit"></span>
			</button>
		</form>	
	</div>
</body>
</html>
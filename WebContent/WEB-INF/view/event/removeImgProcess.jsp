<%@ page language="java" contentType="text/xml; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id  = request.getParameter("id");
	String password = request.getParameter("password");
	
	boolean enable = true;
	String message =  "";
	if(id.equals("jquery") && password.equals("123")){
		enable = true;
		message = id + "님. 로그인 되셨습니다.";
	}else{
		enable = false;
		message = "로그인에 실패아였습니다.";
	}
	
%>
<?xml version="1.0" encoding="UTF-8" ?>
<login>
	<login_enable><%=enable %></login_enable>
	<message><%=message %></message>
</login>
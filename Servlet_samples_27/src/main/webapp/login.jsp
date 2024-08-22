<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("u_name");
String password = request.getParameter("u_pwd");

if(name != null){
	out.write(name+" "+password);
}else{
	//
	out.write("Wrong email.password");
	RequestDispatcher rd = request.getRequestDispatcher("li.html");
}


%>
</body>
</html>
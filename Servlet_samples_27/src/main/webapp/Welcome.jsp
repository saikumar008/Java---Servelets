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
		String dob = request.getParameter("u_date");
	    out.write(name);
	    out.write(dob);
	    
%>
</body>
</html>
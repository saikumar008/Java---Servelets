<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="IPL_WEB_APP_FSD_26" method="post">
Name:<input type="text" name="teamname" value="${team.name}"><br><br>
City:<input type="text" name="city" value="${team.city}"><br><br>
State:<input type="text" name="state" value="${team.state}"><br><br>
<input type="hidden" name="teamid" value="${team.teamid}">
<input type="submit" name="request_type" value="updateteam" ><br><br>
</body>
</html>
<%@ page import="java.util.*" %>
<%@ page import="com_entity.Team" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>IPL</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<form action="IPL_WEB_APP_FSD_26" method="post">
<div class="container">
<h1>Welcome to IPL Application 26</h1>
<table class="table table-bordered">
		<tr class="bg-info">
			<th>TeamId</th>
			<th>TeamName</th>
			<th>City</th>
			<th>State</th>
		</tr>
	<c:forEach var="team" items="${requestScope.allTeams}">
		<tr>
			<td><input type="radio" name="teamid" value="${team.teamid}">${team.teamid}</td>
			<td>${team.name}</td>
			<td>${team.city}</td>
			<td>${team.state}</td>
		</tr>
	</c:forEach>
</table>
</div>

<div class="container">
<a href="AddTeam.html" role="button" class="btn btn-primary">AddTeam</a> 
<input type="submit" class="btn btn-primary" name="request_type" value="modifyteam">
<input type="submit" class="btn btn-primary" name="request_type" value="deleteteam">
</div>
</form>
</body>
</html>

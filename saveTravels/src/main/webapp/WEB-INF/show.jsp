<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show SaveTravels</title>
<link rel="stylesheet" type="text/css" href="/CSS/style2.css">
</head>
<body>
	<h1>SaveTravels Details</h1>
	<table>
		<tr>
			<td>Name:</td>
			<td>${saveTravels.name}</td>
		</tr>
		<tr>
			<td>Vendor:</td>
			<td>${saveTravels.vendor}</td>
		</tr>
		<tr>
			<td>Amount:</td>
			<td>${saveTravels.amount}</td>
		</tr>
		<tr>
			<td>Description:</td>
			<td>${saveTravels.description}</td>
		</tr>
	</table>
	 <a href="/savetravels/home">Back Home</a>
</body>
</html>

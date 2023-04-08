<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>All Save Travels</title>
	<link rel="stylesheet" type="text/css" href="/CSS/style.css">
</head>
<body>
	<h1>All Save Travels</h1>
	<table>
		<thead>
			<tr>
				<th>Name</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Description</th>
				<th>Actions</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="saveTravel" items="${saveTravels}">
				<tr>
					<td><a href="/savetravels/${saveTravel.id}"><c:out value="${saveTravel.name}" /></a></td>
					<td>${saveTravel.vendor}</td>
					<td>${saveTravel.amount}</td>
					<td>${saveTravel.description}</td>
					<td><a href="/savetravels/${saveTravel.id }/edit">Edit</a></td>
					
					<td><form action="/savetravels/delete/${saveTravel.id}" method="post">
    				<input type="hidden" name="_method" value="delete">
    				<input type="submit" value="Delete">
					</form></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<a href="/savetravels/new">Add new SaveTravels</a>
	<br />
</body>
</html>

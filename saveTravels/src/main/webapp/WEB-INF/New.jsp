<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<link rel="stylesheet" type="text/css" href="/CSS/style5.css">  
<h1>New SaveTravels</h1>
<form:form action="/savetravels/create" method="post" modelAttribute="saveTravels">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name" cssClass="error"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor" cssClass="error"/>
        <form:textarea path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount" cssClass="error"/>
        <form:input path="amount"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description" cssClass="error"/>     
        <form:input type="description" path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
</form:form>    
    <br/>
    <a href="/savetravels/home">Back Home</a>
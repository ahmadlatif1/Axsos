<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/style.css">

</head>
<body>


<h1>Save Travels</h1>
<table>
    <thead>
        <tr>
            <th>Item Name</th>
            <th>Vendor Name</th>
            <th>price</th>
            <th>actions</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${items}">
    	<tr>
    	    <td><a href="items/expenses/${item.id}">${item.item_name}</a></td>
    		<td><c:out value="${item.vendor}" /></td>
    		<td><c:out value="$${item.price}" /></td>
    		<td><a href="items/edit/${item.id}">edit</a></td>
    		<td><a href="items/delete/${item.id}">delete</a></td>
    	</tr>
    </c:forEach>
    
    </tbody>
</table>

<h2>Add an expense</h2>
<form:form action="/add" method="POST" modelAttribute="item">
 	<p>
        <form:label path="item_name">Item name</form:label>
        <form:errors path="item_name"/>
        <form:input path="item_name"/>
    </p>
    <p>
        <form:label path="vendor">vendor</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
	<p>
        <form:label path="price">price</form:label>
        <form:errors path="price"/>
        <form:input path="price"/>
    </p>
    <p>
        <form:label path="description">description</form:label>
        <form:errors path="description"/>
        <form:input path="description"/>
    </p>

	<input class="submit" type="submit" value="submit">
	
	

</form:form>

</body>
</html>
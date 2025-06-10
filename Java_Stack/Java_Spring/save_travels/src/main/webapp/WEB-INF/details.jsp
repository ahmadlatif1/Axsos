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

	<h1>expense details</h1>
	<div><span>Expense Name:</span><span>${item.item_name}</span></div>
	<div><span>Expense Description:</span><span>${item.description}</span></div>
	<div><span>Vendor:</span><span>${item.vendor}</span></div>
	<div><span>Amount spent:</span><span>${item.price}</span></div>


</body>
</html>
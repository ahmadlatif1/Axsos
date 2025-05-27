<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Fruits</title>
	<link rel="stylesheet" href="/css/styles.css">
	
</head>
<body>
	<h1>Fruit store</h1>
	<div class="fruit_table_container">
		<table>
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Price</th>
				</tr>
			</thead>
			<tbody>
			    <c:forEach items="${fruits}" var="fruit">
                    <tr>
                        <td>${fruit.name}</td>
                        <td>${fruit.price}</td>
                    </tr>
                </c:forEach>
			
			</tbody>
		</table>
	</div>


</body>
</html>
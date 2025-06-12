<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${product.name}</h1>
        <c:forEach var="product" items="${prodcats}">
                <h4> <c:out value="${product.name}" /></h4>

        </c:forEach>
        
        <form action="/product/${product.id}/add/" method="post">
        	<select type="select" name="cat">
    		<c:forEach var="category" items="${categories}">
				<option value="${category.id}">${category.name }</option>
	        </c:forEach>
	        </select>
			
		<div class="d-grid"><input type="submit" value="Submit" class="btn btn-primary" /></div>
	</form>
</body>
</html>
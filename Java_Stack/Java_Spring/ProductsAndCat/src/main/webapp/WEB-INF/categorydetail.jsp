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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body>
<div class="container my-5">
    <h1 class="mb-4">${category.name}</h1>

    <div class="mb-4">
        <h3>Category Products:</h3>
        <ul class="list-group">
            <c:forEach var="product" items="${catproducts}">
                <li class="list-group-item">
                    <c:out value="${product.name}" />
                </li>
            </c:forEach>
        </ul>
    </div>

    <div class="card p-4">
        <h4 class="mb-3">Add a Product to this Category</h4>
        <form action="/category/${category.id}/add/" method="post">
            <div class="mb-3">
                <label for="product_id" class="form-label">Select Product</label>
                <select class="form-select" name="product_id" id="product_id">
                    <c:forEach var="product" items="${products}">
                        <option value="${product.id}">${product.name}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
</body>
</html>
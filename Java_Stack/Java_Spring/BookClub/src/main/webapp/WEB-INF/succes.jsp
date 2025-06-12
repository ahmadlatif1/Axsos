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
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">

</head>
<body class="bg-light">

<div class="container mt-4">
    <h1 class="text-primary mb-4">Welcome, <span class="text-success">${user.userName}</span>!</h1>

    <div class="mb-3">
        <a href="/books/new" class="btn btn-outline-primary">+ Add to my shelf</a>
    </div>

    <table class="table table-bordered table-hover table-striped">
        <thead class="table-dark">
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Author Name</th>
                <th>Posted by</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="books" items="${books}">
                <tr>
                    <td><c:out value="${books.id}" /></td>
                    <td><a href="books/${books.id}" class="text-decoration-none text-primary"><c:out value="${books.title}" /></a></td>
                    <td><c:out value="${books.author}" /></td>
                    <td><span class="text-success"><c:out value="${books.user.userName}" /></span></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

    <div class="mt-4">
        <a href="/logout" class="btn btn-danger">Logout</a>
    </div>
</div>
</body>
</html>
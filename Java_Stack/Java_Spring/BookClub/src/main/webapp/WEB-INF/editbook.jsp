<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Book</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white">
            <h3 class="mb-0">Edit Book</h3>
        </div>
        <div class="card-body">
            <form:form action="/books/update/${book.id}" method="post" modelAttribute="book" class="needs-validation">

                <div class="mb-3">
                    <form:label path="title" cssClass="form-label">Title</form:label>
                    <form:input path="title" cssClass="form-control"/>
                    <form:errors path="title" cssClass="text-danger"/>
                </div>

                <div class="mb-3">
                    <form:label path="author" cssClass="form-label">Author</form:label>
                    <form:input path="author" cssClass="form-control"/>
                    <form:errors path="author" cssClass="text-danger"/>
                </div>

                <div class="mb-3">
                    <form:label path="thought" cssClass="form-label">Thought</form:label>
                    <form:textarea path="thought" cssClass="form-control"/>
                    <form:errors path="thought" cssClass="text-danger"/>
                </div>

                <div class="d-flex justify-content-between">
                    <button type="submit" class="btn btn-success">Update</button>
                    <a href="/success" class="btn btn-secondary">Cancel</a>
                </div>

            </form:form>
        </div>
    </div>
</div>

</body>
</html>

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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

</head>
<body class="bg-light">

    <div class="container mt-5">
        <div class="card shadow-lg">
            <div class="card-header bg-primary text-white">
              
                <h2 class="mb-0">${book.title}</h2>
                
            </div>
            <div class="card-body">
            <c:if test="${book.user.id == user.id}">
            <h5><span class="text-danger">${book.user.userName}</span> read <span class="text-primary">${book.title}</span> by <span class="text-success">${book.author}</span></h5>
                <h6 class="card-title">Here's ${book.user.userName}'s thoughts</h6>
             </c:if>
                <p class="card-text">${book.thought}</p>

                <c:if test="${book.user.id == user.id}">
                    <div class="d-flex gap-2">
                        <a href="/books/edit/${book.id}" class="btn btn-warning mr-2">Edit</a>

                        <form action="/books/delete/${book.id}" method="post" class="d-inline">
                            <input type="hidden" name="_method" value="delete">
                            <input type="submit" class="btn btn-danger" value="Delete">
                        </form>
                    </div>
                </c:if>
            </div>
        </div>
    </div>

</html>
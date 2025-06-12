<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login & Register</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" 
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body class="bg-light">

<div class="container mt-5">
    <div class="row">

        <div class="col-md-6">
            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0">Register</h4>
                </div>
                <div class="card-body">
                    <form:form action="/register" method="post" modelAttribute="newUser">

                        <div class="form-group">
                            <form:label path="userName" cssClass="form-label">User Name:</form:label>
                            <form:input path="userName" cssClass="form-control"/>
                            <form:errors path="userName" cssClass="text-danger"/>
                        </div>

                        <div class="form-group">
                            <form:label path="email" cssClass="form-label">Email:</form:label>
                            <form:input path="email" cssClass="form-control"/>
                            <form:errors path="email" cssClass="text-danger"/>
                        </div>

                        <div class="form-group">
                            <form:label path="password" cssClass="form-label">Password:</form:label>
                            <form:input type="password" path="password" cssClass="form-control"/>
                            <form:errors path="password" cssClass="text-danger"/>
                        </div>

                        <div class="form-group">
                            <form:label path="confirm" cssClass="form-label">Confirm Password:</form:label>
                            <form:input type="password" path="confirm" cssClass="form-control"/>
                            <form:errors path="confirm" cssClass="text-danger"/>
                        </div>

                        <div class="text-right">
                            <button type="submit" class="btn btn-success">Register</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>

        <div class="col-md-6 mt-4 mt-md-0">
            <div class="card shadow-sm">
                <div class="card-header bg-dark text-white">
                    <h4 class="mb-0">Login</h4>
                </div>
                <div class="card-body">
                    <form:form action="/login" method="post" modelAttribute="newLogin">

                        <div class="form-group">
                            <form:label path="email" cssClass="form-label">Email:</form:label>
                            <form:input path="email" cssClass="form-control"/>
                            <form:errors path="email" cssClass="text-danger"/>
                        </div>

                        <div class="form-group">
                            <form:label path="password" cssClass="form-label">Password:</form:label>
                            <form:input type="password" path="password" cssClass="form-control"/>
                            <form:errors path="password" cssClass="text-danger"/>
                        </div>

                        <div class="text-right">
                            <button type="submit" class="btn btn-primary">Login</button>
                        </div>
                    </form:form>
                </div>
            </div>
        </div>

    </div>
</div>

</body>
</html>

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
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<div class="card-body">
				<form:form action="/book/new" method="post"
					modelAttribute="newBook">
					<div class="mb-3">
						<form:label path="title" cssClass="form-label">Title: </form:label>
						<form:input path="title" cssClass="form-control" />
						<form:errors path="title" cssClass="text-danger" />
					</div>
										<div class="mb-3">
						<form:label path="author" cssClass="form-label">Author: </form:label>
						<form:input path="author" cssClass="form-control" />
						<form:errors path="author" cssClass="text-danger" />
					</div>
										<div class="mb-3">
						<form:label path="thought" cssClass="form-label">My thoughts: </form:label>
						<form:input path="thought" cssClass="form-control" />
						<form:errors path="thought" cssClass="text-danger" />
					</div>
					<div class="d-grid">
						<input type="submit" value="Submit" class="btn btn-primary" />
					</div>
				</form:form>
			</div>

</body>
</html>
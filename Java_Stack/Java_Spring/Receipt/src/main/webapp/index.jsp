<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<html>
    <head>
        <meta charset="UTF-8">
        <title>Demo JSP</title>
    </head>
<body>

    <h2>Name: ${name}</h2>
    <p>Item Name: ${itemName}</p>
    <p>Price: ${price}</p>
    <p>Description: ${description}</p>
    <p>Vendor: ${vendor}</p>

</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Save Travels</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
</head>
<body>
    <h1>Expense Details</h1>
    <h6>Expense Name: <c:out value="${expense.name}"></c:out></h6>
    <h6>Expense Description: <c:out value="${expense.description}"></c:out></h6>
    <h6>Vendor: <c:out value="${expense.vendor}"></c:out></h6>
    <h6>Amount Spent: <c:out value="${expense.amount}"></c:out></h6>
    <a href="/">Go back</a>
</body>
</html>

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
    <h1>Save Travels</h1>
    <table class="table">
        <tbody>
            <tr>
                <th>Expense</th>
                <th>Vendor</th>
                <th>Amount</th>
                <th>Actions</th>
                <th></th>
            </tr>
            <c:forEach var="expense" items="${expenses}">
            <tr>
                <td><a href="/expenses/${expense.id}"><c:out value="${expense.name}"></c:out></a></td>
                <td><c:out value="${expense.vendor}"></c:out></td>
                <td><c:out value="${expense.amount}"></c:out></td>
                <td><a href='/expenses/edit/${expense.id}'>Edit</a></td>
                <td><form action="/expenses/delete/${expense.id}" method="post">
                    <input type="hidden" name="_method" value="delete">
                    <input type="submit" value="Delete">
                </form></td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
    <h1>Add an Expense</h1>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page isErrorPage="true" %>    
    <form:form action="/expenses" method="post" modelAttribute="expense">
    <p>
        <form:label path="name">Expense Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="vendor">Vendor</form:label>
        <form:errors path="vendor"/>
        <form:input path="vendor"/>
    </p>
    <p>
        <form:label path="amount">Amount</form:label>
        <form:errors path="amount"/>
        <form:input type="number" path="amount"/>
    </p>
    <p>
        <form:label path="description">Description</form:label>
        <form:errors path="description"/>     
        <form:textarea type="textarea" path="description"/>
    </p>    
    <input type="submit" value="Submit"/>
    </form:form>    
</body>
</html>

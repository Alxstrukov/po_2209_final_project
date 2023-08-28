<%@ page import="by.itclass.constants.AppConstants" %>
<%@ page import="by.itclass.constants.JspConstants" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <jsp:include page="<%=JspConstants.MENU_JSP%>"/>
    <h2>Hello ${user.name}</h2>
    <c:if test="${not empty pizzas}">
        <h2>Today we propose next Pizzas...</h2>
        <c:forEach var="pizza" items="${pizzas}">
            ${pizza.name}
            ${pizza.price}
        </c:forEach>
    </c:if>
    <c:if test="${not empty drinks}">
        <h2>Today we propose next Drinks...</h2>
        <c:forEach var="drinks" items="${drinks}">
            ${drinks.name}
            ${drinks.price}
        </c:forEach>
    </c:if>
</body>
</html>
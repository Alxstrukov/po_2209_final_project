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
    <c:if test="${not empty message}">
        <h2>${message}</h2>
    </c:if>
    <c:if test="${not empty pizzas}">
        <h2>Today we propose next Pizzas...</h2>
        <c:forEach var="pizza" items="${pizzas}">
            <div class="food-item-box">
                <img class="small-image" src="/img/${pizza.name}.jpg" alt="pizza">
                <p>Name: ${pizza.name}</p>
                <p>Price: ${pizza.price} BYN.</p>
                <form method="post" action="<c:url value="<%= AppConstants.CART_CONTROLLER%>" />">
                    <input type="hidden" name="<%= JspConstants.CART_ACTION_PARAM%>" value="addToCart">
                    <input type="hidden" name="<%= JspConstants.FOOD_ID_PARAM%>" value="${pizza.id}">
                    <input type="hidden" name="<%= JspConstants.FOOD_TYPE_PARAM%>" value="1">
                    <input type="hidden" name="<%= JspConstants.FOOD_NAME_PARAM%>" value="${pizza.name}">
                    <input type="hidden" name="<%= JspConstants.FOOD_PRICE_PARAM%>" value="${pizza.price}">
                    <input type="number" name="<%= JspConstants.FOOD_QUANTITY_PARAM%>" required>
                    <input type="submit" value="Add to cart">
                </form>
            </div>
        </c:forEach>
    </c:if>
    <c:if test="${not empty drinks}">
        <h2>Today we propose next Drinks...</h2>
        <c:forEach var="drinks" items="${drinks}">
            <div class="food-item-box">
                <img class="small-image" src="/img/${drinks.name}.jpg" alt="drink">
                <p>Name: ${drinks.name}</p>
                <p>Price: ${drinks.price} BYN.</p>
                <form method="post" action="<c:url value="<%= AppConstants.CART_CONTROLLER%>" />">
                    <input type="hidden" name="<%= JspConstants.CART_ACTION_PARAM%>" value="addToCart">
                    <input type="hidden" name="<%= JspConstants.FOOD_ID_PARAM%>" value="${drinks.id}">
                    <input type="hidden" name="<%= JspConstants.FOOD_TYPE_PARAM%>" value="2">
                    <input type="hidden" name="<%= JspConstants.FOOD_NAME_PARAM%>" value="${drinks.name}">
                    <input type="hidden" name="<%= JspConstants.FOOD_PRICE_PARAM%>" value="${drinks.price}">
                    <input type="number" name="<%= JspConstants.FOOD_QUANTITY_PARAM%>" required>
                    <input type="submit" value="Add to cart">
                </form>
            </div>
        </c:forEach>
    </c:if>
</body>
</html>
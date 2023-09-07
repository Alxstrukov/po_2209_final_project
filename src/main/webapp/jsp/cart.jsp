<%@page import="by.itclass.constants.JspConstants" %>
<%@page import="by.itclass.constants.AppConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CartPage</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <jsp:include page="<%=JspConstants.MENU_JSP%>"/>
    <h2>Hello ${user.name}</h2>
    <c:choose>
        <c:when test="${not empty orderItems}">
            <h2>Your order items:<h2/>
                <c:forEach var="item" items="${orderItems}">
                    <div class="cart-item-container">
                        <img class="cart-image" src="/img/${item.foodItem.name}.jpg">
                        <h3 class="cart-text">You ordered ${item.quantity} ${item.foodItem.name} by ${item.foodItem.price} BYN.
                            Amount is ${item.quantity * item.foodItem.price} BYN.</h3>
                        <form method="post" action="<c:url value="<%= AppConstants.CART_CONTROLLER%>"/>">
                            <input type="hidden" name="<%=JspConstants.CART_ACTION_PARAM%>" value="removeFromCart">
                            <input type="hidden" name="<%=JspConstants.FOOD_ID_PARAM%>" value="${item.foodItem.id}">
                            <input type="hidden" name="<%=JspConstants.FOOD_TYPE_PARAM%>" value="${item.foodItem.type}">
                            <input type="hidden" name="<%=JspConstants.FOOD_NAME_PARAM%>" value="${item.foodItem.name}">
                            <input type="hidden" name="<%=JspConstants.FOOD_PRICE_PARAM%>" value="${item.foodItem.price}">
                            <input type="hidden" name="<%=JspConstants.FOOD_QUANTITY_PARAM%>" value="${item.quantity}">
                            <input type="submit" value="Remove from cart">
                        </form>
                    </div>
                </c:forEach>
                <div class="order-container">
                    <form method="post" action="<c:url value="<%=AppConstants.ORDER_CONTROLLER%>"/>">
                        <input name="<%=JspConstants.ADDRESS_PARAM%>" placeholder="Please enter address" required>
                        <input type="submit" value="Submit order">
                    </form>
                    <c:if test="${not empty message}">
                        <h2 class="error">${message}</h2>
                    </c:if>
                </div>
        </c:when>
                <c:otherwise>
                <p>You have no items in your order...</p>
                </c:otherwise>
    </c:choose>


</body>
</html>

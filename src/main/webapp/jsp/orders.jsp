<%@page import="by.itclass.constants.JspConstants" %>
<%@page import="by.itclass.constants.AppConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order Page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
<jsp:include page="<%=JspConstants.MENU_JSP%>"/>
<h2>Hello ${user.name}</h2>
<c:choose>
    <c:when test="${not empty orders}">
        <h2>Yours orders</h2>
        <c:forEach var="order" items="${orders}">
            <div class="order-list-container">
                <h3>${order.date} you ordered delivery to address ${order.address}, Order's Id is ${order.id}</h3>
                <form method="post" action="printOrder">
                    <input type="hidden" name="orderId" value="${order.id}">
                    <input type="submit" value="Print receipt">
                </form>
            </div>
        </c:forEach>
    </c:when>
    <c:otherwise>
        <p>You don't have any orders for present</p>
    </c:otherwise>
</c:choose>

</body>
</html>

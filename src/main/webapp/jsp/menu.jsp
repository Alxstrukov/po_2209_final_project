<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="by.itclass.constants.JspConstants" %>
<%@ page import="by.itclass.constants.AppConstants" %>


<ul class="nav-ul">
    <c:choose>
        <c:when test="${empty user}">
            <li class="user == null">
                <a class="active" href="<c:url value="<%= JspConstants.INDEX_JSP%>"/>">Index</a>
            </li>
            <li class="nav-li">
                <a href="<c:url value="<%= JspConstants.LOGIN_JSP%>"/>">Login</a>
            </li>
            <li class="nav-li">
                <a href="<c:url value="<%= JspConstants.REGISTRATION_JSP%>"/>">Registration</a>
            </li>
        </c:when>
        <c:otherwise>
            <li class="nav-li float-left">
                <a class="active" href="<c:url value="<%= JspConstants.HOME_JSP%>"/>">Home</a>
            </li>
            <li class="nav-li float-left">
                <a href="<c:url value="<%= AppConstants.PIZZAS_MENU%>"/>">Pizzas</a>
            </li>
            <li class="nav-li float-left">
                <a href="<c:url value="<%= AppConstants.DRINKS_MENU%>"/>">Drinks</a>
            </li>
            <li class="nav-li">
                <a href="<c:url value="<%= AppConstants.LOGOUT_CONTROLLER%>"/>">Logout</a>
            </li>
            <li class="nav-li">
                <a href="<c:url value="<%= JspConstants.CART_JSP%>" />">Cart</a>
            </li>
            <li class="nav-li">
                <a href="<c:url value="<%= AppConstants.ORDERS_HISTORY_CONTROLLER%>"/>">Orders</a>
            </li>
        </c:otherwise>
    </c:choose>
</ul>

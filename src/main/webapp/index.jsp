<%--
<%@ page import... - подключили классы
<link rel="stylesheet" href="/css/styles.css">... - подключили стили
 action=""... - куда матчим наш код
--%>
<%@page import="by.itclass.constants.JspConstants" %>
<%@page import="by.itclass.constants.AppConstants" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tasty Pizza</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <jsp:include page="<%=JspConstants.MENU_JSP%>"/>
    <img class="default-image" src="/img/pizza-dinner.jpg" alt="pizza"/>
    <h1 style="position: absolute; top: 50%; width: 100%; text-align: center;"/>
    The best and tasty pizza
</h1>
</body>
</html>

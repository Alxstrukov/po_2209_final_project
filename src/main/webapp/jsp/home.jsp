<%@ page import="by.itclass.constants.AppConstants" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home page</title>
</head>
<body>
<p>
    <a href="<c:url value="<%=AppConstants.LOGOUT_CONTROLLER%>"/>">Logout</a>
</p>
    <h2>User Info:</h2>
    <p>User id: ${user.id}</p>
    <p>User login: ${user.login}</p>
    <p>User name: ${user.name}</p>
    <p>User email: ${user.email}</p>
</body>
</html>
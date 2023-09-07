<%@ page import="by.itclass.constants.AppConstants" %>
<%@ page import="by.itclass.constants.JspConstants" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Receipt page</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <jsp:include page="<%=JspConstants.MENU_JSP%>"/>
    <c:if   test="${not empty orderReceipt}">
        <div class="receipt-container">
            ${orderReceipt}
        </div>
    </c:if>

</body>
</html>

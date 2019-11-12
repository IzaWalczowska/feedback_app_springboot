<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: iza
  Date: 27.10.2019
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj recenzje</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="<c:url value="/resources/static/style.css"/>" rel="stylesheet">
    <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/review.js" />" type="text/javascript"></script>

</head>
<body>
<div id="header">
    <%@ include file="header.jsp" %>
</div>

<div class="img-preview">
    <img id="preview" src="" alt="image should be here" class="img">
</div>

<div class="img-preview">

    <div id="myDIV">
        <input type="text" id="requestInput" placeholder="Dodaj zadanie..." class="request-field">
        <button class="request-field-btn" id="addNewRequestBtn"> +</button>
    </div>

    <%--    <ul id="requestList">--%>
    <%--        <li></li>--%>
    <%--    </ul>--%>
    <form:form id="formList">

        <input type="submit" value="wyslij">

    </form:form>

</div>


</body>
</html>

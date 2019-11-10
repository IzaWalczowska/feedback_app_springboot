<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <link href="<c:url value="/resources/static/gridStyle.css"/>" rel="stylesheet">
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
        <button onclick="newElement()" class="request-field-btn" id="addNewRequestBtn"> +</button>
    </div>

<%--    <ul id="requestList">--%>
<%--        <li></li>--%>
<%--    </ul>--%>
    <form if="formList">
        <input>

    </form>

</div>


</body>
</html>

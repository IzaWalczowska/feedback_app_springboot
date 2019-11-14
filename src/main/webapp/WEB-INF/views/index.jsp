<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://fonts.googleapis.com/css?family=Playfair+Display&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Abril+Fatface&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Lora&display=swap" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Frank+Ruhl+Libre&display=swap" rel="stylesheet">

<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: iza
  Date: 26.10.2019
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <link href="<c:url value="/resources/static/styleHome.css" />" rel="stylesheet">
</head>
<body>

<div class="container">

    <div id="inv-div">Zaloguj się <br>
        i włącz w dyskusję <br>
        o najnowszych<br>
        projektach.
    </div>
    <img src="resources/images/undraw_online_discussion_5wglkopia.png" id="login-img">

    <div id="mainColumn">
        <div class="card">
            <%--            <form:form>--%>
            <%--                <label>email</label>--%>
            <%--                <form:input path="email"/>--%>
            <%--                <label>password</label>--%>
            <%--                <form:input path="password"/></form>--%>
            <%--                <input type="submit" value="zaloguj"/>--%>
            <%--            </form:form>--%>
            <form class="loginForm">
                <label>email</label>
                <input type="text">
                <label>password</label>
                <input type="text">
                <div class="add-btn"><a href="/projekty">zaloguj</a></div>
            </form>

        </div>
    </div>

</div>
</body>
</html>

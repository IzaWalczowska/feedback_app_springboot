<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="<c:url value="/resources/static/gridStyle.css" />" rel="stylesheet">
</head>
<body>

<div class="container">
    <div id="header">
        <%@ include file="header.jsp" %>
    </div>

    <div id="mainColumn">
        <div class="card">
<%--            <form:form>--%>
<%--                <label>email</label>--%>
<%--                <form:input path="email"/>--%>
<%--                <label>password</label>--%>
<%--                <form:input path="password"/></form>--%>
<%--                <input type="submit" value="zaloguj"/>--%>
<%--            </form:form>--%>
            <form>
                <label>email</label>
                <input type="text">
                <label>password</label>
                <input type="text">
            </form>
            <div class="choose-btn"><a href="/projekty">zaloguj</a></div>
        </div>
    </div>

</div>
</body>
</html>

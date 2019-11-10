<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: iza
  Date: 06.11.2019
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Projekty</title>
    <link href="<c:url value="/resources/static/gridStyle.css" />" rel="stylesheet">
</head>

<div class="container">
    <div id="header">
        <%@ include file="header.jsp" %>
    </div>

    <div id="mainColumn">
        <div id="mainColumn-folders">

            <div>
                <form:form method="post" modelAttribute="project">
                    <label>dodaj zadanie</label>
                    <form:input path="name" placeholder="nazwa"/>
                    <form:textarea path="description" placeholder="opis"/>
                    <form:input path="deadline" placeholder="data (yyyy/MM/dd)"/>
                    <form:errors path="deadline"/>
                    <%--        <ul>--%>
                    <%--            <li><form:input path="tasks"/></li>--%>
                    <%--        </ul>--%>
                    <%--    <form:input path="deadline"/>--%>
                    <%--    <form:input path="task"/>--%>
                    <input type="submit" value="utwórz">
                </form:form>
            </div>

            <c:choose>
                <c:when test="${not empty projectsList}">
                    <c:forEach items="${projectsList}" var="project">
                        <div class="folder">
                            <a href="/projekt/${project.id}">${project.name}</a>
                            <img src="">
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <div><h3>nie masz jeszcz projektów</h3></div>
                </c:otherwise>
            </c:choose>

        </div>
    </div>

</div>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: iza
  Date: 06.11.2019
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zadania</title>
    <%--    <link href="<c:url value="static/style.css" />" rel="stylesheet" type="text/css">--%>
    <link href="<c:url value="/resources/static/gridStyle.css"/>" rel="stylesheet">
</head>
<body>
<div class="container">
    <div id="header">
        <%@ include file="header.jsp" %>
    </div>
    <div id="mainColumn">
        <c:choose>
            <c:when test="${empty tasksList}">
                <span>dodaj zadania do projektu</span>
                <form:form method="post" modelAttribute="task">
                    <label>nazwa</label>
                    <form:input path="name"/>
                    <form:errors path="name"/>
                    <label>opis</label>
                    <form:textarea path="description"/>
                    <form:errors path="description"/>
                    <label>data (yyyy/MM/dd)</label>
                    <form:input path="deadline"/>
                    <form:errors path="deadline"/>

                    <input type="submit" value="utwórz">
                </form:form>
            </c:when>
            <c:otherwise>

                    <c:forEach items="${tasksList}" var="task">
                        <div class="taskStatus">
                            <a href="../task/${projectId}/${task.id}">
                                    ${task.name}
                            </a>

                        </div>
                    </c:forEach>

            </c:otherwise>
        </c:choose>
    </div>
</div>

<%--<a href="/zadanie/${task.id}/wczytaj" class="request-field-btn">  wczytaj obraz  </a>--%>

</body>
</html>

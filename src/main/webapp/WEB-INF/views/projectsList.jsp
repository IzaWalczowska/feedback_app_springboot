<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- Latest compiled and minified CSS -->
<%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">--%>
<%--<!-- jQuery library -->--%>
<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>--%>
<%--<!-- Latest compiled JavaScript -->--%>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>--%>
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
    <link href="https://fonts.googleapis.com/css?family=Work+Sans&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Abril+Fatface&display=swap" rel="stylesheet">
    <link href="<c:url value="/resources/static/styleProjectsList.css" />" rel="stylesheet">
</head>

<div class="container">
    <div id="header">
        <%@ include file="header.jsp" %>
    </div>

    <div id="mainColumn">

        <div id="mainColumn-folders">
            <div class="project-name">
                Twoje Projekty
            </div>
            <div class="formCard">
                <form:form method="post" modelAttribute="project" class="projectForm">

                    <form:input path="name" placeholder="nazwa"/>
                    <form:input path="deadline" placeholder="deadline (yyyy/MM/dd)"/>
                    <form:textarea path="description" placeholder="opis"/>
                    <input type="submit" value="utwórz nowy projekt" class="submit">


                </form:form>
            </div>

            <c:choose>
                <c:when test="${not empty projectDtoList}">
                    <c:forEach items="${projectDtoList}" var="project">
                        <a href="/projekt/${project.id}">
                            <div class="folder">
                                <div class="projectName"> ${project.projectName}</div>
                                <div class="imdDiv"><img src="${project.imagePath}" class="img-miniature"></div>
                            </div>
                        </a>
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

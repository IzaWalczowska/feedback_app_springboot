<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: iza
  Date: 08.11.2019
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zadanie</title>
    <link href="<c:url value="/resources/static/gridStyle.css" />" rel="stylesheet">
    <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <%--    todo dzialajacy skrypt okno sie otwiera,ale potem metoda odbierajaca posta nie dziala--%>
    <%--    <script src="<c:url value="/resources/js/taskHistory.js" />" type="text/javascript"></script>--%>
</head>
<body>
<div class="container">

    <div id="header">
        <%@ include file="header.jsp" %>
    </div>

    <div class="sideTasksDiv">
        <ul>
            <c:forEach items="${tasksList}" var="task">
                <li class="taskStatusLi">
                    <a href="${task.id}">
                            ${task.name}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>

    <div id="mainColumn">

        <div class="card">
            <a href="${taskId}/uploadImage" class="choose-btn" id="uploadButton"> wczytaj obraz </a>
            <%--            onclick="popup(this.href)--%>
            <a href="${taskId}/review" class="choose-btn" id="uploadButton"> stworz recenzje </a>
            <div>
                <form:form method="post" modelAttribute="comment">
                    <label>skomentuj</label>
                    <form:input path="content"/>
                    <input type="submit">
                </form:form>
            </div>
        </div>

        <c:forEach items="${historyList}" var="historyDto">
            <div class="card">
                <span>${historyDto.created}</span>
                <div class="card-field">
                    <c:if test="${not empty historyDto.imageSource}">
                        <img src="${historyDto.imageSource}" class="fullHeightImg">
                    </c:if>
                    <c:if test="${not empty historyDto.content}"><span>${historyDto.content}</span></c:if>
                    <c:if test="${not empty historyDto.requests}">
                        <c:forEach items="${historyDto.requests}" var="request">
                            <div class="request-field-inactive">${request}</div>
                        </c:forEach>
                    </c:if>
                </div>
            </div>
        </c:forEach>

    </div>


</div>

</body>
</html>

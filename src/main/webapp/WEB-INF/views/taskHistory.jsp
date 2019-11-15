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
    <link href="https://fonts.googleapis.com/css?family=Work+Sans&display=swap" rel="stylesheet">
    <link href="<c:url value="/resources/static/styleHistory.css" />" rel="stylesheet">
    <script src="/webjars/jquery/3.4.1/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/todoList.js" />" type="text/javascript"></script>
    <%--    todo dzialajacy skrypt okno sie otwiera,ale potem metoda odbierajaca posta nie dziala--%>
    <%--        <script src="<c:url value="/resources/js/taskHistory.js" />" type="text/javascript"></script>--%>
</head>
<body>
<div class="container">

    <div id="header">
        <%@ include file="header.jsp" %>
    </div>

    <div class="sideTasksDiv">
        <ul>
            <li class="project-btn"><a href="../../projekt/${project.id}">${project.name}</a></li>
            <c:forEach items="${tasksList}" var="task">
                <li class="task-btn">
                    <a href="${task.id}">
                            ${task.name}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </div>

    <div id="mainColumn">

        <div class="comment-card">
            <div>
                <form:form method="post" modelAttribute="comment" class="commentForm">
                    <%--                    <label>skomentuj</label>--%>
                    <form:textarea path="content" placeholder="skomentuj"/>
                    <a href="${taskId}/uploadImage" class="add-btn" > wczytaj obraz </a>
                    <%--            onclick="popup(this.href)--%>
                    <a href="${taskId}/review" class="add-btn" > stworz recenzje </a>
                    <input type="submit" value="skomentuj" class="add-btn">
                    <a href="${taskId}/accept" class="add-btn" > zaakceptuj </a>
                </form:form>

            </div>
        </div>

        <c:forEach items="${historyList}" var="historyDto">
            <div class="card">
                    <%--                <span>${historyDto.created}</span>--%>
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

    <div class="sideTodolistDiv">

        <div class="todo-bkg">
            <div class="todo-bkg-color"> ToDo List </div>
            <c:if test="${not empty checkedRequestsList}">
                <div class="todo-btn">zadania do zrobienia</div>
                <table class="requests-table">
                    <c:forEach items="${checkedRequestsList}" var="requestCheckbox">
                        <tr>
                            <td>
                                <div class="request-checkbox-arch"> ${requestCheckbox.request}</div>
                            </td>
                            <td class="request-circle-arch">

                                <a href="${taskId}/${requestCheckbox.id}">x</a>

                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
        <div class="todo-bkg">
            <c:if test="${not empty uncheckedRequestsList}">
                <h5>zrobione</h5>
                <table class="requests-table">
                    <c:forEach items="${uncheckedRequestsList}" var="requestCheckbox">
                        <tr>
                            <td>
                                <div class="request-checkbox"> ${requestCheckbox.request}</div>
                            </td>
                            <td class="request-circle">
                                <a href="${taskId}/${requestCheckbox.id}">x</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>

    </div>

</div>

</body>
</html>

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
    <link href="https://fonts.googleapis.com/css?family=Work+Sans&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Abril+Fatface&display=swap" rel="stylesheet">
    <%--    <link href="<c:url value="static/style.css" />" rel="stylesheet" type="text/css">--%>
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <link href="<c:url value="/resources/static/styleProject.css"/>" rel="stylesheet">


</head>
<body>
<div class="container">

    <div id="header">
        <%@ include file="header.jsp" %>
    </div>


    <div id="mainLeftColumn">
        <div class="mail-left-col-bkg">
            <div class="task-form-div">
                <img src="" class="noTasksImg">
                <form:form method="post" modelAttribute="task" cssClass="taskForm">
                    <form:input path="name"/>
                    <form:input path="deadline" placeholder="yyyy/MM/dd"/>
                    <%--                type="datetime-local"--%>
                    <form:errors path="deadline" placeholder="opis"/>
                    <form:textarea path="description"/>
                    <input type="submit" value="dodaj zadania do projektu" id="submit">
                </form:form>
            </div>
            <c:if test="${not empty taskDtoList}">
                <c:forEach items="${taskDtoList}" var="task">
                    <a href="../task/${projectId}/${task.taskId}">
                        <div class="task-btn">
                            <div class="task-name">${task.name}</div>
                            <div class="task-deadline">
                                koniec zadania za: ${task.daysToDeadline} dni
                            </div>

<%--                            <div>--%>
<%--                                <c:choose>--%>
<%--                                    <c:when test="${task.status == 'WAITING'}">--%>
<%--                                        <p class="task-status" style="color: #57a5d2">nie rozpoczęto</p>--%>
<%--                                    </c:when>--%>
<%--                                    <c:when test="${task.status == 'TO_REVIEW'}">--%>
<%--                                        <p class="task-status" style="color: #59d8db">czeka na recenzję</p>--%>
<%--                                    </c:when>--%>
<%--                                    <c:when test="${task.status == 'ONGOING'}">--%>
<%--                                        <p class="task-status" style="color: #53db80">w trakcie realizacji</p>--%>
<%--                                    </c:when>--%>
<%--                                    <c:when test="${task.status == 'ACCEPTED'}">--%>
<%--                                        <p class="task-status" style="color: #eaeb14">zakończone</p>--%>
<%--                                    </c:when>--%>
<%--                                </c:choose>--%>
<%--                            </div>--%>

                            <c:choose>
                                <c:when test="${task.status == 'WAITING'}">
                                    <div class="stat-waitng"></div>
                                </c:when>
                                <c:when test="${task.status == 'TO_REVIEW'}">
                                    <div class="stat-toreview"></div>
                                </c:when>
                                <c:when test="${task.status == 'ONGOING'}">
                                    <div class="stat-ongoing"></div>
                                </c:when>
                                <c:when test="${task.status == 'ACCEPTED'}">
                                    <div class="stat-accepted"></div>
                                </c:when>
                            </c:choose>
                                <%--                        <div class="img-div">--%>
                                <%--                                                        <img src="${task.lastImageSource}" class="task-img">--%>
                                <%--                        </div>--%>
                        </div>
                    </a>
                </c:forEach>
            </c:if>
        </div>
    </div>

    <div id="mainRightColumn">

        <div id="project-info">
            <p> ukończone zadania:</p>
            <p> ${finishedTasksCount}/${taskCount}</p>
            <p>data zakończenia projektu:</p>
            <p>${deadlineDate}</p>
            <p> dni do końca projektu:</p>
            <p>${daysToDeadline}</p>
        </div>


        <div>
            <div class="chart-div">
                <canvas id="myPieChart"></canvas>
            </div>
            <%--                    <div class="mt-4 text-center small">--%>
            <%--                    <span class="mr-2">--%>
            <%--                      <i class="fas fa-circle text-primary"></i> Direct--%>
            <%--                    </span>--%>
            <%--                        <span class="mr-2">--%>
            <%--                      <i class="fas fa-circle text-success"></i> Social--%>
            <%--                    </span>--%>
            <%--                        <span class="mr-2">--%>
            <%--                      <i class="fas fa-circle text-info"></i> Referral--%>
            <%--                    </span>--%>
            <%--                    </div>--%>
        </div>

    </div>
</div>

</div>

<script src="/resources/js/Chart.min.js"></script>


<script type="text/javascript">
    document.addEventListener("DOMContentLoaded", function () {

        var ctx = document.getElementById("myPieChart");
        var myPieChart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: ["oczekujące", "w trakcie", "do recenzji", "zakończone"],
                datasets: [{
                    data: [${waitingTasksCount}, ${toReviewTasksCount}, ${ongoingTasksCount}, ${finishedTasksCount}],
                    // data: [10, 6, 5, 8],
                    backgroundColor: ['#2cafdf', '#00c877', '#77cc15', '#eaeb14'],
                    hoverBackgroundColor: ['#2e59d9', '#17a673', '#2c9faf', '#81BDEB'],
                    hoverBorderColor: "rgba(234, 236, 244, 1)",
                }],
            },
            options: {
                maintainAspectRatio: false,
                tooltips: {
                    backgroundColor: "rgb(255,255,255)",
                    bodyFontColor: "#858796",
                    borderColor: '#dddfeb',
                    borderWidth: 1,
                    xPadding: 25,
                    yPadding: 25,
                    displayColors: false,
                    caretPadding: 10,
                },
                legend: {
                    display: false
                },
                cutoutPercentage: 80,
            },
        });

    });
</script>
</body>
</html>

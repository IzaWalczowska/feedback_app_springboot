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
    <link href="https://fonts.googleapis.com/css?family=Playfair+Display&display=swap" rel="stylesheet">
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
            <div class="project-name">
                ${project.name}
            </div>
            <div class="task-form-div">
                <img src="" class="noTasksImg">

                <form:form method="post" modelAttribute="task" cssClass="taskForm">
                    <form:input path="name" placeholder="nazwa"/>
                    <form:input path="deadline" placeholder="deadline (yyyy/MM/dd)"/>
                    <%--                type="datetime-local"--%>
                    <form:textarea path="description" placeholder="opis"/>
                    <input type="submit" value="dodaj zadania do projektu" id="submit">
                </form:form>
            </div>
            <c:if test="${not empty taskDtoList}">
                <c:forEach items="${taskDtoList}" var="task">
                    <a href="../task/${projectId}/${task.taskId}">
                        <div class="task-btn">
                                <%--                            <div class="task-deadline">--%>
                            <c:choose>
                                <c:when test="${task.status == 'WAITING'}">
                                    <div class="stat-waitng"><span
                                            style="font-size: 11px">zostało:</span><br> ${task.daysToDeadline} dni
                                    </div>
                                </c:when>
                                <c:when test="${task.status == 'TO_REVIEW'}">
                                    <div class="stat-toreview"><span
                                            style="font-size: 11px">zostało:</span><br> ${task.daysToDeadline} dni
                                    </div>
                                </c:when>
                                <c:when test="${task.status == 'ONGOING'}">
                                    <div class="stat-ongoing"><span
                                            style="font-size: 11px">zostało:</span><br> ${task.daysToDeadline} dni
                                    </div>
                                </c:when>
                                <c:when test="${task.status == 'ACCEPTED'}">
                                    <div class="stat-accepted"><span
                                            style="font-size: 11px">zostało:</span><br> ${task.daysToDeadline} dni
                                    </div>
                                </c:when>
                            </c:choose>
                                <%--                            </div>--%>

                            <div class="task-name">${task.name}</div>
                        </div>

                    </a>
                </c:forEach>
            </c:if>
        </div>
    </div>

    <div id="mainRightColumn">
        <div class="mail-right-col-bkg">
            <div class="project-info">
                <span> skończone:</span>
                <p class="fin-tasks"> ${finishedTasksCount}/${taskCount}</p>
                <br>
                <span> pozostało dni:</span>
                <p class="days-left">${daysToDeadline}</p>
                <br>
                <span>deadline:</span>
                <p class="deadline">${deadlineDate}</p>
            </div>
        </div>

        <div>
            <div class="chart-div">
                <canvas id="myPieChart"></canvas>
            </div>
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
                    backgroundColor: ['#5d6890', '#59d8db', '#7fb4df', '#dcdcdc'],
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
                    xPadding: 15,
                    yPadding: 15,
                    displayColors: false,
                    caretPadding: 10,
                },
                legend: {
                    display: false
                },
                cutoutPercentage: 75,
            },
        });

    });
</script>
</body>
</html>

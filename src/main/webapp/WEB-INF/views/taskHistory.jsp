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
</head>
<body>
<div class="container">

    <div id="header">
        <%@ include file="header.jsp" %>
    </div>

    <div id="mainColumn">
        <div class="card">
            <a href="${pageContext.servletContext.contextPath}/uploadImage" class="choose-btn"> wczytaj obraz </a>
            servletcontext<br>
            <a href="<%=request.getContextPath()%>/uploadImage" class="choose-btn"> wczytaj obraz </a>
            context path<br>
            <a href="${mainPath}/uploadImage" class="choose-btn"> wczytaj obraz </a>
            model attribute main path<br>
            <a href="../uploadImage" class="choose-btn"> wczytaj obraz </a>
            wykropkowanie
            <a href="task/${projectId}/${task.id}/uploadImage" class="choose-btn"> wczytaj obraz </a>


        </div>

        <div class="card">
            <%--            <a href="/zadanie/${task.id}/skomentuj" class="request-field-btn"> skomentuj </a>--%>
            <%--            <form:form method="post" modelAttribute="comment" action="projekt/${projectId}/zadanie/${taskId}/skomentuj">--%>
            <%--            <form:form method="post" modelAttribute="comment">--%>
            <%--            <form:form action="${task.id}/skomentuj" method="post" modelAttribute="comment">--%>
            <%--                /<%=request.getContextPath()%>/--%>
            <%-- to wysyla ale nie przekierowje do wlasciwej strony    "/WEB-INF/views/projekt/3/zadanie/3/skomentuj.jsp" --%>
            <%--            <form:form action="" servletRelativeAction="${task.id}/skomentuj" method="post" modelAttribute="comment">--%>
            <%--                wcale nie pobiera kontekstu--%>
            <%--           <form:form action="${pageContext.request.contextPath}/skomentuj" servletRelativeAction="" method="post" modelAttribute="comment">--%>
            <%--            <form:form action="/<%=request.getContextPath()%>/skomentuj" servletRelativeAction="" method="post"--%>
            <form:form method="post" modelAttribute="comment">
                <label>skomentuj</label>
                <form:input path="content"/>
                <input type="submit">
            </form:form>
        </div>

        <c:forEach items="${historyList}" var="historyDto">
            <div class="card">
                <span>${historyDto.created}</span>
                <div class="card-field">
                    <img src="/resources/images/1.jpg" class="fullHeightImg">
                    <c:if test="${not empty historyDto.imageSource}">
                        <img src="${historyDto.imageSource}" class="fullHeightImg">
                    </c:if>
                </div>
                    ${historyDto.imageSource}
                <c:if test="${not empty historyDto.content}"><span>${historyDto.content}</span></c:if>
            </div>
        </c:forEach>

    </div>


</div>

</body>
</html>

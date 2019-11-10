<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: iza
  Date: 26.10.2019
  Time: 18:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj plik</title>
    <link href="<c:url value="/resources/static/style.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/uploadFile.js" />" type="text/javascript"></script>


</head>
<body>
<div id="header">
    <%@ include file="header.jsp" %>
</div>

<container class="img-preview">
    <img id="preview" src=""  alt="your image" class="img" >
</container>

<form method="post" enctype="multipart/form-data" class="form-upload">
    <label class="choose-btn">przeglądaj
        <input name="uploadFile" id="fileInput" type="file" accept="image/jpeg, image/png" onchange="previewFile()">
    </label>
    <input type="submit" value="ok" name="submit" class="choose-btn">
</form>

</body>
</html>

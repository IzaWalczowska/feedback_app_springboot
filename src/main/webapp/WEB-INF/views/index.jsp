<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <link href="<c:url value="../style.css" />" rel="stylesheet">
</head>
<body>
<div class="div-frame">
    <a href="/upload" class="request-field-btn">  upload  </a>
    <a href="/review" class="request-field-btn">  review  </a>
    <a href="/projekty/" class="request-field-btn">  projekty  </a>
    <a href="/review/" class="request-field-btn">  review  </a>

</div>

</body>
</html>

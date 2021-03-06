<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <title>Sign Up</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../../resources/css/signup.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col"></div>
        <div class="col-lg-4 form">
            <c:choose>
                <c:when test="${count eq 1}">
                    <%@include file="../jspf/signup/registration1.jspf" %>
                </c:when>
                <c:when test="${count eq 2}">
                    <%@include file="../jspf/signup/registration2.jspf" %>
                </c:when>
                <c:when test="${count eq 3}">
                    <%@include file="../jspf/signup/registration3.jspf" %>
                </c:when>
            </c:choose>
        </div>
        <div class="col"></div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="../../../resources/js/bootstrap.min.js"></script>
</body>
</html>
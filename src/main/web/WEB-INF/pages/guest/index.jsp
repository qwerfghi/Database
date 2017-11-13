<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Index</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../../resources/css/index.css">
</head>
<body>
<div class="container col-auto form">
    <form action="<c:url value="/signin"/>">
        <h2>Please sign in</h2>
        <label for="login" class="sr-only">Login</label>
        <input type="text" id="login" class="form-control" name="login" placeholder="login" required autofocus>
        <label for="password" class="sr-only">Password</label>
        <input type="password" id="password" class="form-control" name="password" placeholder="password" required>
        <button class="btn btn-primary btn-block" type="submit">Sing in</button>
    </form>
    <div class="buttons">
        <form action="<c:url value="/signup"/>">
            <button class="btn btn-primary" type="submit">Sing up</button>
        </form>
        <form action="<c:url value="/guest"/>">
            <button class="btn btn-primary" type="submit">Guest</button>
        </form>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="../../../resources/js/bootstrap.min.js"></script>
</body>
</html>
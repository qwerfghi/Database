<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Index</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/index.css">
</head>
<body>
<div class="container col-sm-auto form">
    <form class="form-signin">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="Login" class="sr-only">Login</label>
        <input type="text" id="Login" class="form-control" placeholder="Login" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
        <button class="btn btn-primary btn-block" type="submit">Sing in</button>
        <div class="buttons">
            <button class="btn btn-primary hui" type="submit">Sing up</button>
            <button class="btn btn-primary hui" type="submit">Guest</button>
        </div>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>
</body>
</html>
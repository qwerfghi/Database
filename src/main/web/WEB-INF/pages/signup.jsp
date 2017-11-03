<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html lang="en">
<head>
    <title>Sign Up</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/signup.css">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col"></div>
        <div class="col-lg-5 form">
            <form action="<c:url value="/signup"/>">
                <input type="text" name="login" class="form-control" placeholder="Логин" required autofocus>
                <input type="password" name="password1" class="form-control" placeholder="Пароль" required>
                <input type="password" name="password2" class="form-control" placeholder="Повторите пароль" required>
                <input type="text" name="name" class="form-control" placeholder="Имя" required>
                <input type="text" name="lastName" class="form-control" placeholder="Фамилия" required>
                <input type="text" name="patronymic" class="form-control" placeholder="Отчество" required>
                <button class="btn btn-primary" type="submit">Далее</button>
            </form>
        </div>
        <div class="col"></div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="../../resources/js/bootstrap.min.js"></script>
</body>
</html>
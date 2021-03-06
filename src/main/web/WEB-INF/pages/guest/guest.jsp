<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Guest</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../../resources/css/guest.css">
</head>
<body>
<div class="container">
    <form action="<c:url value="/guest"/>">
        <div class="row align-items-end">
            <div class="col"></div>
            <div class="col-lg-2">
                <label for="exampleSelect1">Тип комнаты</label>
                <select class="form-control" id="exampleSelect1" name="animalType">
                    <option>для собаки</option>
                    <option>для кота</option>
                    <option>для хомяка</option>
                    <option>для черепахи</option>
                    <option>для змеи</option>
                </select>
            </div>
            <div class="col-lg-2">
                <label for="datepicker">Дата заселения</label>
                <input type="date" id="datepicker" name="date" class="form-control" required>
            </div>
            <div class="col-lg-1">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>
            <div class="col"></div>
        </div>
    </form>
    <div class="row">
        <div class="col"></div>
        <div class="col-lg-8 table">
            <table class="table-bordered table-hover table-inverse">
                <thead>
                <tr>
                    <td>Номер комнаты</td>
                    <td>Дата заселения</td>
                    <td>Дата выселения</td>
                    <td>Стоимость/сут</td>
                </tr>
                </thead>
                <tbody>
                <c:if test="${empty freeRooms}">
                    <c:forEach begin="${0}" end="${15}">
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </c:forEach>
                </c:if>
                <c:if test="${not empty freeRooms}">
                    <c:forEach items="${freeRooms}" var="room">
                        <tr>
                            <td>${room.number}</td>
                            <td>${room.dateBeg}</td>
                            <td>${room.dateEnd}</td>
                            <td>${room.cost}</td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
        <div class="col"></div>
    </div>
</div>
</body>
</html>
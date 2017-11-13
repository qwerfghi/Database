<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../jspf/user/header.jspf" %>
<div class="container">
    <div class="bg-faded p-4 my-4">
        <div class="row">
            <div class="col"></div>
            <div class="col-lg-9 table">
                <table class="table-bordered table-hover">
                    <thead>
                    <tr>
                        <td>Номер комнаты</td>
                        <td>Тип комнаты</td>
                        <td>Дата заселения</td>
                        <td>Дата выселения</td>
                        <td>Стоимость номера/сут</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${rooms}" var="room">
                        <tr>
                            <td>${room.number}</td>
                            <td>${room.animalType.roomType}</td>
                            <td>${room.dateBeg}</td>
                            <td>${room.dateEnd}</td>
                            <td>${room.cost}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col"></div>
        </div>
    </div>
</div>
<%@include file="../jspf/user/footer.jspf" %>
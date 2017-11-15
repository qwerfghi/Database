<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../jspf/user/header.jspf" %>
<div class="container">
    <div class="bg-faded p-4 my-4">
        <div class="row">
            <div class="col"></div>
            <div class="col-6">
                <form action="<c:url value="/user/reservation"/>">
                    <div class="form-row">
                        <div class="col">
                            <label for="pet">Выберите вашего питомца</label>
                        </div>
                        <div class="col-4">
                            <select class="form-control" id="pet" name="petName" onchange="document.getElementById('hiddenPet').value = document.getElementById('pet').value">
                                <c:forEach items="${user.owner.animalList}" var="pet">
                                    <option>${pet.animalName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-2">
                            <button class="btn btn-primary" type="submit">Найти</button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col"></div>
        </div>
        <div class="row">
            <div class="col"></div>
            <div class="col-6">
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <td>Номер комнаты</td>
                        <td>Тип комнаты</td>
                        <td>Стоимость комнаты</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${freeRooms}" var="room">
                        <tr>
                            <td>${room.number}</td>
                            <td>${room.animalType.roomType}</td>
                            <td>${room.cost}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="col"></div>
        </div>
        <div class="row">
            <div class="col"></div>
            <div class="col-6">
                <form action="<c:url value="/user/reservation"/>">
                    <div class="form-group row">
                        <label for="roomNum" class="col-sm-5 col-form-label">Номер комнаты</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" id="roomNum" name="roomNum">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="dateIn" class="col-sm-5 col-form-label">Дата заселения</label>
                        <div class="col-sm-7">
                            <input type="date" class="form-control" id="dateIn" name="dateIn">
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="dateOut" class="col-sm-5 col-form-label">Дата выселения</label>
                        <div class="col-sm-7">
                            <input type="date" class="form-control" id="dateOut" name="dateOut">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="form-check form-check-inline">
                            <label class="form-check-label">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox1" value="option1">
                                Зоотакси
                            </label>
                        </div>
                        <div class="form-check form-check-inline">
                            <label class="form-check-label">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox2" value="option2">
                                Стрижка
                            </label>
                        </div>
                        <div class="form-check form-check-inline">
                            <label class="form-check-label">
                                <input class="form-check-input" type="checkbox" id="inlineCheckbox3" value="option3">
                                Осмотр ветеринара
                            </label>
                        </div>
                    </div>
                    <input type="hidden" id="hiddenPet" name="hiddenPet" value="Летти">
                    <button class="btn btn-primary" type="submit">Забронировать</button>
                </form>
            </div>
            <div class="col"></div>
        </div>
    </div>
</div>
<%@include file="../jspf/user/footer.jspf" %>
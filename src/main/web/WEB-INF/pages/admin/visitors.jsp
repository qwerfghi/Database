<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../jspf/admin/navbar.jspf" %>
<div class="container">
    <div class="row">
        <div class="col"></div>
        <div class="col-lg-6">
            <div id="accordion" role="tablist">
                <div class="card">
                    <div class="card-header" role="tab" id="headingOne">
                        <h5 class="mb-0">
                            <a data-toggle="collapse" href="#collapseOne" aria-expanded="true"
                               aria-controls="collapseOne">
                                Добавить посетителя
                            </a>
                        </h5>
                    </div>
                    <div id="collapseOne" class="collapse" role="tabpanel" aria-labelledby="headingOne"
                         data-parent="#accordion">
                        <div class="card-body">
                            <form action="<c:url value="/admin/visitors"/>">
                                <input type="text" name="visitorName" class="form-control" placeholder="Имя посетителя"
                                       required autofocus>
                                <input type="text" name="visitorLastName" class="form-control"
                                       placeholder="Фамилия посетителя"
                                       required>
                                <input type="text" name="visitorPatr" class="form-control"
                                       placeholder="Отчество посетителя"
                                       required>
                                <input type="text" name="passNum" class="form-control" placeholder="Номер паспорта"
                                       required>
                                <input type="text" name="phoneNum" class="form-control" placeholder="Номер телефона"
                                       required>
                                <input type="email" name="email" class="form-control" placeholder="Email" required>
                                <input type="text" name="region" class="form-control" placeholder="Область" required>
                                <input type="text" name="locality" class="form-control"
                                       placeholder="Город/Населенный пункт" required>
                                <input type="text" name="street" class="form-control" placeholder="Улица" required>
                                <input type="text" name="house" class="form-control" placeholder="Дом" required>
                                <input type="text" name="apartment" class="form-control" placeholder="Квартира"
                                       required>
                                <button class="btn btn-primary" type="submit">Добавить посетителя</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header" role="tab" id="headingTwo">
                        <h5 class="mb-0">
                            <a data-toggle="collapse" href="#collapseTwo" aria-expanded="true"
                               aria-controls="collapseTwo">
                                Изменить скидку
                            </a>
                        </h5>
                    </div>
                    <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo"
                         data-parent="#accordion">
                        <div class="card-body">
                            <form action="<c:url value="/admin/visitors"/>">
                                <input type="text" name="changeId" class="form-control" placeholder="ID посетителя"
                                       required>
                                <select class="form-control" name="discount">
                                    <option>0%</option>
                                    <option>5%</option>
                                    <option>10%</option>
                                    <option>20%</option>
                                </select>
                                <button class="btn btn-primary mt-3" type="submit">Изменить скидку</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header" role="tab" id="headingThree">
                        <h5 class="mb-0">
                            <a data-toggle="collapse" href="#collapseThree" aria-expanded="true"
                               aria-controls="collapseThree">
                                Удалить посетителя
                            </a>
                        </h5>
                    </div>
                    <div id="collapseThree" class="collapse" role="tabpanel" aria-labelledby="headingThree"
                         data-parent="#accordion">
                        <div class="card-body">
                            <form action="<c:url value="/admin/visitors"/>">
                                <input type="text" name="deleteId" class="form-control" placeholder="ID посетителя"
                                       required>
                                <button class="btn btn-primary mt-3" type="submit">Удалить посетителя</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col"></div>
    </div>
    <div class="row pt-4">
        <div class="col"></div>
        <div class="col-lg-9 table" style="overflow: auto">
            <table class="table-bordered table-hover table">
                <thead>
                <tr>
                    <td>ID</td>
                    <td>Имя</td>
                    <td>Фамилия</td>
                    <td>Отчество</td>
                    <td>Номер паспорта</td>
                    <td>Номер телефона</td>
                    <td>Email</td>
                    <td>Скидка</td>
                    <td>Область</td>
                    <td>Город/ Населенный пункт</td>
                    <td>Улица</td>
                    <td>Дом</td>
                    <td>Квартира</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${visitors}" var="visitor">
                    <tr>
                        <td>${visitor.idowner}</td>
                        <td>${visitor.ownerName}</td>
                        <td>${visitor.ownerLastName}</td>
                        <td>${visitor.ownerPatronymic}</td>
                        <td>${visitor.passport}</td>
                        <td>${visitor.phoneNum}</td>
                        <td>${visitor.email}</td>
                        <td>${visitor.discount.discount}</td>
                        <td>${visitor.address.region}</td>
                        <td>${visitor.address.locality}</td>
                        <td>${visitor.address.street}</td>
                        <td>${visitor.address.houseNum}</td>
                        <td>${visitor.address.apartmentNum}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col"></div>
    </div>
</div>
<%@include file="../jspf/admin/footer.jspf" %>
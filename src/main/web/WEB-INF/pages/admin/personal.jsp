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
                                Добавить работника
                            </a>
                        </h5>
                    </div>
                    <div id="collapseOne" class="collapse" role="tabpanel" aria-labelledby="headingOne"
                         data-parent="#accordion">
                        <div class="card-body">
                            <form action="<c:url value="/admin/personal"/>">
                                <input type="text" name="addId" class="form-control" placeholder="ID сотрудника" required
                                       autofocus>
                                <input type="text" name="emplName" class="form-control" placeholder="Имя сотрудника"
                                       required>
                                <input type="text" name="emplLastName" class="form-control" placeholder="Фамилия сотрудника"
                                       required>
                                <input type="text" name="emplPatr" class="form-control" placeholder="Отчество сотрудника"
                                       required>
                                <input type="text" name="empl" class="form-control" placeholder="Должность сотрудника"
                                       required>
                                <input type="text" name="petAge" class="form-control" placeholder="Номер паспорта"
                                       required>
                                <input type="text" name="petAge" class="form-control" placeholder="Номер телефона"
                                       required>
                                <input type="email" name="notice" class="form-control" placeholder="email" required>
                                <button class="btn btn-primary" type="submit">Добавить питомца</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header" role="tab" id="headingTwo">
                        <h5 class="mb-0">
                            <a data-toggle="collapse" href="#collapseTwo" aria-expanded="true"
                               aria-controls="collapseOne">
                                Удалить питомца
                            </a>
                        </h5>
                    </div>
                    <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo"
                         data-parent="#accordion">
                        <div class="card-body">
                            <form action="<c:url value="/admin/personal"/>">
                                <input type="text" name="deleteId" class="form-control" placeholder="ID питомца"
                                       required>
                                <button class="btn btn-primary mt-3" type="submit">Удалить питомца</button>
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
        <div class="col-lg-9 table">
            <table class="table-bordered table-hover">
                <thead>
                <tr>
                    <td>ID владельца</td>
                    <td>ID питомца</td>
                    <td>Кличка питомца</td>
                    <td>Вид питомца</td>
                    <td>Возраст питомца</td>
                    <td>Примечание</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${pets}" var="pet">
                    <tr>
                        <td>${pet.idowner}</td>
                        <td>${pet.idanimal}</td>
                        <td>${pet.animalName}</td>
                        <td>${pet.animalType.animalType}</td>
                        <td>${pet.age}</td>
                        <td>${pet.notice}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col"></div>
    </div>
</div>
<%@include file="../jspf/admin/footer.jspf" %>
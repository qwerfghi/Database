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
                                <input type="text" name="emplName" class="form-control" placeholder="Имя сотрудника"
                                       required autofocus>
                                <input type="text" name="emplLastName" class="form-control"
                                       placeholder="Фамилия сотрудника"
                                       required>
                                <input type="text" name="emplPatr" class="form-control"
                                       placeholder="Отчество сотрудника"
                                       required>
                                <input type="text" name="emplPosition" class="form-control"
                                       placeholder="Должность сотрудника"
                                       required>
                                <input type="date" name="date" class="form-control"
                                       placeholder="Дата найма" required>
                                <input type="text" name="passNum" class="form-control" placeholder="Номер паспорта"
                                       required>
                                <input type="text" name="phoneNum" class="form-control" placeholder="Номер телефона"
                                       required>
                                <input type="email" name="email" class="form-control" placeholder="Email" required>
                                <button class="btn btn-primary" type="submit">Добавить работника</button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-header" role="tab" id="headingTwo">
                        <h5 class="mb-0">
                            <a data-toggle="collapse" href="#collapseTwo" aria-expanded="true"
                               aria-controls="collapseTwo">
                                Удалить работника
                            </a>
                        </h5>
                    </div>
                    <div id="collapseTwo" class="collapse" role="tabpanel" aria-labelledby="headingTwo"
                         data-parent="#accordion">
                        <div class="card-body">
                            <form action="<c:url value="/admin/personal"/>">
                                <input type="text" name="deleteId" class="form-control" placeholder="ID работника"
                                       required>
                                <button class="btn btn-primary mt-3" type="submit">Удалить работника</button>
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
                    <td>ID сотрудника</td>
                    <td>Имя</td>
                    <td>Фамилия</td>
                    <td>Отчество</td>
                    <td>Дата найма</td>
                    <td>Должность</td>
                    <td>Номер паспорта</td>
                    <td>Номер телефона</td>
                    <td>Email</td>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${staff}" var="employee">
                    <tr>
                        <td>${employee.idstaff}</td>
                        <td>${employee.employeeName}</td>
                        <td>${employee.employeeLastName}</td>
                        <td>${employee.employeePatronymic}</td>
                        <td>${employee.dateRec}</td>
                        <td>${employee.position}</td>
                        <td>${employee.passport}</td>
                        <td>${employee.phoneNum}</td>
                        <td>${employee.email}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <div class="col"></div>
    </div>
</div>
<%@include file="../jspf/admin/footer.jspf" %>
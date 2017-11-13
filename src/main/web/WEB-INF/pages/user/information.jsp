<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../jspf/user/header.jspf" %>
<c:set var="owner" value="${user.owner}"/>
<c:set var="address" value="${user.owner.address}"/>
<div class="container">
    <div class="bg-faded p-4 my-4">
        <div class="row">
            <div class="col"></div>
            <div class="col-lg-8">
                <img src="../../../resources/img/anonim.jpg" class="img-fluid float-left mr-4 d-none d-lg-block">
                <h4><b><u>${owner.ownerLastName} ${owner.ownerName} ${owner.ownerPatronymic}</u></b></h4><br>
                Номер паспорта: ${owner.passport} <br>
                <br>
                Адрес: ${address.region} обл., г. ${address.locality}, ул. ${address.street}, д. ${address.houseNum}, кв. ${address.apartmentNum} <br>
                <br>
                тел. ${owner.phoneNum} <br>
                Email: ${owner.email} <br>
            </div>
            <div class="col"></div>
        </div>
        <div class="row p-4">
            <div class="col"></div>
            <div class="col-lg-6 table">
                <table class="table-bordered table-hover">
                    <thead>
                    <tr>
                        <td>Имя питомца</td>
                        <td>Вид питомца</td>
                        <td>Возраст</td>
                        <td>Примечание</td>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${owner.animalList}" var="animal">
                        <tr>
                            <td>${animal.animalName}</td>
                            <td>${animal.animalType.animalType}</td>
                            <td>${animal.age}</td>
                            <td>${animal.notice}</td>
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
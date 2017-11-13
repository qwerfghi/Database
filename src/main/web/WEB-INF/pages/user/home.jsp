<%@ page contentType="text/html;charset=UTF-8" %>
<%@include file="../jspf/user/header.jspf" %>
<div class="container">
    <div class="bg-faded p-4 my-4">
        <!-- Image Carousel -->
        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
                <div class="carousel-item active">
                    <img class="d-block img-fluid w-100" src="../../../resources/img/slide-1.jpg" alt="">
                    <div class="carousel-caption d-none d-md-block">
                        <h3 class="text-shadow">First Slide</h3>
                        <p class="text-shadow">This is the caption for the first slide.</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="d-block img-fluid w-100" src="../../../resources/img/slide-2.jpg" alt="">
                    <div class="carousel-caption d-none d-md-block">
                        <h3 class="text-shadow">Second Slide</h3>
                        <p class="text-shadow">This is the caption for the second slide.</p>
                    </div>
                </div>
                <div class="carousel-item">
                    <img class="d-block img-fluid w-100" src="../../../resources/img/slide-3.jpg" alt="">
                    <div class="carousel-caption d-none d-md-block">
                        <h3 class="text-shadow">Third Slide</h3>
                        <p class="text-shadow">This is the caption for the third slide.</p>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
        <!-- Welcome Message -->
        <div class="text-center mt-4">
            <div class="text-heading text-muted text-lg">Добро пожаловать в</div>
            <h3 class="my-2">Гостиницу "Четыре лапы"</h3>
        </div>
    </div>

    <div class="bg-faded p-4 my-4">
        <hr class="divider">
        <h2 class="text-center text-lg text-uppercase my-0">О нас</h2>
        <hr class="divider">
        <p>Гостиница пользуется спросом у владельцев собак и кошек разных пород. Для крупных собак здесь предлагаются вольеры с деревянными будками или
            проживание в комнатах в отдельном небольшом домике. Комнаты размером 4 и 10 кв. м оснащены системой вентиляции, в них есть диваны, на которые можно постелить
            привычные домашние покрывала или лежанки. Для выгула предназначена огороженная территория вокруг дома, где животные гуляют по очереди или вместе. </p>
        <p>Условия содержания собак декоративных пород и кошек в этой гостинице максимально приближены к домашним. Это значит, что животные живут в доме с людьми, свободно гуляют, спят на диване
            и путешествуют на кухню. Как ни удивительно, собаки и кошки мирно уживаются и даже находят друзей среди постояльцев отеля.</p>
    </div>

</div>
<!-- /.container -->
<%@include file="../jspf/user/footer.jspf" %>
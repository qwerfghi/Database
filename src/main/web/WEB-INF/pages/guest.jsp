<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/xml" %>
<html>
<head>
    <title>Guest</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../resources/css/guest.css">
</head>
<body>
<form>
    <div class="form-group">
        <label for="exampleSelect1">Выберите тип комнаты</label>
        <select class="form-control" id="exampleSelect1">
            <option>для собаки</option>
            <option>для кота</option>
            <option>для хомяка</option>
            <option>для черепахи</option>
            <option>для змеи</option>
        </select>
    </div>
    <div class="form-group">
        <div class='input-group date' id='datetimepicker2'>
            <input type='text' class="form-control"/>
            <span class="input-group-addon">
                        <span class="glyphicon glyphicon-calendar"></span>
                    </span>
        </div>
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
<script type="text/javascript">
    $(function () {
        $('#datetimepicker2').datetimepicker({
            locale: 'ru'
        });
    });
</script>
</body>
</html>
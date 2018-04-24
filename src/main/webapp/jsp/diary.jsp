<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Diary</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .carousel-inner > .item > form,
        .carousel-inner > .item > a > form {
            width: 70%;
            margin: auto;
        }
    </style>
</head>
<body>
<div class="container">
    <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="false">
        <div class="carousel-inner">
            <div class="item active">
                <form class="form-horizontal" method="post" action="/diary">
                    <label for="date">Дата:</label>
                    <input class="form-control" type="date" id="date">
                    <label for="neck">Шея:</label>
                    <input class="form-control" type="text" id="neck">
                    <label for="biceps">Бицепс:</label>
                    <input class="form-control" type="text" id="biceps">
                    <label for="chest">Грудь:</label>
                    <input class="form-control" type="text" id="chest">
                    <label for="waist">Талия:</label>
                    <input class="form-control" type="text" id="waist">
                    <label for="hip">Бедро:</label>
                    <input class="form-control" type="text" id="hip">
                    <label for="weight">Вес:</label>
                    <input class="form-control" type="text" id="weight">
                    <input type="submit" value="Сохранить">
                </form>
            </div>
        </div>
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

</body>
</html>

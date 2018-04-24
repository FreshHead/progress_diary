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
            <div class="item">
                <form class="form-horizontal" method="post" action="/edit-entry">
                    <div class="form-group">
                        <label for="date">Дата:</label>
                        <input class="form-control" type="date" id="date" disabled>
                    </div>
                    <div class="form-group">
                        <label for="neck">Шея:</label>
                        <input class="form-control" type="number" step="0.1" id="neck" disabled>
                    </div>
                    <div class="form-group">
                        <label for="biceps">Бицепс:</label>
                        <input class="form-control" type="number" step="0.1" id="biceps" disabled>
                    </div>
                    <div class="form-group">
                        <label for="chest">Грудь:</label>
                        <input class="form-control" type="number" step="0.1" id="chest" disabled>
                    </div>
                    <div class="form-group">
                        <label for="waist">Талия:</label>
                        <input class="form-control" type="number" step="0.1" id="waist" disabled>
                    </div>
                    <div class="form-group">
                        <label for="hip">Бедро:</label>
                        <input class="form-control" type="number" step="0.1" id="hip" disabled>
                    </div>
                    <div class="form-group">
                        <label for="weight">Вес:</label>
                        <input class="form-control" type="number" step="0.1" id="weight" disabled>
                    </div>
                    <div class="form-group">
                        <label for="note">Примечание:</label>
                        <input class="form-control" type="text" id="note" disabled>
                    </div>
                    <div class="form-group">
                        <label for="photo">Добавить фото:</label>
                        <input class="" type="file" accept="image/*" id="photo" disabled>
                    </div>
                    <div class="form-group">
                        <input type="button" value="Разблокировать для изменения">
                    </div>
                </form>
            </div>
            <div class="item active">
                <form class="form-horizontal" method="post" action="/new-entry">
                    <div class="form-group">
                        <label for="new-date">Дата:</label>
                        <input class="form-control" type="date" id="new-date">
                    </div>
                    <script>
                        document.getElementById("new-date").valueAsDate = new Date();
                    </script>
                    <div class="form-group">
                        <label for="new-neck">Шея:</label>
                        <input class="form-control" type="number" step="0.1" id="new-neck">
                    </div>
                    <div class="form-group">
                        <label for="new-biceps">Бицепс:</label>
                        <input class="form-control" type="number" step="0.1" id="new-biceps">
                    </div>
                    <div class="form-group">
                        <label for="new-chest">Грудь:</label>
                        <input class="form-control" type="number" step="0.1" id="new-chest">
                    </div>
                    <div class="form-group">
                        <label for="new-waist">Талия:</label>
                        <input class="form-control" type="number" step="0.1" id="new-waist">
                    </div>
                    <div class="form-group">
                        <label for="new-hip">Бедро:</label>
                        <input class="form-control" type="number" step="0.1" id="new-hip">
                    </div>
                    <div class="form-group">
                        <label for="new-weight">Вес:</label>
                        <input class="form-control" type="number" step="0.1" id="new-weight">
                    </div>
                    <div class="form-group">
                        <label for="new-note">Примечание:</label>
                        <input class="form-control" type="text" id="new-note">
                    </div>
                    <div class="form-group">
                        <label for="new-photo">Добавить фото:</label>
                        <input class="" type="file" accept="image/*" id="new-photo">
                    </div>
                    <div class="form-group">
                        <input type="submit" value="Сохранить">
                    </div>
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

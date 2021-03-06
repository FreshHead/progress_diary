<#ftl encoding='UTF-8'>
<html>
<head>
    <title>new-diary-page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Progress diary</a>
            </div>
            <div class="collapse navbar-collapse" id="myNavbar">
                <ul class="nav navbar-nav">
                    <li><a href="/diary/">Архив</a></li>
                    <li class="active"><a href="#">Новая страница</a></li>
                    <li><a href="/gallery/">Галерея</a></li>
                    <li><a href="/graph/">График</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Выход</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div class="carousel-inner">
        <form class="form-horizontal content" id="new-page-form" method="post" action="/diary/save"
              enctype="multipart/form-data">
            <div class="row">
                <div class="col-xs-6">
                    <div class="form-group">
                        <label for="new-date">Дата:</label>
                        <input class="form-control" type="date" id="new-date" name="date" required>
                    </div>
                    <script>
                        document.getElementById("new-date").valueAsDate = new Date();
                    </script>
                    <div class="form-group">
                        <label for="new-butt">Ягодицы:</label>
                        <input class="form-control" type="number" step="0.1" max="100" id="new-butt"
                               name="butt">
                    </div>
                    <div class="form-group">
                        <label for="new-biceps">Бицепс:</label>
                        <input class="form-control" type="number" step="0.1" max="100" id="new-biceps"
                               name="biceps">
                    </div>
                    <div class="form-group">
                        <label for="new-chest">Грудь:</label>
                        <input class="form-control" type="number" step="0.1" max="500" id="new-chest"
                               name="chest">
                    </div>
                </div>
                <div class="col-xs-6">
                    <div class="form-group">
                        <label for="new-waist">Талия:</label>
                        <input class="form-control" type="number" step="0.1" max="500" id="new-waist"
                               name="waist">
                    </div>
                    <div class="form-group">
                        <label for="new-hip">Бедро:</label>
                        <input class="form-control" type="number" step="0.1" max="200" id="new-hip" name="hip">
                    </div>
                    <div class="form-group">
                        <label for="new-calf">Голень:</label>
                        <input class="form-control" type="number" step="0.1" max="200" id="new-calf"
                               name="calf">
                    </div>
                    <div class="form-group">
                        <label for="new-weight">Вес:</label>
                        <input class="form-control" type="number" step="0.1" max="1000" id="new-weight"
                               name="weight">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label for="new-note">Примечание:</label>
                <textarea class="form-control" rows="3" id="new-note" name="note"></textarea>
            </div>
            <div class="form-group">
                <label for="new-files">Фото:</label>
                <input type="file" accept="image/*" id="new-files" name="files" multiple>
            </div>
            <div class="form-group">
                <input type="submit" value="Сохранить">
            </div>
        </form>
    </div>
</div>
</body>
</html>
<#ftl encoding='UTF-8'>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="content">
        <h2>Регистрация</h2>
        <a href="/login">Уже зарегистрированны?</a>
        <form method="post" action="/signUp">
            <div class="form-group">
                <label for="username">Имя пользователя:</label>
                <input type="text" class="form-control" id="username" name="username">
            </div>
            <div class="form-group">
                <label for="password">Пароль:</label>
                <input type="password" class="form-control" id="password" name="password">
            </div>
            <div class="checkbox">
                <label><input type="checkbox" name="remember">Запомни меня</label>
            </div>
            <button type="submit" class="btn btn-default">Зарегистрироваться</button>
        </form>
    </div>
</div>
</body>
</html>

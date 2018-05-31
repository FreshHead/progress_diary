<#ftl encoding='UTF-8'>
<html>
<head>
    <title>Diary</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/js/src/activate_first_corousel_item-0.1.js"></script>
    <script src="/js/src/change_form_action_for_delete-0.1.js"></script>
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
                    <li class="active"><a href="#">Архив</a></li>
                    <li><a href="/diary/new-diary-page">Новая страница</a></li>
                    <li><a href="/gallery/">Галерея</a></li>
                    <li><a href="/graph/">График</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Выход</a></li>
                </ul>
            </div>
        </div>
    </nav>

    <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="false">
        <div class="carousel-inner">
                <#list diary as page>
                    <div class="item">
                        <form class="form-horizontal content" method="post" action="/diary/save"
                              enctype="multipart/form-data">
                            <input title="Id" type="number" hidden name="diary_page_id" value="${page.diaryPageId}">
                            <div class="row">
                                <div class="col-xs-6">
                                    <div class="form-group">
                                        <label for="date">Дата:</label>
                                        <input class="form-control" type="date" id="date" name="date"
                                               value="${page.getDateStringForInput()}"/>
                                    </div>
                                    <div class="form-group">
                                        <label for="butt">Ягодицы:</label>
                                        <input class="form-control" type="number" step="0.1" max="100" id="butt"
                                               name="butt"
                                               value="${(page.butt)!}">
                                    </div>
                                    <div class="form-group">
                                        <label for="biceps">Бицепс:</label>
                                        <input class="form-control" type="number" step="0.1" max="100" id="biceps"
                                               name="biceps"
                                               value="${(page.biceps)!}">
                                    </div>
                                    <div class="form-group">
                                        <label for="chest">Грудь:</label>
                                        <input class="form-control" type="number" step="0.1" max="500" id="chest"
                                               name="chest"
                                               value="${(page.chest)!}">
                                    </div>
                                </div>
                                <div class="col-xs-6">
                                    <div class="form-group">
                                        <label for="waist">Талия:</label>
                                        <input class="form-control" type="number" step="0.1" max="500" id="waist"
                                               name="waist"
                                               value="${(page.waist)!}">
                                    </div>
                                    <div class="form-group">
                                        <label for="hip">Бедро:</label>
                                        <input class="form-control" type="number" step="0.1" max="200" id="hip"
                                               name="hip"
                                               value="${(page.hip)!}">
                                    </div>
                                    <div class="form-group">
                                        <label for="calf">Голень:</label>
                                        <input class="form-control" type="number" step="0.1" max="200" id="calf"
                                               name="calf"
                                               value="${(page.calf)!}">
                                    </div>
                                    <div class="form-group">
                                        <label for="weight">Вес:</label>
                                        <input class="form-control" type="number" step="0.1" max="1000" id="weight"
                                               name="weight"
                                               value="${(page.weight)!}">
                                    </div>

                                </div>
                                <div class="form-group">
                                    <label for="note">Примечание:</label>
                                    <textarea class="form-control" rows="3" id="note"
                                              name="note">${(page.note)!}</textarea>
                                </div>
                                <div class="form-group">
                                    <div>
                                        <label for="files">Фото:</label>
                                        <input type='file' id="files" name="files" multiple>
                                    <p><#if page.filenames?size != 0>Текущие фото:
                                        <#list page.filenames as filename>
                                                     <p>${filename}</p>
                                        </#list>
                                    </#if>
                                        </p>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="submit" value="Сохранить">
                                    <input class="delete-button" type="submit" value="Удалить">
                                </div>
                            </div>
                        </form>
                    </div>
                </#list>
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
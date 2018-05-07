<#ftl encoding='UTF-8'>
<html>
<head>
    <title>Graph</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/js/lib/jquery.flot.min.js"></script>
    <script type="text/javascript" src="/js/lib/jquery.flot.time.js"></script>
</head>
<script>
    $(document).ready(function () {
        var graphData = [
            {
                label: "Ягодицы",
                data: [
                    <#list diary as page>
                        <#if page.butt??>
                        [new Date("${page.getDateStringForJS()}"), ${page.butt}]<#sep>,</#sep>
                        </#if>
                    </#list>
                ]
            }, {
                label: "Бицепс",
                data: [
                <#list diary as page>
                    <#if page.biceps??>
                        [new Date("${page.getDateStringForJS()}"), ${page.biceps}]<#sep>,</#sep>
                    </#if>
                </#list>
                ]
            }, {
                label: "Грудь",
                data: [
                <#list diary as page>
                    <#if page.chest??>
                        [new Date("${page.getDateStringForJS()}"), ${page.chest}]<#sep>,</#sep>
                    </#if>
                </#list>
                ]
            }, {
                label: "Талия",
                data: [
                <#list diary as page>
                    <#if page.waist??>
                        [new Date("${page.getDateStringForJS()}"), ${page.waist}]<#sep>,</#sep>
                    </#if>
                </#list>
                ]
            }, {
                label: "Бедро",
                data: [
                <#list diary as page>
                    <#if page.hip??>
                        [new Date("${page.getDateStringForJS()}"), ${page.hip}]<#sep>,</#sep>
                    </#if>
                </#list>
                ]
            }, {
                label: "Вес",
                data: [
                <#list diary as page>
                    <#if page.weight??>
                        [new Date("${page.getDateStringForJS()}"), ${page.weight}]<#sep>,</#sep>
                    </#if>
                </#list>
                ]
            }
        ];
        var plot_conf = {
            series: {lines: {show: true}, points: {show: true}},
            xaxis: {
                mode: "time",
                timeformat: "%d %b %y",
                monthNames: ["янв", "феб", "мар", "апр", "май", "июн", "июл", "авг", "сеп", "окт", "нов", "дек"]
            }
        };
        $.plot($("#placeholder"), graphData, plot_conf);
    });
</script>

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
                    <li><a href="/diary/new-diary-page">Новая страница</a></li>
                    <li><a href="/gallery/">Галерея</a></li>
                    <li class="active"><a href="#">График</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Выход</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div id="placeholder" class="content"></div>
</div>

</body>
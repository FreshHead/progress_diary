<#ftl encoding='UTF-8'>
<html>
<head>
    <title>Graph</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script type="text/javascript" src="/js/lib/jquery.min.js"></script>
    <script type="text/javascript" src="/js/lib/jquery.flot.min.js"></script>
    <script type="text/javascript" src="/js/lib/jquery.flot.time.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/style.css">
</head>
<script>
    $(document).ready(function () {
        var d = [
            <#list diary as page>
                [new Date(${page.getDateStringForJS()}), ${page.biceps}]<#sep>,</#sep>
            </#list>
        ];
        var timeFormat = "%d.%m.%y";
        var plot_conf = {
            series: {lines: {show: true}, points: {show: true}},
            xaxis: {mode: "time", timeformat: timeFormat}
        };
        $.plot($("#placeholder"), [d], plot_conf);
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
                    <li><a href="/diary/">Дневник</a></li>
                    <li><a href="/gallery/">Галерея</a></li>
                    <li class="active"><a href="#">График</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="/logout"><span class="glyphicon glyphicon-log-in"></span> Выход</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <div id="placeholder"></div>
</div>

</body>
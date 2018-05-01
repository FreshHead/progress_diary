<#ftl encoding='UTF-8'>
<html>
<head>
    <title>Gallery</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="container">
    <div id="myCarousel" class="carousel slide" data-ride="carousel" data-interval="false">
        <div class="carousel-inner">
            <#list filenames as filename>
                <div class="item">
                    <img src="/gallery/imageDisplay?filename=${filename}"/>
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
<script>
    document.getElementsByClassName("item").item(0).classList.add("active");
</script>
</body>
</html>
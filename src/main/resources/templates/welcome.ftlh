<!DOCTYPE html>
<html lang="en">
<#import "spring.ftl" as spring />
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie-edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <link rel="stylesheet" href="css/main.css">

</head>
<body>
<#if aut>
    <#include "header.ftlh">

<#else>
    <#include "headerNotAut.ftlh">
</#if>


<div class="carousel slide" data-ride="carousel" id="slides">
    <ul class="carousel-indicators">
        <li data-target="#slides" data-slide-to="0" class="active"></li>
        <li data-target="#slides" data-slide-to="1"></li>
    </ul>
    <div class="carousel-inner">
        <div class="carousel-item active">
            <img src="img/space1.jpg">
            <div class="carousel-caption">
                <h1 class="display-2">Spatium</h1>
                <h3><@spring.message 'welcome.page.welcome'/></h3>
            </div>
        </div>
        <div class="carousel-item">
            <img src="img/space2.jpg">
            <div class="carousel-caption">
                <h2><@spring.message 'welcome.page.phrase'/></h2>
                <h3><@spring.message 'welcome.page.author'/></h3>
            </div>
        </div>
    </div>
</div>
<div class="container-fluid">
    <div class="row jumbotron">
        <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
            <p class="lead"><img src="img/createChannel.png" width="500" align="middle"> <@spring.message 'welcome.page.create'/></p>
        </div>


    </div>
    <div class="row jumbotron">
        <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
            <p class="lead"><img src="img/videoWatch1.png" width="500" align="middle"><@spring.message 'welcome.page.watch'/></p>

        </div>


    </div>

</div>
<div class="container-fluid">
    <div class="row text-center alert">
        <div class="col-12">
            <h1 class="display-4"><@spring.message 'welcome.page.join'/></h1>
        </div>
        <hr>
        <div class="col-12">
            <a href="/signIn" class="nav-link"><@spring.message 'buttons.login'/></a>
            <a><@spring.message 'welcome.page.or'/></a>
            <a href="/signUp" class="nav-link"><@spring.message 'buttons.signup'/></a>
        </div>
    </div>
</div>
</body>
</html>
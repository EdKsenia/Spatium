<#import "spring.ftl" as spring />
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie-edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <link rel="stylesheet" href="static/css/header.css">

</head>
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
    <div class="container-fluid">

        <a href="/main" class="navbar-brand"><img src="img/logo1.png"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive2">
            <ul class="navbar-nav ml-auto">
                <li class="navbar-item">
                    <form method="get" action="/signIn" class="nav-link">
                        <button class="b1"><@spring.message 'buttons.login'/></button>
                    </form>
                </li>
                <li class="navbar-item">
                    <form method="get" action="/signUp" class="nav-link">
                        <button class="b1"><@spring.message 'buttons.signup'/></button>
                    </form>
                </li>
            </ul>

        </div>

    </div>
</nav>

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



<#--<% session = request.getSession();-->
<#--    if (session.getAttribute("current_user") != null) { %>-->
<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">
    <div class="container-fluid">

        <a href="/main" class="navbar-brand"><img src="img/logo1.png" style="width: 60px"></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse"
                data-target="#navbarResponsive">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">

                <li class="navbar-item">
                    <form method="get" action="/main" class="nav-link">
                        <button class="b1">Main</button>
                    </form>
                </li>
                <li class="navbar-item">
                    <form method="get" action="/profile" class="nav-link">
                        <button class="b1">My profile</button>
                    </form>
                </li>
                <li class="navbar-item">
                    <form method="get" action="/myChannel" class="nav-link">
                        <button class="b1">My channel</button>
                    </form>
                </li>

                <li class="navbar-item">
                    <form method="get" action="/help" class="nav-link">
                        <button class="b1">Help</button>
                    </form>
                </li>
                <li class="navbar-item">
                    <form method="post" action="/logout" class="nav-link">
                        <button class="b1" type="submit" name="logout" value="Logout" class="nav-link">Logout</button>
                    </form>
                </li>

            </ul>
        </div>
    </div>
</nav>
<#--<% } else { %>-->
<#--<nav class="navbar navbar-expand-md navbar-light bg-light sticky-top">-->
<#--    <div class="container-fluid">-->

<#--        <a href="/main" class="navbar-brand"><img src="img/logo1.png"></a>-->
<#--        <button class="navbar-toggler" type="button" data-toggle="collapse"-->
<#--                data-target="#navbarResponsive">-->
<#--            <span class="navbar-toggler-icon"></span>-->
<#--        </button>-->
<#--        <div class="collapse navbar-collapse" id="navbarResponsive2">-->
<#--            <ul class="navbar-nav ml-auto">-->
<#--                <li class="nav-item active">-->
<#--                    <a href="/login" class="nav-link">LogIn</a>-->
<#--                </li>-->
<#--                <li class="nav-item active">-->
<#--                    <a href="/register" class="nav-link">SignUp</a>-->
<#--                </li>-->
<#--                <li class="nav-item active">-->
<#--                    <a href="/help" class="nav-link">Help</a>-->
<#--                </li>-->
<#--            </ul>-->

<#--        </div>-->

<#--    </div>-->
<#--</nav>-->


<#--<%}%>-->

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/register.css">
</head>
<body>

<#if error??>
    <h5 style="color: darkred">Wrong password ar email. Please try again</h5>
</#if>
<div class="sign_in">
    <h1>Login</h1>
    <form action="/signIn" method="post">
        <div class="form-group row">
<#--            <div class="col-sm-7">-->
                <input type="text" name="email" class="form-control" placeholder="Enter your email" required="required"
                       autofocus>
<#--            </div>-->
        </div>
        <div class="form-group row">
<#--            <div class="col-sm-7">-->
                <input type="password" name="password" class="form-control" placeholder="Enter your password"
                       required="required"><br>
<#--            </div>-->
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <div class="check"><p><input type="checkbox" name="remember-me"> Remember me</p></div>
        <div class="buttonLogin">
                <input type="submit" name="login" value="Login">
        </div>
        <hr>
        <#--        <input name="email" placeholder="Email">-->
        <#--        <input type="password" name="password" placeholder="Пароль">-->
        <#--        <input type="submit" value="Вход">-->
    </form>
    <form action="/welcome" method="get">
        <div class="buttonBack">
            <input type="submit" value="Back">
        </div>
    </form>
    <div>
        <#--        <a href="/welcome" class="button">Back</a>-->

    </div>
</div>
</body>
</html>
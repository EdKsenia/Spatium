<!doctype html>
<html lang="en">
<#import "spring.ftl" as spring />
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Register</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/register.css">
</head>
<body>
<div class="sign_up">
    <h1><@spring.message 'register.page'/></h1>
    <div>
        <form action="/signUp" method="post">
            <div class="form-group row">
<#--                <div class="col-sm-7">-->
                    <input type="text" name="name" class="form-control" placeholder="<@spring.message 'register.page.name'/>"
                           required="required"
                           autofocus>
<#--                </div>-->
            </div>
            <div class="form-group row">
<#--                <div class="col-sm-7">-->
                    <input type="date" name="born" class="form-control" placeholder="Enter your date of born"
                           required="required"></br>
<#--                </div>-->
            </div>
            <div class="form-group row">
<#--                <div class="col-sm-7">-->
                    <textarea type="text" name="about" class="form-control" placeholder="<@spring.message 'register.page.about'/>"
                              required="required"></textarea></br>
<#--                </div>-->
            </div>
            <div class="form-group row">
<#--                <div class="col-sm-7">-->
                    <input type="email" name="email" class="form-control" placeholder="<@spring.message 'register.page.email'/>"
                           required="required">
<#--                </div>-->
            </div>
            <div class="form-group row">
<#--                <div class="col-sm-7">-->
                    <input type="password" oninput="checkPassword()" id="password" name="password" class="form-control"
                           placeholder="<@spring.message 'register.page.password'/>" required="required">
                    <br>
                    <div class="card-body__text-info" style="color: #FFFFFF; font-size: 16px">
                        <@spring.message 'password.rule'/>
                        <ul>
                            <li id="passwordLengthError">
                                <@spring.message 'password.characters'/>
                            </li>
                            <li id="passwordContainUpperCaseLetterError">
                                <@spring.message 'password.letter'/>
                            </li>
                            <li id="passwordContainNumberError">
                                <@spring.message 'password.number'/>
                            </li>
                        </ul>
                    </div>
<#--                </div>-->
            </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
            <div class="buttonRegister">
                <input type="submit" name="register" value="Register">
            </div>
            <hr>
            <#--        <input name="name" placeholder="Имя">-->
            <#--        <input name="email" placeholder="Email">-->
            <#--        <input type="password" name="password" placeholder="Пароль">-->
            <#--        <input type="submit" value="РЕГИСТРАЦИЯ">-->
        </form>
        <form action="/welcome">
            <div class="buttonBack">
                <input type="submit" value="Back">
            </div>
        </form>
    </div>
    <#--    <div class="col-md-3"></div>-->
    <#--    <div class="col-md-6"></div>-->
    <#--    <div class="col-md-3"></div>-->
</div>

</body>
</html>

<script>
    function checkPassword() {
        var password = document.getElementById('password').value;
        var passwordLengthError = document.getElementById('passwordLengthError');
        var passwordContainUpperCaseLetterError = document.getElementById('passwordContainUpperCaseLetterError');
        var passwordContainNumberError = document.getElementById('passwordContainNumberError');
        var confirmPassword = document.getElementById('confirmPassword');
        var cond1 = false;
        var cond2 = false;
        var cond3 = false;
        console.log(password);
        if (password.length < 8) {
            passwordLengthError.style.color = "red";
            cond1 = false;
        } else {
            passwordLengthError.style.color = "green";
            cond1 = true;
        }
        if (password.toString().search(/[A-Za-z]/) === -1) {
            passwordContainUpperCaseLetterError.style.color = "red";
            cond2 = false;
        } else {
            passwordContainUpperCaseLetterError.style.color = "green";
            cond2 = true;
        }
        if (password.toString().search(/\d/) === -1) {
            passwordContainNumberError.style.color = "red";
            cond3 = false;
        } else {
            passwordContainNumberError.style.color = "green";
            cond3 = true;
        }
    }

</script>
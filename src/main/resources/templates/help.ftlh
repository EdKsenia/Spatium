<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie-edge">
    <title>Help</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>

    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/help.css">

</head>
<body>
<!--шапка-->

<#include "header.ftlh">

<hr>
<!--основной блок-->

<div class="container-fluid">
    <details>
        <summary>
            How to create channel?
        </summary>
        <div class="row jumbotron">
            <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
                <p class="lead"><img src="img/createChannel.png" width="250" align="middle">CLick "My channel" -> Enter your information -> Add some video</p>
            </div>


        </div>

    </details>
    <details>
        <summary>
            How to edit profile?
        </summary>
        <div class="row jumbotron">
            <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
                <p class="lead"><img src="img/editProf.png" width="250" align="middle">Click "My profile" -> Go to Change -> Enter new information. Dont forget add your photo.
                    share videos</p>
            </div>

        </div>

    </details>


</div>
<div class="container-fluid">
    <div class="row jumbotron">
        <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-10">
            <p class="lead">If you have any problems with the site, please contact us</p>


        </div>
        <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-2">
            <button onclick="show('block')" class="btn btn-success btn-lg" type="button">Ask a question</button>
        </div>
    </div>
</div>

<!--обратная связь-->
<div id="pageForm">
    <div class="pageFormHeader">
        <h3>Feedback</h3>
        <span class="pageFormClose" onclick="show('none')"></span>
    </div>
    <div class="pageFormContent">
        <form action="/help" method="post">
            <label class="pageFormLabel">
                <span class="pageFormTitle">Name:</span>
                <input type="text" name="name" required="required">
            </label>
            <label class="pageFormLabel">
                <span class="pageFormTitle">Your phone:</span>
                <input type="tel" name="phone" id="phone" placeholder="+79001234567" pattern="[+]7[0-9]{10,14}" required="required">
            </label>
            <label class="pageFormLabel">
                <span class="pageFormTitle">Message:</span>
                <textarea name="text" required="required"></textarea>
            </label>
            <td colspan="2">
                <input onclick="sendMessage()" type="submit" name="send" value="Send">
            </td>
        </form>
    </div>
</div>
<!--Прозрачный фон-->
<div onclick="show('none')" id="grey"></div>

<figure>
    <div class="fixed-wrap">
        <div id="fixedpr">

        </div>

    </div>

</figure>


<hr>

<script>
    //Функция показа
    function show(state) {
        document.getElementById('pageForm').style.display = state;
        document.getElementById('grey').style.display = state;
    }
</script>
<script src="https://code.jquery.com/jquery-2.2.4.js" charset="utf-8"></script>
<script>
    function sendMessage() {
        $.ajax({
            url: "/help/sendMessage",
            data: {
                "phone": $('#phone').val()
            },
            success: function (phone) {

                // $('#phone').attr('value', ''+ phone);
            }
        })
    }
    // function signUp() {
    //     $.ajax({
    //         type: "POST",
    //         url: "/signUp",
    //         data: {
    //             name: $('#name').val(),
    //             email: $('#email').val(),
    //             password: $('#password').val(),
    //             phone: $('#phone').val(),
    //             confirmCode: $('#confirmCode').val(),
    //             code: $('#code').val()
    //         },
    //         success: function (msg) {
    //             if (msg == 'ok') {
    //                 window.location.href = "/signIn"
    //             } else {
    //                 alert('wrong code, try again')
    //             }
    //         }
    //     })
    // }
</script>
</body>
</html>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Confirm</title>
    <style>
        li {
            list-style-type: none;
        }
    </style>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie-edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap..">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.."></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/p.."></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap..."></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <link rel="stylesheet" href="static/css/main.css">
    <link rel="stylesheet" href="css/profile.css">
</head>
<body>
<div class="container" style="margin: 0; margin-top: 2%; margin-left: 10%;">
    <div class="main-section">
        <div class="row"><h2>Confirm your profile</h2></div>

    </div>
</div>



<#if isConfirmed == true>
    <h1>Success!</h1>
<#else>
    <h1>Try again</h1>
</#if>
</body>
</html>

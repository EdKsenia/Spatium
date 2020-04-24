<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create channel</title>
    <style>
        li {
            list-style-type: none; /* Убираем маркеры */
        }
    </style>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie-edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/create_channel.css">
</head>
<body>
<#include "header.ftlh">
<div class="wrapper">
    <div class="header">
        <div class="inner-header">

        </div>
    </div>
    <div class="sidebar">
        <div class="inner-sidebar">
            <div class="main-section" id="form_create_channel">
                <h2>Create channel</h2>


                <form action="/createChannel" method="post" name="crChForm" enctype="multipart/form-data">

                    <div class="row" id="info1">
                        <input type="text" name="name" placeholder="Title*" required="required" autofocus><br>
                    </div>
                    <div class="row" id="info">
                        <input type="text" name="about" placeholder="About*" required="required"><br>
                    </div>
                    <hr>
                    <div class="row" id="media">
                        <#include "file_upload.ftlh">
<#--                        <input type="file" name="img"/>-->
                    </div>
                    <br>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <div class="row" id="submit">
                        <input type="submit" name="saveChannel" value="Save">
                    </div>
                    <br>


                </form>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="inner-footer"></div>
</div>

</div>

</body>
</html>
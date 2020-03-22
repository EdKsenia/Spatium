<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Profile</title>
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
    <link rel="stylesheet" href="css/change_profile.css">
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

            <div class="main-section" id="form_edit_profile">
                <h2>Edit profile</h2>


                <form action="/changeProfile" method="post" name="editPro" enctype="multipart/form-data">

                    <div class="row" id="info1">
                        <input type="text" name="name" placeholder="Name*" value="${user.name}"><br>
                    </div>

                    <div class="row" id="info">
                        <input type="text" name="born" placeholder="Born*" value="${user.born}"><br>
                    </div>

                    <div class="row" id="info">
                        <textarea name="about" placeholder="AboutMe*" rows="4" cols="54"
                                  value="${user.about}"></textarea><br>
                    </div>
                    <hr>
<#--                    <div class="row" id="media">-->
<#--                        Change photo-->
<#--                        <input type="file" name="fileP" value="${img}" required="required">-->
<#--                    </div>-->
<#--                    <br>-->
                    <div class="row" id="submit">
                        <input type="submit" name="saveNote" value="Save">
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
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add a note</title>
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
    <link rel="stylesheet" href="css/add_note.css">
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

            <div class="main-section" id="form_add_note">
                <h2>Add a video</h2>
                <form action="/addNote" method="post" name="addN" enctype="multipart/form-data" style="margin-left: 40px">

                    <div class="row" id="title">
                        <input type="text" name="name" placeholder="Title*" required="required" autofocus><br>
                    </div>
                    <div class="row" id="description">
                        <textarea name="description" placeholder="Description*"
                                  required="required" rows="7" cols="50"></textarea><br>
                    </div>
                    <hr>
                    <div  class="row" id="media">
                        +Add video
                        <input type="file" name="video"/>
                    </div>
                    <br>
                    <div class="row" id="media">
                        +Add preview
                        <input type="file" name="img"/>
                    </div>
                    <br>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <div class="row">
                        <input type="submit" name="saveNote" value="Save">
                    </div>
                    <br>
                </form>
            </div>
        </div>

    </div>
</div>
<br>
<div class="footer">
    <div class="inner-footer"></div>
</div>

</div>

</body>
</html>
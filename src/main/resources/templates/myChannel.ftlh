<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My channel</title>
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
    <link rel="stylesheet" href="css/my_channel.css">

</head>
<body>
<#include "header.ftlh">
<div class="wrapper">


    <div class="sidebar">

        <div class="carousel slide" data-ride="carousel" id="slides">
            <ul class="carousel-indicators">
                <li data-target="#slides" data-slide-to="0" class="active"></li>
            </ul>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="${channel.img}">
                    <div class="carousel-caption">
                        <h1 class="display-2">${name}</h1>
                        <h3>${description}</h3>
                    </div>
                </div>
            </div>
        </div>
        <div class="inner-sidebar">

            <h4>Video</h4>
            <div>
                <form method="post" action="/addNote">
                    <a href="/addNote" type="submit" name="addNote" value="addN">+Add a video</a>
                </form>
            </div>
            <p></p>
            <#--            <% List<Note> not = (List<Note>) request.getAttribute("notes");-->
            <#--                for (Note n : not) {-->
            <#--                    int id = n.getId();-->
            <#--                    String preview = n.getPreview();-->
            <#--                    String name = n.getName();-->
            <#--                    String description = n.getDescription();-->
            <#--                    Date date = n.getDate();-->
            <#--            %>-->

            <#--            <div class="container-fluid">-->
            <#--                <div class="row">-->
            <#--                    <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-4">-->
            <#--                        <p class="lead"><img src= <%= preview %>>-->
            <#--                    </div>-->
            <#--                    <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-4">-->
            <#--                        <div class="row">-->

            <#--                            <div class="title">-->
            <#--                                <form action="/note" method="post">-->
            <#--                                    <button name="id" value="<%= id %>"><%= name %>-->
            <#--                                    </button>-->
            <#--                                </form>-->
            <#--                            </div>-->
            <#--                        </div>-->
            <#--                        <div class="row">-->

            <#--                            <%= date %>-->

            <#--                        </div>-->
            <#--                        <div class="row" id="media2">-->

            <#--                            <%= description %>-->
            <#--                        </div>-->
            <#--                        </p>-->

            <#--                    </div>-->
            <#--                    <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-1">-->
            <#--                        <div>-->
            <#--                            <form  method="post" action="/myChannel">-->
            <#--                                <button name="noteId" value="<%= id %>">Delete</button>-->
            <#--                            </form>-->
            <#--                        </div>-->
            <#--                    </div>-->
            <#--                    <hr>-->
            <#--                </div>-->
            <#--                <hr>-->
            <#--            </div>-->
            <#--            <%}%>-->

        </div>
        <div class="footer">
            <div class="inner-footer"></div>
        </div>

    </div>

</body>
</html>
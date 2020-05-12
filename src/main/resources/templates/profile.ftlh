<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>My profile</title>
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
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/profile.css">
</head>
<body>
<#include "header.ftlh">
<div class="container" style="margin: 0; margin-top: 2%; margin-left: 10%;">
    <div class="main-section">
        <div class="row"><h2>My profile</h2></div>
        <div class="nav">
            <div class="meme" id="photo">
                <div class="photoProfile">
                    <#if user.img?has_content>
                    <span><img src="files/${user.img}"></span>

                    <#else>
                        <span><img src="img/bg2.jpg"></span>
                    </#if>
                </div>
                <br>
                <br>
            </div>
            <div class="meme" id="infoProfile">
                <div class="row">
                    <label id="info">Name: </label>
                    ${user.name}
                </div>
                <div class="row">
                    <label> Mail: </label>
                    ${user.email}
                </div>
                <div class="row">
                    <label> Born: </label>
                    ${user.born}
                </div>
                <div class="row">
                    <label> About me: </label>
                    ${user.about}
                </div>
<#--                <div class="row">-->
<#--                    <label> My channel: </label>-->
<#--                    ${user.channel}-->
<#--                </div>-->
                <div class="links">
                    <#if channel?has_content>
                    <a href="/myChannel" type="submit" name="myChannel" value="Channel">My Channel</a>
                    <#else>
                        <a href="/createChannel" type="submit" name="create" value="Create">Create Channel</a>
                    </#if>
                    <a href="/changeProfile" type="submit" name="create" value="Change">Change</a>
                    <#if user.role=="ADMIN">
                        <a href="/index" type="submit" name="forum" value="Forum">Tex forum</a>
                    </#if>
                </div>
            </div>
            <br>
            <br>
        </div>

    </div>
</div>
</body>
</html>
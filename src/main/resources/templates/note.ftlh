<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie-edge">
    <title>Note</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap..">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.."></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/p.."></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap..."></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>

    <link rel="stylesheet" href="css/main.css">
        <link rel="stylesheet" href="css/note.css">
        <link rel="stylesheet" href="css/comment.css">

</head>
<body>
<#include "header.ftlh">


<div class="container-fluid">
    <div class="row jumbotron">
        <#--        <div class="col-md-1">-->
        <#--                        <#if prev?has_content>-->
        <#--                            <div>-->
        <#--                                <form action="/note" method="get">-->
        <#--            &lt;#&ndash;                        <button class="btn btn-primary" name="id" value=${prev.id}>previous&ndash;&gt;-->
        <#--            &lt;#&ndash;                        </button>&ndash;&gt;-->
        <#--                                    <a href="/note${prev.id}">previous-->
        <#--                                    </a></td>-->
        <#--                                </form>-->
        <#--                            </div>-->
        <#--            </#if>-->
        <#--        </div>-->
        <div class="col-md-10" id="mainvid">
            <div align="center" class="video_view">
                <video controls poster="files/${video.img.getStorageFileName()}" preload="none">
                    <source src="files/${video.video.getStorageFileName()}" type="video/mp4">
                </video>
            </div>
            <hr>
            <p><img src="files/${channel.fileInfo.storageFileName}">${channel.name}</p>
            <div class="desc">
                <label class="col-sm-2 col-form-label">Title: </label>
                <a href="#" type="submit" name="note" value="note">${video.name}</a>
            </div>
            <div class="desc">
                <label class="col-sm-2 col-form-label">Date: </label>
                <a>${video.getCreatedAt()}</a>
            </div>
            <div class="desc">
                <label class="col-sm-2 col-form-label">Description: </label>
                <a>${video.description}</a>
            </div>
        </div>
    </div>
    <#--                <#if next?has_content>-->
    <#--                    <div>-->
    <#--                        <form action="/note" method="get">-->
    <#--&lt;#&ndash;                            <button class="btn btn-primary" name="id" value=${next.id}>next&ndash;&gt;-->
    <#--&lt;#&ndash;                            </button>&ndash;&gt;-->
    <#--                            <a href="/note${next.id}">next-->
    <#--                            </a></td>-->
    <#--                        </form>-->
    <#--                    </div>-->
    <#--                </#if>-->

    <div class="comments">
        <h3 id = "res" class="title-comments">Comments </h3>
        <#if comments?has_content>
            <#list comments as comment>
                <ul class="media-list">
                    <li class="media">
                        <#--<div class="media-left">-->
                        <#--    <a>-->
                        <#--        <img class="media-object img-thumbnail" src="files/${comment.user}" alt="...">-->
                        <#--    </a>-->
                        <#--</div>-->
                        <div class="media-body">
                            <div class="media-heading">
                                <div class="author">${comment.user.name}
                                </div>
                                <div class="metadata">
                                    <span class="date">${comment.createdAt}</span>
                                </div>
                            </div>
                            <div class="media-text text-justify">${comment.text}
                            </div>
                        </div>
                        <hr>
                    </li>

                </ul>
            </#list>
        </#if>
    </div>

    <div class="media-body">
        <div class="media-heading">
            <div class="author">You</div>
            <div class="metadata">
                <span class="date">Now</span>
            </div>
            <div class="media-text text-justify">
                <form action="/comment${video.id}" method="post">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <span>Comment</span><br>
                    <textarea id="comment" name="text" cols="80" rows="7"></textarea><br>
                    <#--                    <input type="submit" name="send" value="Send">-->
                    <button onclick="f(${video.id})" name="send" id="send">Send</button>
                </form>
            </div>
        </div>
    </div>

</div>

<script type="application/javascript">
    function f(par) {
        $.ajax({
            url: "/comments"+par,
            data:{"text": $("#comment").val()},
            dataType: "json",
            type: "post",
            contentType: "application/json",
            success: function (msg) {
                var user = msg.user.name;
                var data = msg.createAt;
                var text = msg.text;

                $("#res").append("<ul class=\"media-list\"><li class=\"media\">" +
                    "<div class=\"media-body\"><div class=\"media-heading\">" +
                    "<div class=\"author\">"+user + "</div><div class=\"metadata\">" +
                    "<span class=\"date\">"+data+"</span></div></div>" +
                    "<div class=\"media-text text-justify\">"+data+"</div></div>" +
                    "<hr></li></ul>");
            }
        })

    }
</script>
</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie-edge">
    <title>Main</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/main1.css">


</head>
<body>
<!--шапка-->
<#include "header.ftlh">
<div class="col-md-12">
<div class="col-md-9 col-md-push-1">

    <div>
        <div class="container" id="search_form">
            <div class="nav"  align="center">
                <div class="col-xs-8 col-xs-offset-4" >

                    <form action="#" method="get" id="searchForm" class="input-group">
                        <div class="input-group-btn search-panel" id="choice">
                            <select name="search_param" id="search_param" class="btn btn-default dropdown-toggle"
                                    data-toggle="dropdown" onfocus="">
                                <option value="all">All</option>
                                <option value="note">Note</option>
                                <option value="username">Username</option>
                                <option value="channel">Channel</option>
                            </select>
                        </div>
                        <div align="center"><input type="text" class="form-control" name="x" id="query" oninput="f()"
                                                   placeholder="Search term..."></div>

<#--                        <%--                    <span class="input-group-btn">--%>-->
<#--                        <%--                        <button class="btn btn-default" type="submit">--%>-->
<#--                        <%--                           <span class="glyphicon glyphicon-search"></span>--%>-->
<#--                        <%--                        </button>--%>-->
<#--                        <%--                    </span>--%>-->
                    </form>
                </div>
                <script type="application/javascript">
                    function f() {
                        if ($("#query").val().length >= 1) {
                            $.ajax({
                                url: "/search",
                                data: {"query": $("#query").val(), "search_param": $("#search_param").val()},
                                dataType: "json",
                                success: function (msg) {
                                    if (msg.objects.length > 0) {
                                        $("#res").html("");
                                        for (var i = 0; i < msg.objects.length; i++) {
                                            var o = msg.objects[i];
                                            var id = o.id;
                                            var preview = o.preview;
                                            var name = o.name;
                                            var date = o.date;
                                            var description = o.description;

                                            $("#res").append("<div class=\"container-fluid\" id=\"content\"><div class=\"row\"><div class=\"col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-8\">"+
                                                "<p class=\"lead\"><img src= \'" + preview + "\'></p>"+
                                                "</div><div class=\"col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-4\"><div class=\"row\"><div class=\"title\">"+
                                                "<form action=\"/note\" method=\"post\">"+
                                                "<button name=\"id\" value=\"" + id + "\">" + name + "</button>"+
                                                "</form></div></div><div class=\"row\" id=\"date\">"+ date + "</div>"+
                                                "<div class=\"row\" id=\"media2\">" + description + "</div></p></div><hr></div><hr></div>");

                                        }
                                    } else {
                                        $("#res").html("No results..");
                                    }
                                }
                            })
                        } else {
                            $("#res").html("");
                        }
                    }
                </script>
            </div>
        </div>

        <div id="res"></div>

        <div class="sidebar">
            <div class="inner-sidebar">


                <h3>Last add</h3>
<#--                <% List<Note> not = (List<Note>) request.getAttribute("notes");-->
<#--                    for (Note n : not) {-->
<#--                        int id = n.getId();-->
<#--                        String preview = n.getPreview();-->
<#--                        String name = n.getName();-->
<#--                        String description = n.getDescription();-->
<#--                        Date date = n.getDate();-->
<#--                %>-->
<#--                <div class="container-fluid" id="content">-->
<#--                    <div class="row">-->
<#--                        <div class="col-xs-12 col-sm-12 col-md-9 col-lg-9 col-xl-8">-->
<#--                            <p class="lead"><img src= <%= preview %>></p>-->
<#--                        </div>-->
<#--                        <div class="col-xs-12 col-sm-12 col-md-3 col-lg-3 col-xl-4">-->
<#--                            <div class="row">-->

<#--                                <div class="title">-->
<#--                                    <form action="/note" method="post">-->
<#--                                        <button name="id" value="<%= id %>"><%= name %>-->
<#--                                        </button>-->
<#--                                    </form>-->
<#--                                </div>-->
<#--                            </div>-->
<#--                            <div class="row" id="date">-->

<#--                                <%= date %>-->

<#--                            </div>-->
<#--                            <div class="row" id="media2">-->

<#--                                <%= description %>-->
<#--                            </div>-->
<#--                            </p>-->

<#--                        </div>-->

<#--                        <hr>-->
<#--                    </div>-->
<#--                    <hr>-->
<#--                </div>-->
<#--                <%}%>-->
            </div>
        </div>
    </div>
</div>
 </div>

</body>
</html>


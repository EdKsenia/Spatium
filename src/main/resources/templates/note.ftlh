<%@ page import="models.Comment" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Date" %>
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
<!--шапка-->
<%@ include file="header.ftlh" %>


<div class="container-fluid">
    <% int id_prev = (Integer) request.getAttribute("id_prev");
        int id_next = (Integer) request.getAttribute("id_next");
        int id = (Integer) request.getAttribute("id_note");
    %>
    <div class="row jumbotron">
        <div class="col-md-1">
            <% if (id_prev != 0) {%>
            <div>
                <form action="/note" method="post">
                    <button class="btn btn-primary" name="id" value="<%= id_prev %>">previous
                    </button>
                </form>
            </div>
            <% } else {%>
            <% } %>
        </div>
        <div class="col-md-10" id="mainvid">
            <div align="center" class="video_view">
                <video controls poster="${preview}" preload="none">
                    <source src="${media}" type="video/mp4">
                </video>
            </div>

            <%--                <% if (id_prev != 0) {%>--%>
            <%--                <div>--%>
            <%--                    <form action="/note" method="post">--%>
            <%--                        <button name="id" value="<%= id_prev %>">previous--%>
            <%--                        </button>--%>
            <%--                    </form>--%>
            <%--                </div>--%>
            <%--                <% } else {%>--%>
            <%--                <% } %>--%>
            <%--                <% if (id_next != 0) {%>--%>
            <%--                <div>--%>
            <%--                    <form action="/note" method="post">--%>
            <%--                        <button name="id" value="<%= id_next %>">next--%>
            <%--                        </button>--%>
            <%--                    </form>--%>
            <%--                </div>--%>
            <%--                <% } else {%>--%>
            <%--                <% } %>--%>
            <hr>
            <p><img src="${prChannel}">${channelName}</p>
            <div class="desc">
                <label class="col-sm-2 col-form-label">Title: </label>
                <a href="#" type="submit" name="note" value="note">${noteName}</a>
            </div>
            <div class="desc">
                <label class="col-sm-2 col-form-label">Date: </label>
                <a>${date}</a>
            </div>
            <div class="desc">
                <label class="col-sm-2 col-form-label">Description: </label>
                <a>${description}</a>
            </div>


            <div class="comments">
                <h3 class="title-comments">Comments </h3>
                <ul class="media-list">
                    <% List<Comment> comments = (List<Comment>) request.getAttribute("comments");
                        for (Comment comment : comments) {
                            int id_com = comment.getId();
                            String text = comment.getText();
                            Date date = comment.getDate();
                            String username = comment.getUserName();
                            String img = comment.getImg();
// String name = comment.getName();
                    %>
                    <li class="media">
                        <div class="media-left">
                            <a>
                                <img class="media-object img-thumbnail" src="<%= img %>" alt="...">
                            </a>
                        </div>
                        <div class="media-body">
                            <div class="media-heading">
                                <div class="author"><%= username %>
                                </div>
                                <div class="metadata">
                                    <span class="date"><%=date %></span>
                                </div>
                            </div>
                            <div class="media-text text-justify"><%= text %>
                            </div>
                        </div>
                        <hr>
                    </li>
                    <%}%>

                </ul>
                <div class="media-body">
                    <div class="media-heading">
                        <div class="author">You</div>
                        <div class="metadata">
                            <span class="date">Now</span>
                        </div>
                        <div class="media-text text-justify">
                            <form action="/note" method="post">
                                <span>Comment</span><br>
                                <textarea id="comment" name="text" cols="80" rows="7"></textarea><br>
                                <button name="send" id="send" value="<%= id %>">Send</button>
                            </form>
                        </div>
                    </div>
                </div>
                </tbody>
                </table>
            </div>
        </div>
        <div class="col-md-1">
            <% if (id_next != 0) {%>
            <div>
                <form action="/note" method="post">
                    <button class="btn btn-primary" name="id" value="<%= id_next %>">next
                    </button>
                </form>
            </div>
            <% } else {%>
            <% } %>
        </div>
    </div>

</div>
</body>
</html>
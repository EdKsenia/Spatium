<!doctype html>
<html lang="en">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Users</title>
</head>
<body>
<div>
    <div align="center"><input type="text" name="x" class="form-control" id="query" oninput="f()"
                               placeholder="Search term..."></div>
    <script type="application/javascript">
        function f() {
            if ($("#query").val().length >= 1) {
                $.ajax({
                    url: "/users/search",
                    data: {"query": $("#query").val()},
                    dataType: "json",
                    success: function (msg) {
                        if (msg.length > 0) {
                            $("#res").html("");
                            for (var i = 0; i < msg.length; i++) {
                                var o = msg[i];
                                var id = o.id;
                                var name = o.name;
                                var email = o.email;


                                $("#res").append("<tr>\n" +
                                    "                <td>" + name + "</td>\n" +
                                    "                <td>" + email + "</td>\n" +
                                    "                <td><a href=\"/users/" + id + "\">Посмотеть</a></td>\n" +
                                    "            </tr>");

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

    <table>
        <tr>
            <th>Имя</th>
            <th>email</th>
        </tr>

        <#list users as user>
            <tr>
                <div id="res"></div>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td><a href="/users/${user.id}">Посмотеть</a></td>
            </tr>
        </#list>
    </table>
</div>
</body>
</html>


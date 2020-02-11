<%--
  Created by IntelliJ IDEA.
  User: ssadm_wvqnac4
  Date: 11.02.2020
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Apartments list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">
                    <li><button type="button" id="index" class="btn btn-default navbar-btn">List all apartments</button></li>

                    <li><button type="button" id="add_app" class="btn btn-default navbar-btn">Add Appartment</button></li>

                </ul>
                <form class="navbar-form navbar-left" role="search" action="/search" method="post">
                    <div class="form-group">
                        <input type="text" class="form-control" name="id" placeholder="Search">
                    </div>
                    <button type="submit" class="btn btn-default">Submit</button>
                </form>
            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
<a href="/add_app">Add appartment</a></h3>

<table class="table table-striped">
    <thead>
    <tr>
        <td><b>Id</b></td>
        <td><b>Address</b></td>
        <td><b>FirstName</b></td>
        <td><b>SecondName</b></td>
        <td><b>ThirdName</b></td>
    </tr>
    </thead>

    <form action="edit_app" method="post">
        <c:forEach items="${apps}" var="apps">
            <tr>
                <td>${apps.id}</td>
                <td>${apps.adr}</td>
                <td>${apps.people.get(0).name}</td>
                <td>${apps.people.get(1).name}</td>
                <td>${apps.people.get(2).name}</td>

            </tr>
        </c:forEach>
    </form>
</table>

</div>
    <script>
        $('#add_app').click(function(){
            window.location.href='/add_app';
        });

        $('#index').click(function(){
            window.location.href='/';
        });
    </script>
</body>
</html>

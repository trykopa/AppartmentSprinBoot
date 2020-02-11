
<%--
  Created by IntelliJ IDEA.
  User: ssadm_wvqnac4
  Date: 11.02.2020
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add appartment</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>
<div class="container">
<form accept-charset="UTF-8" action="/add_appertment" autocomplete="off" method="post" >
    <div class="form-group">
        <label for="address">Address</label>
        <input name="adr" type="text" class="form-control" id="address" placeholder="Address">
    </div>
    <div class="form-group">
        <label for="firstname">Firs people name</label>
        <input name="firstname" type="text" class="form-control" id="firstname" placeholder="First people name">
    </div>
    <div class="form-group">
        <label for="secondname">Second people name</label>
        <input name = "secondname" type="text" class="form-control" id="secondname" placeholder="Second people name">
    </div>
    <div class="form-group">
        <label for="thirdname">Third people name</label>
        <input name = "thirdname" type="text" class="form-control" id="thirdname" placeholder="Third people name">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>

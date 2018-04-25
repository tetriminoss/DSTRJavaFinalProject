<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="PrintPackage.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Optional theme -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

        <!-- Latest compiled and minified JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

        <title>LOGIN Page</title>
    </head>
    <%
      request.getSession().invalidate();  
    %>
    <body>
        <div class="col-sm-12" style="height:140px;background-color: lightblue; text-align: center; font-family:'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace; font-size: 2.5em; color: white">
            <br>
            <b>Last Minute Club Printing Company.</b>
        </div>
        <div class="col-sm-4">
        </div>
        <div class="col-sm-4">
            <hr style="border-width: 2px">
            <center><h2>Staff Login:</h2></center>
            <hr style="border-width: 2px;">
            <!-- following sections will be depending on the situation
                        if the situation is that checking if the textboxes are null something will be sent to the servlet to show something to the user,
                        if the situation is that it is editing or showing something, a set of values from the database will be put in to the textboxes automatically
                        you will be able to see what will be set by looking at the name of the variable.-->
            <form action="login" method="post">
                <div class="form-group form-group-lg">
                    <!--<label for="userName" style="font-size: 1.2em">User Name:</label>-->
                    <input type="text" class="form-control" id="userName" name="userName" placeholder="Enter User Name">
                </div>
                <div class="form-group form-group-lg">
                    <!--<label for="password" style="font-size: 1.2em">Password:</label>-->
                    <input type="password" class="form-control" id="password" name="password" placeholder="Enter Password">
                </div>
                <br>
                <button type="submit" value="login" class="btn btn-primary btn-lg btn-block">Login</button>
                <br>
                <center>
                <span style="color:red; font-size: 1.2em"><b><c:out value="${message}"/></b></span>
                </center>
            </form>
                <br><br>
        </div>
        <div class="col-sm-4">
        </div>
        <div class="col-sm-12" style="height:120px;background-color: lightblue; text-align: center; font-family:'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace; font-size: 1.9em; color: white">
            <br>
            &COPY;2018 LMC ltd.
        </div>
    </body>
</html>

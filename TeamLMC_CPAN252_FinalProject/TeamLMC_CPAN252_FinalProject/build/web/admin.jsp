<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="PrintPackage.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

        <title>Admin Page</title>
    </head>
    <body>
    <%  
        session = request.getSession(false); 
        Login newLogin = (Login)session.getAttribute("newLogin"); 
    %>
        <div class="col-sm-12" style="height:140px;background-color: lightblue; text-align: center; font-family:'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace; font-size: 2.5em; color: white">
            <br>
            <b>Last Minute Club Printing Company.</b>
        </div>
        <div class="col-sm-4">
        </div>
        <!-- following sections will be depending on the situation
                        if the situation is that checking if the textboxes are null something will be sent to the servlet to show something to the user,
                        if the situation is that it is editing or showing something, a set of values from the database will be put in to the textboxes automatically
                        you will be able to see what will be set by looking at the name of the variable.-->
        <div class="col-sm-4" style="text-align: center">
            <hr style="border-width: 2px;">
            <h2><b>Administrative Menu:</b></h2>
            <c:if test="${newLogin != null}">
                <h5><b>Username:</b> <c:out value="${newLogin.userName}"/>&nbsp;&nbsp;<b>ID:</b> <c:out value="${newLogin.id}"/>&nbsp;&nbsp;<b>Agent ID:</b> <c:out value="${newLogin.agentId}"/></h5>
            </c:if>
            <hr style="border-width: 2px;">
            <a href="list" class="btn btn-success btn-lg btn-block">Locations for Distribution</a>
            <br><br>          
            <a href="listAgents" class="btn btn-primary btn-lg btn-block">Marketing Agents Management</a>
            <br><br>          
            <a href="adminList" class="btn btn-warning btn-lg btn-block">Records Added by Agents</a>
            <br><br>
            <a href="approvedOrdersList" class="btn btn-default btn-lg btn-block">View Approved Orders</a>
            <br><br>
            <a href="noPayOrdersList" class="btn btn-default btn-lg btn-block">View Orders with No Payment Received</a>
            <br><br>
            <a href="listLogins" class="btn btn-info btn-lg btn-block">User Data</a>
            <br><br>
            <a href="x" class="btn btn-danger btn-lg btn-block">Logout</a>
            <br><br><br>
        </div>
        <div class="col-sm-4">
        </div>
        <div class="col-sm-12" style="height:120px;background-color: lightblue; text-align: center; font-family:'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace; font-size: 1.9em; color: white">
            <br>
            &COPY;2018 LMC ltd.
        </div>
    </body>
</html>

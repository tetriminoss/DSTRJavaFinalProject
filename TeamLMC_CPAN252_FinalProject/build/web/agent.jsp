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

        <title>Marketing Agent Page</title>

    </head>
    <body>
        <%--<c:if test="${login.userName == null}">
            <!--redirect back to login-->
        </c:if>--%>
        <div class="col-sm-12" style="height:140px;background-color: lightblue; text-align: center; font-family:'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace; font-size: 2.5em; color: white">
            <br>
            <b>Last Minute Club Printing Company.</b>
        </div>
        <div class="col-sm-4">
        </div>
        <div class="col-sm-4" style="text-align: center">
            <h2><b>Marketing Agent Menu:</b></h2>
            <c:if test="${login != null}">
                <h5><b>Username:</b> <c:out value="${login.userName}"/>&nbsp;&nbsp;<b>ID:</b> <c:out value="${login.id}"/>&nbsp;&nbsp;<b>Agent ID:</b> <c:out value="${login.agentId}"/></h5>
            </c:if>
                <br>
            <a href="x" class="btn btn-success btn-lg btn-block">Client Profiles</a>
            <br><br>          
            <a href="x" class="btn btn-primary btn-lg btn-block">Place Orders</a>
            <br><br>          
            <a href="x" class="btn btn-danger btn-lg btn-block">Return to Login</a>
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

<%@page contentType="text/html" isErrorPage="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
    </head>
    <body>
    <center>
        <br><br><br><br><br><br><br>
        <h1>! ERROR ! ERROR ! ERROR !</h1><br>
        <h1>Error message below:</h1>
        <h1><%=exception.getMessage()%></h1>
    </center>
</body>
</html>

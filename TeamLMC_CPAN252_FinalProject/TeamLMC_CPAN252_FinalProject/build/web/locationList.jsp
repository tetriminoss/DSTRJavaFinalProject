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

        <title>Locations List Page</title>

        <!--<base href="TeamLMC_CPAN252_FinalProject/" >-->
    </head>
    <body>          
        <div class="col-sm-12" style="height:140px;background-color: lightblue; text-align: center; font-family:'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace; font-size: 2.5em; color: white">
            <br>
            <b>Last Minute Club Printing Company.</b>
        </div>
        <div class="col-sm-12" style="background-color: AliceBlue; height: 85px">
            <center>
                <h2>
                    <a href="admin.jsp" class="btn btn-info btn-lg">Admin Home</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="new" class="btn btn-info btn-lg">Add New Location</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="list" class="btn btn-info btn-lg">List All Locations</a>

                </h2>
            </center>
            <br>
        </div>
        <div class="col-sm-2">

        </div>
        <div class="col-sm-8">
            <table class="table table-bordered table-striped">
                <caption><h2>List of Locations</h2></caption>
                <thead>
                    <tr class="info">
                        <th>ID</th>
                        <th>Location Name</th>
                        <th>Distribution Capacity</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- following sections will be depending on the situation
                        if the situation is that checking if the textboxes are null something will be sent to the servlet to show something to the user,
                        if the situation is that it is editing or showing something, a set of values from the database will be put in to the textboxes automatically
                        you will be able to see what will be set by looking at the name of the variable.-->
                    <c:forEach var="location" items="${listLocation}">
                        <tr>
                            <td><c:out value="${location.id}" /></td>
                            <td><c:out value="${location.locationName}" /></td>
                            <td><c:out value="${location.distributionCapacity}" /></td>
                            <td>
                                <a href="edit?id=<c:out value='${location.id}' />" class="btn btn-success btn-xs">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="delete?id=<c:out value='${location.id}' />" class="btn btn-danger btn-xs">Delete</a>                     
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
        </div>
        <div class="col-sm-2">

        </div>
        <div class="col-sm-12" style="height:120px;background-color: lightblue; text-align: center; font-family:'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace; font-size: 1.9em; color: white">
            <br>
            &COPY;2018 LMC ltd.
        </div>
    </body>
</html>

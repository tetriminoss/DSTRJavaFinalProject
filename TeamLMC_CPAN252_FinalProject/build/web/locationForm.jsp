<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <title>Add/Update Location Page</title>
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
        <div class="col-sm-4">

        </div>
        <!-- following sections will be depending on the situation
                        if the situation is that checking if the textboxes are null something will be sent to the servlet to show something to the user,
                        if the situation is that it is editing or showing something, a set of values from the database will be put in to the textboxes automatically
                        you will be able to see what will be set by looking at the name of the variable.-->
        <div class="col-sm-4">
            <!--if a location is passed (as update is selected) then form action is update
            if location is null then it is insert,  also the Edit or add location is displayed-->
            <c:if test="${location != null}">
                <form action="update" method="post">
            </c:if>
            <c:if test="${location == null}">
                <form action="insert" method="post">
                </c:if>

                <h2>
                    <c:if test="${location != null}">
                        Edit Location
                    </c:if>
                    <c:if test="${location == null}">
                        Add New Location
                    </c:if>
                </h2>
                <br>   
                <c:if test="${location != null}">
                    <input type="hidden" name="id" value="<c:out value='${location.id}' />" />
                </c:if>
                <div class="form-group">
                    <label for="locationName">Location Name:</label>
                    <input type="text" class="form-control" id="locationName" name="locationName" placeholder="Enter Location Name" value="<c:out value='${location.locationName}' />">
                </div>
                <div class="form-group">
                    <label for="distributionCapacity">Distribution Capacity:</label>
                    <input type="number" class="form-control" id="distributionCapacity" name="distributionCapacity" placeholder="Enter Distribution Capacity" value="<c:out value='${location.distributionCapacity}' />">
                </div>
                <button type="submit" value="Save" class="btn btn-primary">Submit</button>
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <span style="color:red"><b><c:out value="${message}"/></b></span>
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

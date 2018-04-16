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
            <b>Last Minute Club Printing Company</b>
        </div>
        <div class="col-sm-2">

        </div>
        <div class="col-sm-8">
            <br>
            <center>
                <h2>
                    <a href="newAgent" class="btn btn-info btn-lg">Add New Marketing Agent</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="listAgents" class="btn btn-primary btn-lg">List All Marketing Agents</a>

                </h2>
            </center>
            <table class="table table-bordered table-striped">
                <caption><h2>List of Marketing Agents</h2></caption>
                <thead>
                    <tr class="info">
                        <th>ID</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Phone Number</th>
                        <th>Email</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="marketingAgent" items="${listMarketingAgent}">
                        <tr>
                            <td><c:out value="${marketingAgent.id}" /></td>
                            <td><c:out value="${marketingAgent.firstName}" /></td>
                            <td><c:out value="${marketingAgent.lastName}" /></td>
                            <td><c:out value="${marketingAgent.phoneNo}" /></td>
                            <td><c:out value="${marketingAgent.email}" /></td>
                            <td>
                                <a href="editAgent?id=<c:out value='${marketingAgent.id}' />" class="btn btn-success btn-xs">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="deleteAgent?id=<c:out value='${marketingAgent.id}' />" class="btn btn-danger btn-xs">Delete</a>                     
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
        </div>
        <div class="col-sm-12" style="height:120px;background-color: lightblue; text-align: center; font-family:'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace; font-size: 1.9em; color: white">
            <br>
            &COPY;2018 LMC ltd.
        </div>
    </body>
</html>

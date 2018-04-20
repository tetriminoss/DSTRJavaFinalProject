<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="PrintPackage.*" %>
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

        <title>Orders List Page</title>

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
                    <a href="agent.jsp" class="btn btn-info btn-lg">Agent Home</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="newOrder" class="btn btn-info btn-lg">Add New Order</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="listOrder" class="btn btn-info btn-lg">List All Orders</a>
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
                        <th>Agent ID</th>
                        <th>Client ID</th>
                        <th>Flyer Quantity</th>
                        <th>Flyer Layout</th>
                        <th>Flyer Image</th>
                        <th>Personal Copies</th>
                        <th>Payment Information</th>
                        <th>Invoice Number</th>
                        <th>Comments</th>
                        <th>Flyer Approved?</th>
                        <th>Payment Received?</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="order" items="${listOrder}">
                        <tr>
                            <td><c:out value="${order.id}" /></td>
                            <td><c:out value="${order.agentID}" /></td>
                            <td><c:out value="${order.clientID}" /></td>
                            <td><c:out value="${order.flyerQTY}" /></td>
                            <td><c:out value="${order.flyerLayout}" /></td>
                            <td><c:out value="${order.flyerImage}" /></td>
                            <td><c:out value="${order.personalCopy}" /></td>
                            <td><c:out value="${order.paymentInfo}" /></td>
                            <td><c:out value="${order.invoiceNum}" /></td>
                            <td><c:out value="${order.comments}" /></td>
                            <td><c:out value="${order.isFlyerArtApproved}" /></td>
                            <td><c:out value="${order.isPaymentReceived}" /></td>
                            <td>
                                <a href="edit?id=<c:out value='${order.id}' />" class="btn btn-success btn-xs">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="delete?id=<c:out value='${order.id}' />" class="btn btn-danger btn-xs">Delete</a>                     
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
        </div>
    </body>
</html>

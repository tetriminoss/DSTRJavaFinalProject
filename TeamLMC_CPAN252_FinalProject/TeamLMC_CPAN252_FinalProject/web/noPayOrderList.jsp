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

        <title>Orders Without Payment List Page</title>

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
                    <a href="noPayOrdersList" class="btn btn-info btn-lg">List All No Payment Orders</a>
                </h2>
            </center>
            <br>
        </div>
        <div class="col-sm-12">
            <table class="table table-bordered table-striped">
                <caption><h2>List of No Payment Orders</h2></caption>
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
                    </tr>
                </thead>
                <tbody>
                    <!-- following sections will be depending on the situation
                        if the situation is that checking if the textboxes are null something will be sent to the servlet to show something to the user,
                        if the situation is that it is editing or showing something, a set of values from the database will be put in to the textboxes automatically
                        you will be able to see what will be set by looking at the name of the variable.-->
                    <c:forEach var="order" items="${listNoPaydOrder}">
                        <tr>
                            <td><c:out value="${order.id}" /></td>
                            <td><c:out value="${order.agentID}" /></td>
                            <td><c:out value="${order.clientID}" /></td>
                            <td><c:out value="${order.flyerQTY}" /></td>
                            <td><c:out value="${order.flyerLayout}" /></td>
                            <td><c:out value="${order.flyerImg}" /></td>
                            <td><c:out value="${order.personalCopy}" /></td>
                            <td><c:out value="${order.paymentInfo}" /></td>
                            <td><c:out value="${order.invoiceNum}" /></td>
                            <td><c:out value="${order.comments}" /></td>
                            <c:choose>
                                <c:when test="${order.isFlyerArtApproved == 0}">
                                    <c:set var="artApprove" value="${'no'}"/>
                                </c:when>
                                <c:when test="${order.isFlyerArtApproved != 0}">
                                    <c:set var="artApprove" value="${'yes'}"/>
                                </c:when>
                           </c:choose>
                            <td><c:out value="${artApprove}" /></td>
                            <c:choose>
                                <c:when test="${order.isPaymentReceived == 0}">
                                    <c:set var="payRec" value="${'no'}"/>
                                </c:when>
                                <c:when test="${order.isPaymentReceived != 0}">
                                    <c:set var="payRec" value="${'yes'}"/>
                                </c:when>
                           </c:choose>
                            <td><c:out value="${payRec}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </div>
        <div class="col-sm-12" style="height:120px;background-color: lightblue; text-align: center; font-family:'Courier New', Courier, 'Lucida Sans Typewriter', 'Lucida Typewriter', monospace; font-size: 1.9em; color: white">
            <br>
            &COPY;2018 LMC ltd.
        </div>
    </body>
</html>

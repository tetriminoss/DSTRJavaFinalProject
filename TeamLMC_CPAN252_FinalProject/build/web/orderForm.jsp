<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
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

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <title>Add/Update Order Page</title>
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
        <div class="col-sm-4">

        </div>
        <div class="col-sm-4">
            <!--if an order is passed (as update is selected) then form action is update
            if order is null then it is insert,  also the Edit or add order is displayed-->
            <c:if test="${order != null}">
                <form action="updateOrder"  method="post">
            </c:if>
            <c:if test="${order == null}">
                <form action="insertOrder" method="post">
                </c:if>
            
                <h2>
                    <c:if test="${order != null}">
                        Edit Orders
                    </c:if>
                    <c:if test="${order == null}">
                        Add New Order
                    </c:if>
                </h2>
                <br>
                <c:if test="${order != null}">
                    <input type="hidden" name="id" value="<c:out value='${order.id}' />"/>
                </c:if>
                    <div class="form-group">
                        <label for="flyerQty">Flyer Quantity:</label>
                        <input type="number" class="form-control" id="flyerQty" name="flyerQty" placeholder="Enter Fly Quantity" value="<c:out value='${order.flyerQty}'/>"/>
                    </div>
                    <div class="form-group">
                        <label for="flyerQty">Flyer Layout:</label>
                        <select class="custom-select mr-sm-2" id="flyerLayout" name="flyerLayout">
                            <option select>Select Layout...</option>
                            <option value="Portrait">Portrait</option>
                            <option value="Landscape">Landscape</option>
                            <option value="Both">Both</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <c:forEach var="location" items="${listLocation}">
                            <input type="checkbox" name="locationID" value="<c:out value='${location.id}'/>">&nbsp;&nbsp;
                            <c:out value="${location.locationName}"/>
                            <br>
                        </c:forEach>
                    </div>
                    <div class="form-group">
                        <label for="paymentInfo">Credit Card Info:</label>
                        <input type="text" class="form-control" id="creditNum" name="creditNum" placeholder="Enter Your Credit Card Number" value="<c:out value='${order.paymentInfo}'/>"/>
                        <br>
                        <input type="text"  id="creditExp" name="creditExp" placeholder="Expiry date" value="<c:out value='${order.paymentInfo}'/>"/>
                        &nbsp;&nbsp;
                        <input type="text"  id="creditCVV" name="creditCVV" placeholder="CCV" value="<c:out value='${order.paymentInfo}'/>"/>
                    </div>
                    <div class="form-group">
                        <label for="personalCopy">Personal Copies</label>
                        <input type="number" class="form-control" id="personalCopies" name="personalCopies" placeholder="How many copies?" value="<c:out value='${order.personalCopy}'/>"/>
                    </div>
                    <div class="form-group">
                        <label for="clients">Client:</label>
                        <select class="custom-select mr-sm-2" id="clients" name="clients">
                            <option select>Select Client...</option>
                            <option value="x">Placeholder</option>
                            <option value="x">Placeholder</option>
                            <option value="x">Placeholder</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="comments">Comments:</label>
                        <input type="text" class="form-control" id="comments" name="comments" placeholder="Comments..." value="<c:out value='${order.comments}'/>"/>
                    </div>
                    <c:if test="${order != null}">
                        <div class="form-group">
                            <label for="artworkApprove">Artwork Approved?</label>
                            <input type="checkbox" class="form-control" id="artworkApproved" name="artworkApproved" value="Yes">
                        </div>
                        <div class="form-group">
                            <label for="paymentReceived">Payment Received?</label>
                            <input type="checkbox" class="form-control" id="paymentReceived" name="paymentReceived" value="Yes">
                        </div>
                    </c:if>
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

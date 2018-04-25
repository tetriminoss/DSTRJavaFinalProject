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
        <% 
        session=request.getSession(false);  
        Login newLogin = (Login)session.getAttribute("newLogin");
        %>
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
            <!-- following sections will be depending on the situation
                        if the situation is that checking if the textboxes are null something will be sent to the servlet to show something to the user,
                        if the situation is that it is editing or showing something, a set of values from the database will be put in to the textboxes automatically
                        you will be able to see what will be set by looking at the name of the variable.-->
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
                <input type="hidden" id="orderID" name="orderID" value="<c:out value='${order.id}'/>"/>
                    <input type="hidden" id="agentID" name="agentID" value="<c:out value='${newLogin.agentId}' />">
                
                    <div class="form-group">
                        <label for="flyerQty">Flyer Quantity:</label>
                        <input type="number" class="form-control" id="flyerQty" name="flyerQty" placeholder="Enter Fly Quantity" value="<c:out value='${order.flyerQTY}'/>"/>
                    </div>
                    <div class="form-group">
                        <label for="flyerLayout">Flyer Layout:</label>
                        <select class="custom-select mr-sm-2" id="flyerLayout" name="flyerLayout">
                            <option select>Select Layout...</option>
                            <option value="Portrait">Portrait</option>
                            <option value="Landscape">Landscape</option>
                            <option value="Both">Both</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <c:forEach var="location" items="${listLocation}">
                            <input type="checkbox" name="locationID" id="locationID" value="<c:out value='${location.id}'/>">&nbsp;&nbsp;
                            <c:out value="${location.locationName}"/>
                            <br>
                        </c:forEach>
                    </div>
                    <div class="form-group">
                        <label for="imgFlyer">Upload Image:</label>
                        <input type="file" id="flyerImg" name="flyerImg" accept=".jpg, .jpeg, .png" value="<c:out value='${order.flyerImg}'/>">
                    </div>
                    <div class="form-group">
                        <label for="paymentInfo">Credit Card Info:</label>
                        <input type="text" class="form-control" id="creditNum" name="creditNum" placeholder="Enter Your Credit Card Number" value="<c:out value='${creditNum}'/>"/>
                        <br>
                        <input type="text"  id="creditExp" name="creditExp" placeholder="Expiry date" value="<c:out value='${creditExp}'/>"/>
                        &nbsp;&nbsp;
                        <input type="text"  id="creditCVV" name="creditCVV" placeholder="CCV" value="<c:out value='${creditCVV}'/>"/>
                    </div>
                    <div class="form-group">
                        <label for="personalCopy">Personal Copies</label>
                        <input type="number" class="form-control" id="personalCopies" name="personalCopies" placeholder="How many copies?" value="<c:out value='${order.personalCopy}'/>"/>
                    </div>
                    <div class="form-group">
                        <label for="clients">Client:</label>
                        <select class="custom-select mr-sm-2" id="clientID" name="clientID">
                            <option select>Select Client...</option>
                            <c:forEach var="clients" items="${listClients}">
                                <option value="<c:out value="${clients.id}" />"><c:out value="${clients.firstName}" /> <c:out value="${clients.lastName}" /></option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="invoiceNum">Invoice #:</label>
                        <c:if test="${order != null}">
                            <input type="text" class="form-control" id="invoiceNum" name="invoiceNum" value="<c:out value='${order.invoiceNum}'/>" />
                        </c:if>
                        <c:if test="${order == null}">
                            <input type="text" class="form-control" id="invoiceNum" name="invoiceNum" value="<%= (int)Math.ceil(Math.random()*1000)%>" />
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="comments">Comments:</label>
                        <input type="text" class="form-control" id="comments" name="comments" placeholder="Comments..." value="<c:out value='${order.comments}'/>"/>
                    </div>
                    <c:if test="${order != null}">
                        <div class="form-group">
                            <label for="artworkApprove">Artwork Approved?</label>
                            <select name='isFlyerArtApproved'>
                                <option name="isFlyerArtApproved" value="1"  <c:if test="${order.isFlyerArtApproved=='1'}">selected</c:if>>Yes</option>
                                <option name="isFlyerArtApproved" value="0"  <c:if test="${order.isFlyerArtApproved=='0'}">selected</c:if>>No</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="paymentReceived">Payment Received?</label>
                            <select name='isPaymentReceived'>
                                <option name="isPaymentReceived" value="1"  <c:if test="${order.isPaymentReceived=='1'}">selected</c:if>>Yes</option>
                                <option name="isPaymentReceived" value="0" <c:if test="${order.isPaymentReceived=='0'}">selected</c:if>>No</option>
                            </select>
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

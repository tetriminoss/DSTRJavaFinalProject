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

        <title>Add/Update Client Page</title>
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
                    <a href="newClient" class="btn btn-info btn-lg">Add New Client</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="agentList" class="btn btn-info btn-lg">List All Clients</a>
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
            <c:if test="${client != null}">
                <form action="updateClient" method="post">
                </c:if>
                <c:if test="${client == null}">
                    <form action="insertClient" method="post">
                    </c:if>

                    <h2>
                        <c:if test="${client != null}">
                            Edit Client
                        </c:if>
                        <c:if test="${client == null}">
                            Add New Client
                        </c:if>
                    </h2>
                    <br>   
                    <c:if test="${client != null}">
                        <input type="hidden" name="id" value="<c:out value='${client.id}' />" />
                    </c:if>
                    <div class="form-group">
                        <label for="agentId">Agent ID:</label>
                        <c:if test="${client != null}">
                            <input type="text" class="form-control" id="agentId" name="agentId" placeholder="Enter Agent ID" value="<c:out value='${client.agentId}' />">
                        </c:if>
                        <c:if test="${client == null}">
                            <input type="text" class="form-control" id="agentId" name="agentId" placeholder="Enter Agent ID" value="<c:out value='${newLogin.agentId}' />">
                        </c:if>
                    </div>
                    <div class="form-group">
                        <label for="firstName">First Name:</label>
                        <input type="text" class="form-control" id="firstName" name="firstName" placeholder="Enter First Name" value="<c:out value='${client.firstName}' />">
                    </div>
                    <div class="form-group">
                        <label for="lastName">Last Name:</label>
                        <input type="text" class="form-control" id="lastName" name="lastName" placeholder="Enter Last Name" value="<c:out value='${client.lastName}' />">
                    </div>
                    <div class="form-group">
                        <label for="streetNumber">Street Number:</label>
                        <input type="text" class="form-control" id="streetNumber" name="streetNumber" placeholder="Enter Street Number" value="<c:out value='${client.streetNumber}' />">
                    </div>
                    <div class="form-group">
                        <label for="streetName">Street Name:</label>
                        <input type="text" class="form-control" id="streetName" name="streetName" placeholder="Enter Street Name" value="<c:out value='${client.streetName}' />">
                    </div>
                    <div class="form-group">
                        <label for="city">City:</label>
                        <input type="text" class="form-control" id="city" name="city" placeholder="Enter City" value="<c:out value='${client.city}' />">
                    </div>
                    <div class="form-group">
                        <label for="province">Province:</label>
                        <input type="text" class="form-control" id="province" name="province" placeholder="Enter Province" value="<c:out value='${client.province}' />">
                    </div>
                    <div class="form-group">
                        <label for="postalCode">Postal Code:</label>
                        <input type="text" class="form-control" id="postalCode" name="postalCode" placeholder="Enter City" value="<c:out value='${client.postalCode}' />">
                    </div>
                    <div class="form-group">
                        <label for="telOffice">Office Phone:</label>
                        <input type="tel" class="form-control" id="telOffice" name="telOffice" placeholder="Enter Office Phone" value="<c:out value='${client.telOffice}' />">
                    </div>
                    <div class="form-group">
                        <label for="telCell">Cell Phone::</label>
                        <input type="tel" class="form-control" id="telCell" name="telCell" placeholder="Enter Cell Phone" value="<c:out value='${client.telCell}' />">
                    </div>
                    <div class="form-group">
                        <label for="email">Email:</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Enter Email" value="<c:out value='${client.email}' />">
                    </div>
                    <div class="form-group">
                        <label for="company">Company:</label>
                        <input type="text" class="form-control" id="company" name="company" placeholder="Enter Company" value="<c:out value='${client.company}' />">
                    </div>
                    <div class="form-group">
                        <label for="companyType">Company Type:</label>
                        <input type="text" class="form-control" id="companyType" name="companyType" placeholder="Enter Company Type" value="<c:out value='${client.companyType}' />">
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

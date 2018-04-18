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

        <title>Add/Update User Page</title>
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
                    <a href="newLogin" class="btn btn-info btn-lg">Add New User</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="listLogins" class="btn btn-info btn-lg">List All Users</a>
                </h2>
            </center>
            <br>
        </div>
        <div class="col-sm-4">

        </div>
        <div class="col-sm-4">
            <!--if a user is passed (as update is selected) then form action is update
            if user is null then it is insert,  also the Edit or add user is displayed-->
            <c:if test="${login != null}">
                <form action="updateLogin" method="post">
                </c:if>
                <c:if test="${login == null}">
                    <form action="insertLogin" method="post">
                    </c:if>

                    <h2>
                        <c:if test="${login != null}">
                            Edit User
                        </c:if>
                        <c:if test="${login == null}">
                            Add New User
                        </c:if>
                    </h2>
                    <br>   
                    <c:if test="${login != null}">
                        <input type="hidden" name="id" value="<c:out value='${login.id}' />" />
                    </c:if>
                    <div class="form-group">
                        <label for="userName">User Name:</label>
                        <input type="text" class="form-control" id="userName" name="userName" placeholder="Enter User Name" value="<c:out value='${login.userName}' />">
                    </div>
                    <div class="form-group">
                        <label for="password">Password:</label>
                        <input type="text" class="form-control" id="password" name="password" placeholder="Enter Password" value="<c:out value='${login.password}' />">
                    </div>
                    <div class="form-group">
                        <label for="passwordConfirm">Password confirmation:</label><span style="color:red">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;   
                        <b><c:out value="${messageConfirm}"/></b></span>
                        <input type="text" class="form-control" id="passwordConfirm" name="passwordConfirm" placeholder="Enter Password Again" value="<c:out value='${login.password}' />">
                    </div>
                    <c:if test="${login == null}">
                    
                    <div class="col-auto my-1">
                        <label class="mr-sm-2" for="agentId">Agent ID</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <select class="custom-select mr-sm-2" id="agentId" name="agentId">
                          <option selected>Choose...</option>
                          <c:forEach var="marketingAgent" items="${listMarketingAgent}">
                          <option value="<c:out value="${marketingAgent.id}" />"><c:out value="${marketingAgent.id}" /></option>
                          </c:forEach>
                          </select>
                    </div>
                    <span style="color:red"><b><c:out value="${messageAgentId}"/></b></span>
                    </c:if>
                    <br>
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

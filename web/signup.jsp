<%-- 
    Document   : login
    Created on : 17 Nov, 2024, 12:06:18 AM
    Author     : RAHUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="component/style.css">
        <%@include file="component/bootstraplink.jsp" %>
    </head>
    <body>
        <h2 class="text-center text-primary"> SignUp Page</h2>
        <div class="container mt-5" style="width: 950px">
            <form class="text-center formBoxShadow" style="padding: 10px" method="post" action="signServlet">
                <div class="row mb-3  ">
                    <label for="UserName" class="col-sm-2 col-form-label">Enter Name:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="UserName" placeholder="Enter Name here..."  name="username" required>
                    </div>
                </div>
                 <div class="row mb-3">
                    <label for="UserEmail" class="col-sm-2 col-form-label">Enter Email:</label>
                    <div class="col-sm-10">
                        <input type="email" class="form-control" id="UserEmail" placeholder="Enter email here..." name="useremail" required>
                    </div>
                </div>
                 <div class="row mb-3">
                    <label for="UserNumber" class="col-sm-2 col-form-label">Enter Phone No:</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="UserNumber" placeholder="Enter Mobile number here..." name="mobileNumber" required>
                    </div>
                </div>
                               
                    <div class="row mb-3">
                        <label for="userPass" class="col-sm-2 form-label">Enter Password:</label>
                        <div class="col-sm-10">
                        <input type="password" class="form-control" id="userPass" required placeholder="Enter Password here..." name="password">
                    </div>
                    </div>
                <div class="row mb-3">
                    <div class="col  col-md-12">
                        <button class="btn btn-primary">Register</button>
                    </div>
                </div>
            </form>
        </div>
    </body>
</html>

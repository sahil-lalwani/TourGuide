<%-- 
    Document   : AddData
    Created on : 19 Nov, 2024, 11:11:18 PM
    Author     : RAHUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="component/bootstraplink.jsp" %>
    </head>
    <body style="background-color: #808080">


        <h1 class="text-center text-danger">Add Data </h1>

        <div class="container  mt-5" >
            <form class="text-center " action="addData" enctype="multipart/form-data" method="post" >

                <div class="row mb-3">
                    <label for="adminnmae" class="col-sm-2 col-form-label">Enter Place Name:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="adminname" placeholder="Enter place name here..." required name="placename">
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="statename" class="col-sm-2 col-form-label">Enter State/UT name:</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="statename" placeholder="Enter name here..." required name="stateName">

                    </div>
                </div>

                <div class="row mb-3">
                    <label for="uploadImage" class="col-sm-2 col-form-label">Upload Image</label>
                    <div class="col-sm-10">
                        <input type="file" class="form-control" id="uploadImage" placeholder="upload image" required name="imageName">

                    </div>
                </div>

                <div class="row mb-3">
                    <label for="distance" class="col-sm-2 col-form-label">Enter distance</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="distance" placeholder="enter distance from station or airport" required name="distance">

                    </div>

                </div>
                
                <div class="row mb-3">
                    <label for="distance" class="col-sm-2 col-form-label">Enter Best Timing</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="distance" placeholder="Best time to visit " required name="timing">

                    </div>

                </div>
                
                <div class="row mb-3">
                    <label for="distance" class="col-sm-2 col-form-label">Enter description</label>
                    <div class=" col-sm-10">
                        <textarea class="form-control" placeholder="Enter description here" id="floatingTextarea2" style="height: 100px" name="description" ></textarea>
                       
                    </div>
                </div>


                <div class="row">
                    <div class="form-group text-center">
                        <button type="reset" class="btn btn-danger">Reset</button>
                        <button type="submit" class="btn btn-primary ms-2">Submit</button>
                    </div>
                </div>
            </form>


        </div>

    </body>
</html>

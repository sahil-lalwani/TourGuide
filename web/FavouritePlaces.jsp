<%-- 
    Document   : FavouritePlaces
    Created on : 23 Nov, 2024, 11:27:58 PM
    Author     : RAHUL
--%>

<%@page import="java.util.List"%>
<%@page import="tourentity.FetchFavouitePlaces"%>
<%@page import="tourentity.loginEntity"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <%@include file="component/bootstraplink.jsp" %>
         <link rel="stylesheet" href="component/style.css">
    </head>
    <body>
       
        <nav class="navbar navbar-expand-lg bg-primary  " id="colr">
            <div class="container-fluid  tWhite">
                <a class="navbar-brand ms-3" href="#" id="BRAN"> Tour Places Guide</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse d-flex justify-content-end me-4" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="index.jsp" id="Nvbar">Home</a>
                        </li>


                        <form class="d-flex" action="DisplayDet" method="post">
                            <input class="form-control me-2" type="search" placeholder="Search places by state/Ut name" aria-label="Search" name="search">
                            <button class="btn btn-danger " type="submit">Search</button>
                        </form>
                        <%
                            
                            // After the deletion logic


                            loginEntity det = (loginEntity) session.getAttribute("userDetails");

                            if (det != null) {

                                String name = det.getUsername();

                        %>
                        <li class="nav-item">

                            <a class="nav-link text-success" href="#"><%=name%></a>

                        </li>
                       
                         <li class="nav-item">

                            <a class="nav-link text-danger" href="#">Favourites Places </a>
                        </li>
                        
                        <li class="nav-item">
                            <a class="nav-link" href="logout">LogOut</a>
                        </li>

                        <%
                        } else {
                        %>
                        <li class="nav-item">

                            <a class="nav-link" href="login.jsp">Login</a>

                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="signup.jsp">SignUp</a>
                        </li>

                        <% }%>


                    </ul>
                </div>
            </div>
        </nav>
                        
                        <% 
                        
                        HttpSession ses = request.getSession();
                        String msg = (String) ses.getAttribute("msg");
                        if(msg!=null){
                            
                        
                        
                        %>
                        <!--<h2 class="text-center text-danger">Please Add Favourites Place</h2>-->
                        
                        <% 
                        }
ses.removeAttribute("msg");
                        %>
                              <div class="section-card">
       
            <div class="d-flex  justify-content-center flex-wrap " style="gap: 2rem;">

<%
  HttpSession sess = request.getSession();
   List<FetchFavouitePlaces> place =  (  List<FetchFavouitePlaces>)   sess.getAttribute("fetchdata");
   if (place == null || place.isEmpty()) {
%>
<h1>Please add collection</h1>
<% }
else{
   for(FetchFavouitePlaces pl:place){
       
   
   
  

%>
               
               
               
                
               
                <div class="card" style="width: 30rem;">
                  <img src="image/<%=pl.getImages() %>" class="card-img-top" alt="...">
                    <div class="card-body bg-dark text-white">
                        <div class="card-title">
                            <h1><%=pl.getPlaceName() %></h1> 
                        </div>
                        <div class="card-text">
                            <h2>State/Ut Name: <%=pl.getPlaceState() %></h2>
                            <p>
                                <strong>Distance is</strong> <%=pl.getDistance()  %>
                            </p>
                        </div>
                            <form action="deletePlacesCollection" method="post">
                                <input type="hidden" value="<%=pl.getPlaceid()  %>" name="id">
                                <input type="hidden" value="<%=pl.getEmailid()  %>" name="email" >
                            
                        <div class="text-center">
                            <button class="btn btn-primary">Delete from Collection</button>
                           
                        </div>
                                
                                 </form>

                    </div>
                </div>
                           
                            
                            <% }
}
                            
                           
                            %>
            </div>
        </div>

    </body>
</html>


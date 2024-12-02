<%-- 
    Document   : SearchResult
    Created on : 20 Nov, 2024, 11:57:14 PM
    Author     : RAHUL
--%>

<%@page import="tourentity.loginEntity"%>
<%@page import="java.util.List"%>
<%@page import="tourentity.tourPlacesDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="component/bootstraplink.jsp" %>
    </head>
    <body>

        
      



        <nav class="navbar navbar-expand-lg bg-primary  " id="colr">
            <div class="container-fluid  tWhite">
                <a class="navbar-brand ms-3" href="#" id="BRAN"> Tour Places Guide</a>
                <ul class="navbar-nav">
                   <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="./index.jsp" id="Nvbar">Home</a>
                        </li>
 
                </ul>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                        aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse d-flex justify-content-end me-4" id="navbarNav">
                    <ul class="navbar-nav">
                        


                        <form class="d-flex" action="DisplayDet" method="post">
                            <input class="form-control me-2" type="search" placeholder="Search places by state/Ut name" aria-label="Search" name="search">
                            <button class="btn btn-danger " type="submit">Search</button>
                        </form>
                        <%
                            loginEntity det = (loginEntity) session.getAttribute("userDetails");

                            if (det != null) {

                                String name = det.getUsername();

                        %>
                        <li class="nav-item">

                            <a class="nav-link text-success" href="#"><%=name%></a>

                        </li>
                        <li class="nav-item">

                            <a class="nav-link text-danger" href="AddData.jsp">Add Data</a>
                        </li>
                        <form action="FavouritePlaceFetch" method="post">
                            

                         <li class="nav-item">

                             <button class="btn btn-danger">Favourites Places</button>
                        </li>
                                                </form>
                        
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

        <div class="container">
            <div class="text-center text-success">
                <h2>Tourists Places </h2>
            </div>
            <%   HttpSession session2 = request.getSession();
                String msg = (String) session2.getAttribute("msg");
                if (msg != null) {                    
                    
            %>
            <div class="alert alert-warning alert-dismissible fade show" role="alert">
                <strong> <%=msg%>  </strong>
                <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            </div>




            <%
                }
                session2.removeAttribute("msg");
                
                List<tourPlacesDetails> details = (List<tourPlacesDetails>) session.getAttribute("searchresult");
                
                for (tourPlacesDetails dets : details) {
                    String placeid = dets.getPlaceID();
                    System.out.println("" + placeid);
            %>

            <div class=" flex-wrap  mt-5" style="gap:2rem;">
                <div class="card" style="width:600px;">
                    <img src="image/<%=dets.getImages()%>" class="card-img-top" alt="...">
                    <div class="card-body">
                        <h2 class="card-title"><strong>Place Name: </strong><%=dets.getPname()%></h2>
                        <h4 class="card-text"><strong>State/UT Name:</strong><%=dets.getStatename()%></h4>
                        <h4 class="card-text"><strong>Distance</strong><%=dets.getDistance()%></h4>

                        <h4 class="card-text"><strong>Best timing to visit:</strong><%=dets.getTiming()%></h4>
                        <h4 class="card-text"><strong>Some Details About that places:</strong><%=dets.getDescription()%></h4>



                        <div class="text-center">
                            <form action="favouriteplaces">
                                <%
                                    
                                    request.getSession().setAttribute("placeID", placeid);
                                %>
                                <button class="btn btn-primary">
                                    save as favorite place
                                </button>
                            </form>
                        </div>
                    </div>
                </div>

                <% }
                %>



            </div>
    </body>
</html>

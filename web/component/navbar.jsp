
        <%@page import="tourentity.loginEntity"%>
<%
            String msg = (String) session.getAttribute("msg");

            if (msg != null) {


        %>
        <div class="alert alert-warning alert-dismissible fade show" role="alert">
            <strong> <%=msg%>  </strong>
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>

        <%

            }
            session.removeAttribute("msg");
        %>
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
                            <a class="nav-link active" aria-current="page" href="#" id="Nvbar">Home</a>
                        </li>


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
                         <li class="nav-item">

                            <a class="nav-link text-danger" href="FavouritePlaces.jsp">Favourites Places </a>
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

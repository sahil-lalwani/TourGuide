<%@page import="tourentity.loginEntity"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Document</title>
        <link rel="stylesheet" href="component/style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

    </head>

    <body>

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
                        <% 
                        String messages = (String) session.getAttribute("admin");
                        if(messages!=null){
                        %>
                        <li class="nav-item">

                            <a class="nav-link text-danger" href="AddData.jsp">Add Data</a>
                        </li>
                        
                        <% }
                        session.removeAttribute("admin");
                        %>
                        
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



        <div class="container-images">


            <img
                src="https://images.pexels.com/photos/994605/pexels-photo-994605.jpeg?cs=srgb&dl=pexels-fabianwiktor-994605.jpg&fm=jpg"
                alt="">
            <div class="advent">
                <h1>
                    Adventure
                </h1>
                <p>Is part of life so enjoy life with going different places in the world </p>

            </div>
        </div>



        <!-- <div class="box">
          <img src="https://images.pexels.com/photos/56866/garden-rose-red-pink-56866.jpeg" alt="">
          <div class="content">
            <h3>Flower Rose</h3>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Repellat amet voluptates illum, blanditiis nemo
              tenetur culpa dignissimos impedit doloremque vel?</p>
          </div>
        </div> -->

        <div class="section-card">
            <div class="heading">


                <h3>Tavel place in India</h3>
            </div>
            <h2 class="text-center text-danger">Jammu and Kashmir</h2>
            <div class="d-flex  justify-content-center flex-wrap " style="gap: 2rem;">


                <div class="card" style="width: 28rem;">
                    <img src="https://media.cnn.com/api/v1/images/stellar/prod/240112092135-02-gulmarg-snow.jpg?c=original" alt=""
                         class="card-img-top">
                    <div class="card-body bg-dark text-white">
                        <div class="card-title">
                            <h1>Gulmarg</h1> 
                        </div>
                        <div class="card-text">
                            <p>Gulmarg, known as Gulmarag in Kashmiri, is a town, hill station, tourist destination, skiing destination,
                                and a notified area committee in north Kashmir?sBaramulla district in the Indian union territory of Jammu
                                and Kashmir.</p>
                        </div>
                        <div class="text-center">
                            <a href="#" class="btn btn-primary">Add to Collection</a>
                            <a href="#">

                            </a>
                        </div>

                    </div>

                </div>
                <div class="card" style="width: 28rem;">
                    <img src="https://media.cnn.com/api/v1/images/stellar/prod/240112092135-02-gulmarg-snow.jpg?c=original" alt=""
                         class="card-img-top">
                    <div class="card-body bg-dark text-white">
                        <div class="card-title">
                            <h1>Gulmarg</h1> 
                        </div>
                        <div class="card-text">
                            <p>Gulmarg, known as Gulmarag in Kashmiri, is a town, hill station, tourist destination, skiing destination,
                                and a notified area committee in north Kashmir?sBaramulla district in the Indian union territory of Jammu
                                and Kashmir.</p>
                        </div>
                        <div class="text-center">
                            <a href="#" class="btn btn-primary">Add to Collection</a>
                            <a href="#">

                            </a>
                        </div>

                    </div>
                </div>
                <div class="card" style="width: 28rem;">
                    <img src="https://media.cnn.com/api/v1/images/stellar/prod/240112092135-02-gulmarg-snow.jpg?c=original" alt=""
                         class="card-img-top">
                    <div class="card-body bg-dark text-white">
                        <div class="card-title">
                            <h1>Gulmarg</h1> 
                        </div>
                        <div class="card-text">
                            <p>Gulmarg, known as Gulmarag in Kashmiri, is a town, hill station, tourist destination, skiing destination,
                                and a notified area committee in north Kashmir?sBaramulla district in the Indian union territory of Jammu
                                and Kashmir.</p>
                        </div>
                        <div class="text-center">
                            <a href="#" class="btn btn-primary">Add to Collection</a>
                            <a href="#">

                            </a>
                        </div>

                    </div>
                </div>
                <div class="card" style="width: 28rem;">
                    <img src="https://media.cnn.com/api/v1/images/stellar/prod/240112092135-02-gulmarg-snow.jpg?c=original" alt=""
                         class="card-img-top">
                    <div class="card-body bg-dark text-white">
                        <div class="card-title">
                            <h1>Gulmarg</h1> 
                        </div>
                        <div class="card-text">
                            <p>Gulmarg, known as Gulmarag in Kashmiri, is a town, hill station, tourist destination, skiing destination,
                                and a notified area committee in north Kashmir?sBaramulla district in the Indian union territory of Jammu
                                and Kashmir.</p>
                        </div>
                        <div class="text-center">
                            <a href="#" class="btn btn-primary">Add to Collection</a>
                            <a href="#">

                            </a>
                        </div>

                    </div>
                </div>
                <div class="card" style="width: 28rem;">
                    <img src="https://media.cnn.com/api/v1/images/stellar/prod/240112092135-02-gulmarg-snow.jpg?c=original" alt=""
                         class="card-img-top">
                    <div class="card-body bg-dark text-white">
                        <div class="card-title">
                            <h1>Gulmarg</h1> 
                        </div>
                        <div class="card-text">
                            <p>Gulmarg, known as Gulmarag in Kashmiri, is a town, hill station, tourist destination, skiing destination,
                                and a notified area committee in north Kashmir?sBaramulla district in the Indian union territory of Jammu
                                and Kashmir.</p>
                        </div>
                        <div class="text-center">
                            <a href="#" class="btn btn-primary">Add to Collection</a>
                            <a href="#">

                            </a>
                        </div>

                    </div>
                </div>
                <div class="card" style="width: 28rem;">
                    <img src="https://media.cnn.com/api/v1/images/stellar/prod/240112092135-02-gulmarg-snow.jpg?c=original" alt=""
                         class="card-img-top">
                    <div class="card-body bg-dark text-white">
                        <div class="card-title">
                            <h1>Gulmarg</h1> 
                        </div>
                        <div class="card-text">
                            <p>Gulmarg, known as Gulmarag in Kashmiri, is a town, hill station, tourist destination, skiing destination,
                                and a notified area committee in north Kashmir?sBaramulla district in the Indian union territory of Jammu
                                and Kashmir.</p>
                        </div>
                        <div class="text-center">
                            <a href="#" class="btn btn-primary">Add to Collection</a>
                            <a href="#">

                            </a>
                        </div>

                    </div>
                </div>
            </div>
        </div>





        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>

    </body>

</html>
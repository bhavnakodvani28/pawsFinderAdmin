<%-- 
    Document   : dogList
    Created on : Oct 11, 2020, 11:22:19 PM
    Author     : Krina
--%>

<%@page import="pawsFinder.admin.model.Dog"%>
<%@page import="java.util.List"%>
<%@page import="pawsFinder.admin.DAO.DogDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Dogs - PawsFinder</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" type="image/png" href="assets/images/icon/favicon.ico">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/themify-icons.css">
    <link rel="stylesheet" href="assets/css/metisMenu.css">
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/css/slicknav.min.css">
    <!-- amchart css -->
    <link rel="stylesheet" href="https://www.amcharts.com/lib/3/plugins/export/export.css" type="text/css" media="all" />
    <!-- others css -->
    <link rel="stylesheet" href="assets/css/typography.css">
    <link rel="stylesheet" href="assets/css/default-css.css">
    <link rel="stylesheet" href="assets/css/styles.css">
    <link rel="stylesheet" href="assets/css/responsive.css">
    <!-- modernizr css -->
    <script src="assets/js/vendor/modernizr-2.8.3.min.js"></script>
    <script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>

<body>
    <!--[if lt IE 8]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
    <!-- preloader area start -->
    <div id="preloader">
        <div class="loader"></div>
    </div>
    <!-- preloader area end -->
    <!-- page container area start -->
    <div class="page-container">
        <!-- sidebar menu area start -->
        <div class="sidebar-menu">
            <div class="sidebar-header">
                <div class="logo">
                    <a href="adminHome.jsp"><img src="assets/images/icon/logo.png" alt="logo"></a>
                </div>
            </div>
            <div class="main-menu">
                <div class="menu-inner">
                    <nav>
                        <ul class="metismenu" id="menu">
                            <li class="active">
                                <a href="javascript:void(0)" aria-expanded="true"><i class="ti-dashboard"></i><span>dashboard</span></a>
                            </li>
                            
                            
                            <li>
                                <a href="javascript:void(0)" aria-expanded="true"><i class='fas fa-dog' style='color:white'></i><span>Manage Dog Details</span></a>
                                <ul class="collapse">
                                    <li><a href="dogForm.jsp">Add New Dog</a></li>
                                    <li><a href="dogList.jsp">View All Dogs</a></li>
                                    <!--<li><a href="updateAdoptionStatus.jsp">Update Adoption Status</a></li>-->
                                </ul>
                            </li>
                            <li>
                                <a href="javascript:void(0)" aria-expanded="true"><i class="fa fa-users" style='color:white'></i><span>Manage User Details</span></a>
                                <ul class="collapse">
                                    <li><a href="viewUsers.jsp">View All Users</a></li>
                                </ul>
                            </li>
                             <li>
                                <a href="adoptionRequests.jsp" aria-expanded="true"><i class="ti-view-list"></i><span>Adoption Requests</span></a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <!-- sidebar menu area end -->
        <!-- main content area start -->
        <div class="main-content">
            <!-- header area start -->
            <div class="header-area">
                <div class="row align-items-center">
                    <!-- nav and search button -->
                    <div class="col-md-6 col-sm-8 clearfix">
                        <div class="nav-btn pull-left">
                            <span></span>
                            <span></span>
                            <span></span>
                        </div>
                    </div>
                </div>
            </div>
            
            <!-- page title area start -->
            <div class="page-title-area">
                <div class="row align-items-center">
                    <div class="col-sm-6">
                        <div class="breadcrumbs-area clearfix">
                            <h4 class="page-title pull-left">Dashboard</h4>
                            <ul class="breadcrumbs pull-left">
                                <li><a href="adminHome.jsp">Home</a></li>
                                <li><span>Dashboard</span></li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-sm-6 clearfix">
                        <div class="user-profile pull-right">
                            <img class="avatar user-thumb" src="assets/images/author/avatar.png" alt="avatar">
                            <h4 class="user-name dropdown-toggle" data-toggle="dropdown">Krina Shah <i class="fa fa-angle-down"></i></h4>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="adminLogin.jsp">Log Out</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- page title area end -->
            <div class="main-content-inner">
                <div class="row">
                    <!-- table primary start -->
                    <div class="col-lg-12 mt-5">
                        <div class="card">
                            <div class="card-body">
                                <center><h3 class="header-title">ALL DOGS</h3></center>
                                <div class="single-table">
                                    <div class="table-responsive">
                                        <table class="table text-center">
                                            <thead class="text-uppercase bg-primary">
                                                <tr class="text-white">
                                                    <th scope="col">Name</th>
                                                    <th scope="col">Age</th>
                                                    <th scope="col">Size</th>
                                                    <th scope="col">Gender</th>
                                                    <th scope="col">Breed</th>
                                                    <th scope="col">Color</th>
                                                    <th scope="col">City</th>
                                                    <th scope="col">Description</th>
                                                    <th scope="col">Adoption Status</th>
                                                    <th scope="col">Friendly</th>
                                                    <th scope="col">Adoption Amount</th>
                                                    <th scope="col">Actions</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%
                                                    DogDAO dogDAO=new DogDAO();
                                                    List<Dog> listDog = dogDAO.viewAllDogs();
                                                    request.setAttribute("listDog", listDog);
                                                %>
                                                <c:forEach var="dog" items="${listDog}">
                                                    <tr>
							<td><c:out value="${dog.dogName}" /></td>
							<td><c:out value="${dog.dogAge}" /></td>
							<td><c:out value="${dog.dogSize}" /></td>
                                                        <td><c:out value="${dog.gender}" /></td>
                                                        <td><c:out value="${dog.breed}" /></td>
                                                        <td><c:out value="${dog.color}" /></td>
                                                        <td><c:out value="${dog.city}" /></td>
                                                        <td><c:out value="${dog.description}" /></td>
                                                        <td><c:out value="${dog.adoptionStatus}" /></td>
                                                        <td><c:out value="${dog.friendly}" /></td>
                                                        <td><c:out value="${dog.price}" /></td>
                                                        <td><a href="DogServlet?dogID=<c:out value='${dog.dogID}' />&action=edit">Edit</a>
                                                            <br/>
                                                            <a href="DogServlet?dogID=<c:out value='${dog.dogID}'/>&action=delete" onclick="return confirm('Are you sure you want to delete this dog details?')">Delete</a>
                                                            <br/>
                                                            <a href="DogServlet?dogID=<c:out value='${dog.dogID}'/>&action=status">Update Status</a>
                                                            <br/>
                                                            <a href="uploadImageForm.jsp?dogID=<c:out value='${dog.dogID}'/>">Add Image</a></td>
                                                        </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- table primary end -->
                    
                </div>
            </div>
        </div>
        <!-- main content area end -->
        <!-- footer area start-->
        <footer>
            <div class="footer-area">
                <p>© Copyright 2020. All right reserved to Group 07.</p>
            </div>
        </footer>
        <!-- footer area end-->
    </div>
    <!-- page container area end -->
    
    <!-- jquery latest version -->
    <script src="assets/js/vendor/jquery-2.2.4.min.js"></script>
    <!-- bootstrap 4 js -->
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/owl.carousel.min.js"></script>
    <script src="assets/js/metisMenu.min.js"></script>
    <script src="assets/js/jquery.slimscroll.min.js"></script>
    <script src="assets/js/jquery.slicknav.min.js"></script>

    <!-- others plugins -->
    <script src="assets/js/plugins.js"></script>
    <script src="assets/js/scripts.js"></script>
</body>

</html>
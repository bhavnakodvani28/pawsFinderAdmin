<%-- 
    Document   : dogForm
    Created on : Oct 11, 2020, 11:21:40 PM
    Author     : Krina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html class="no-js" lang="en">
    <head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Add New Dog - PawsFinder</title>
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
                                <a href="adminHome.jsp" aria-expanded="true"><i class="ti-dashboard"></i><span>dashboard</a></span></a>
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
            <!-- header area end -->
            <!-- page title area start -->
            <div class="page-title-area">
                <div class="row align-items-center">
                    <div class="col-sm-6">
                        <div class="breadcrumbs-area clearfix">
                            <h4 class="page-title pull-left">Dog Detail Insertion</h4>
                            <ul class="breadcrumbs pull-left">
                                <li><a href="adminHome.jsp">Home</a></li>
                                <li><a>Manage Dog Details</a></li>
                                <li><span>Add New Dog</span></li>
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
                    <div class="col-lg-6 col-ml-12">
                        <div class="row">
                            <!-- Textual inputs start -->
                            <div class="col-12 mt-5">
                                <div class="card">
                                    <div class="card-body">
                                        
                                        <c:if test="${dog != null}">
                                            <form action="DogServlet" method="POST">
                                                <input type="hidden" value="update" name="action">
                                        </c:if>
                                        <c:if test="${dog == null}">
                                            <form action="DogServlet" method="GET" enctype="multipart/form-data">
                                                <input type="hidden" value="insert" name="action">
                                        </c:if>

                                        <caption>
                                            <h2>
						<c:if test="${dog != null}">
                                                    <h4 class="header-title">Edit Dog Details</h4>
                                                    <p class="text-muted font-14 mb-4">You can add edit details about dog here.</p>
                                                </c:if>
						<c:if test="${dog == null}">
                                                    <h4 class="header-title">Add New Dog</h4>
                                                    <p class="text-muted font-14 mb-4">You can add new details about dog here.</p>
                                                </c:if>
                                            </h2>
                                        </caption>

                                        <c:if test="${dog != null}">
                                            <input type="hidden" name="dogID" value="<c:out value='${dog.dogID}' />" />
                                        </c:if>

                                        <div class="form-group">
                                            <label class="col-form-label">Dog Name</label>
                                            <input class="form-control" type="text" value="<c:out value='${dog.dogName}' />" name="dogName" required="required" style="text-transform:uppercase">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label class="col-form-label">Dog Age</label>
                                            <input class="form-control" type="text" value="<c:out value='${dog.dogAge}' />" name="dogAge" required="required">
                                        </div>

                                        <b class="text-muted mb-3 mt-4 d-block">Size</b>
                                            <div class="custom-control custom-radio custom-control-inline">
                                                <input type="radio" checked id="small" name="dogSize" class="custom-control-input" value="SMALL" ${dog.dogSize=='SMALL'?'checked':''} required="required">
                                                <label class="custom-control-label" for="small">Small</label>
                                            </div>
                                            <div class="custom-control custom-radio custom-control-inline">
                                                <input type="radio" id="medium" name="dogSize" class="custom-control-input" value="MEDIUM" ${dog.dogSize=='MEDIUM'?'checked':''} required="required">
                                                <label class="custom-control-label" for="medium">Medium</label>
                                            </div>
                                                
                                                <div class="custom-control custom-radio custom-control-inline">
                                                <input type="radio" id="big" name="dogSize" class="custom-control-input" value="BIG" ${dog.dogSize=='BIG'?'checked':''} required="required">
                                                <label class="custom-control-label" for="big">Big</label>
                                            </div>

                                        <b class="text-muted mb-3 mt-4 d-block">Gender</b>
                                            <div class="custom-control custom-radio custom-control-inline">
                                                <input type="radio" checked id="male" name="gender" class="custom-control-input" value="MALE" ${dog.gender=='MALE'?'checked':''} required="required">
                                                <label class="custom-control-label" for="male">Male</label>
                                            </div>
                                            <div class="custom-control custom-radio custom-control-inline">
                                                <input type="radio" id="female" name="gender" class="custom-control-input" value="FEMALE" ${dog.gender=='FEMALE'?'checked':''} required="required">
                                                <label class="custom-control-label" for="female">Female</label>
                                            </div>
                                        
                                        <div class="form-group">
                                            <label class="col-form-label">Breed</label>
                                            <input class="form-control" type="text" value="<c:out value='${dog.breed}' />" name="breed" required="required" style="text-transform:uppercase">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label class="col-form-label">Dog Color</label>
                                            <input class="form-control" type="text" value="<c:out value='${dog.color}' />" name="color" required="required" style="text-transform:uppercase">
                                        </div>
                                       
                                        <div class="form-group">
                                            <label class="col-form-label">City</label>
                                            <input class="form-control" type="text" value="<c:out value='${dog.city}' />" name="city" required="required" style="text-transform:uppercase">
                                        </div>
                                        
                                        <div class="form-group">
                                            <label class="col-form-label">Description</label>
                                            <input class="form-control" type="text" value="<c:out value='${dog.description}' />" name="description" required="required" style="text-transform:uppercase">
                                        </div>
                                        
                                        <b class="text-muted mb-3 d-block">Friendly</b>
                                            <div class="custom-control custom-radio custom-control-inline">
                                                <input type="radio" checked id="yes" name="friendly" class="custom-control-input" value="YES" ${dog.friendly=='YES'?'checked':''}>
                                                <label class="custom-control-label" for="yes">Yes</label>
                                            </div>
                                            <div class="custom-control custom-radio custom-control-inline">
                                                <input type="radio" id="no" name="friendly" class="custom-control-input" value="YES" ${dog.friendly=='NO'?'checked':''}>
                                                <label class="custom-control-label" for="no">No</label>
                                            </div>
                                        
                                        <div class="form-group">
                                            <label class="col-form-label">Adoption Amount</label>
                                            <input class="form-control" type="text" value="<c:out value='${dog.price}' />" name="price" required="required" style="text-transform:uppercase">
                                        </div>
                                        <button type="submit" class="btn btn-primary mt-4 pr-4 pl-4">Save</button>
                                    </div>
                                </div>
                            </div>
                            <!-- Textual inputs end -->
                            
                            
                        </div>
                    </div>
                    
                           
                        </div>
                    </div>
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
    
    <!-- offset area end -->
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

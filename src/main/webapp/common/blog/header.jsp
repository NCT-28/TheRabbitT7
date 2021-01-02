<%--
  Created by IntelliJ IDEA.
  User: ToanNC7
  Date: 12/29/2020
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<!--*Header*-->
<header id="inner-navigation">

    <!-- navbar start -->
    <nav class="navbar navbar-default navbar-fixed-top navbar-sticky-function navbar-arrow">

        <div class="container">

            <div class="logo pull-left">
                <h1><a href="index.html"><img src="${pageContext.request.contextPath}/template/blog/images/logo.png"></a></h1>
            </div>

            <div id="navbar" class="navbar-nav-wrapper text-center">
                <ul class="nav navbar-nav navbar-right" id="responsive-menu">
                    <li class="active"><a href="#">Home</a>
                    </li>

                    <li><a href="#">Pages <i class="fa fa-angle-down"></i></a>
                        <ul>
                            <li><a href="about-us.html">About Us</a></li>
                            <li><a href="error.html">Error Page</a></li>
                            <li><a href="#">Detail Page</a>
                                <ul>
                                    <li><a href="blog-details.html">Detail 1</a></li>
                                    <li><a href="blog-details1.html">Detail 2</a></li>
                                </ul>
                            </li>
                            <li><a href="author.html">Author Page</a></li>
                            <li><a href="#">Category</a>
                                <ul>
                                    <li><a href="category.html">Category Lists</a></li>
                                    <li><a href="category-detail.html">Category Detail</a></li>
                                </ul>
                            </li>
                            <li><a href="#">Tags</a>
                                <ul>
                                    <li><a href="tag.html">Tag Lists</a></li>
                                    <li><a href="tag-detail.html">Tag Detail</a></li>
                                </ul>
                            </li>
                            <li><a href="faq.html">Faq</a></li>
                            <li><a href="coming-soon.html">Coming Soon</a></li>
                        </ul>
                    </li>

                    <li>
                        <a href="#">Dashboard  <i class="fa fa-angle-down"></i></a>
                        <ul>
                            <li><a href="#">Dashboard</a></li>
                            <li><a href="#">Dashboard</a></li>
                            <li><a href="#">Dashboard</a></li>
                            <li><a href="#">Dashboard</a></li>
                            <li><a href="#">Dashboard</a></li>
                            <li><a href="#">Dashboard</a></li>

                        </ul>
                    </li>

                    <li><a href="shop.html">Shop <i class="fa fa-angle-down"></i></a>
                        <ul>
                            <li><a href="#">Dashboard</a></li>
                            <li><a href="#">Dashboard</a></li>
                            <li><a href="#">Dashboard</a></li>
                            <li><a href="#">Dashboard</a></li>
                            <li><a href="#">Dashboard</a></li>
                            <li><a href="#">Dashboard</a></li>

                        </ul>
                    </li>
                    <li><a href="contact-us.html">Contact Us</a></li>
                    <li><a href="#search" class="mt_search"><i class="fa fa-search"></i></a></li>
                </ul>
            </div><!--/.nav-collapse -->
        </div>

        <div id="slicknav-mobile"></div>
    </nav>
    <!-- navbar end -->
</header>
<!--* End Header*-->

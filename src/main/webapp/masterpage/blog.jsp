<%--
  Created by IntelliJ IDEA.
  User: ToanNC7
  Date: 12/29/2020
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blog NaoT 97</title>
<!-- Favicon -->
<link rel="shortcut icon" type="image/x-icon"
	href="${pageContext.request.contextPath}/template/blog/images/favicon.png">
<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath}/template/blog/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<!--Default CSS-->
<link
	href="${pageContext.request.contextPath}/template/blog/css/default.css"
	rel="stylesheet" type="text/css">
<!--Custom CSS-->
<link
	href="${pageContext.request.contextPath}/template/blog/css/style.css"
	rel="stylesheet" type="text/css">
<dec:head />
</head>
<body class="home-1">
	<!--PRELOADER-->
	<div id="preloader">
		<div id="status"></div>
	</div>
	<%@include file="/common/blog/header.jsp"%>

	<dec:body />

	<div class="mt_instagram">
		<div class="container">
			<div class="row">
				<div class="col-sm-2 col-xs-6">
					<a href="#"><img src="/template/images/insta/insta_01.jpg"
						alt="Image"></a>
				</div>
				<div class="col-sm-2 col-xs-6">
					<a href="#"><img src="images/insta/insta_02.jpg" alt="Image"></a>
				</div>
				<div class="col-sm-2 col-xs-6">
					<a href="#"><img src="images/insta/insta_03.jpg" alt="Image"></a>
				</div>
				<div class="col-sm-2 col-xs-6">
					<a href="#"><img src="images/insta/insta_04.jpg" alt="Image"></a>
				</div>
				<div class="col-sm-2 col-xs-6">
					<a href="#"><img src="images/insta/insta_05.jpg" alt="Image"></a>
				</div>
				<div class="col-sm-2 col-xs-6">
					<a href="#"><img src="images/insta/insta_06.jpg" alt="Image"></a>
				</div>
				<div class="col-sm-2 col-xs-6">
					<a href="#"><img src="images/insta/insta_07.jpg" alt="Image"></a>
				</div>
				<div class="col-sm-2 col-xs-6">
					<a href="#"><img src="images/insta/insta_08.jpg" alt="Image"></a>
				</div>
				<div class="col-sm-2 col-xs-6">
					<a href="#"><img src="images/insta/insta_09.jpg" alt="Image"></a>
				</div>
				<div class="col-sm-2 col-xs-6">
					<a href="#"><img src="images/insta/insta_10.jpg" alt="Image"></a>
				</div>
				<div class="col-sm-2 col-xs-6">
					<a href="#"><img src="images/insta/insta_11.jpg" alt="Image"></a>
				</div>
				<div class="col-sm-2 col-xs-6">
					<a href="#"><img src="images/insta/insta_12.jpg" alt="Image"></a>
				</div>
			</div>
			<div class="sectio-title">
				<h3 class="mar-0">
					<a href="#">Follow @ Instagram</a>
				</h3>
			</div>
		</div>
	</div>
	<%@include file="/common/blog/footer.jsp"%>
	<!-- back to top -->
	<a id="back-to-top" href="#" class="btn btn-primary btn-lg back-to-top"
		role="button" title="" data-placement="left"> <span
		class="fa fa-arrow-up"></span>
	</a>

	<!-- search popup -->
	<div id="search">
		<button type="button" class="close">×</button>
		<form>
			<input type="search" value="" placeholder="type keyword(s) here" />
			<button type="submit" class="btn btn-primary">Search</button>
		</form>
	</div>

	<!--*Scripts*-->
	<!-- Latest jquery -->
	<script
		src="${pageContext.request.contextPath}/template/blog/js/jquery-3.2.1.min.js"></script>
	<!-- custom nav jquery -->
	<script
		src="${pageContext.request.contextPath}/template/blog/js/custom-nav.js"></script>
	<!-- main default Jquery -->
	<script
		src="${pageContext.request.contextPath}/template/blog/js/main.js"></script>
</body>
</html>

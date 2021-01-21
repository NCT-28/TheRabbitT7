<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Post Page</title>
</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Post <small>quản lý post</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/quan-tri"><i class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="${pageContext.request.contextPath}/quan-tri">Quản lý</a></li>
			<li class="active">Post</li>
		</ol>
	</section>
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box box-default">
					<div class="box-body">
						<a  class="btn btn-primary" href="${pageContext.request.contextPath}/quan-tri/post/them-post">Thêm Post</a>

					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<section class="content-header">
		<h1>
			Post <small>${post.title }</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/quan-tri"><i
					class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="${pageContext.request.contextPath}/quan-tri">Quản
					lý</a></li>
			<li class="active">Post</li>
		</ol>
	</section>

	<section class="content">

		<!-- /.row -->
		<div class="row">
			<div class="col-xs-12">
				<div class="box">${post.content}</div>
			</div>
		</div>
	</section>

</body>
</html>
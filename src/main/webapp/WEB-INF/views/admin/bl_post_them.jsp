
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thêm bài viết</title>
</head>
<body>
	<section class="content-header">
		<h1>
			Posting <small>Thêm bài viết</small>
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
		<div class="row">

			<form:form modelAttribute="formAddPost" enctype="multipart/form-data"
				action="${pageContext.request.contextPath}/quan-tri/post/them-post/insert"
				method="POST">

				<div class="col-md-9">
					<div class="box box-info">
						<div class="box-header">
							<h3 class="box-title">Thêm nội dung</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body pad">

							<div class="form-group">
								<label>Tiêu đề</label>
								<form:input path="title" class="form-control"
									placeholder="Nhập nội dung tiêu đề" id="title" />
							</div>
							<div class="form-group">
								<label>Nội dung</label>
							</div>
							<form:textarea path="content" id="content" name="editor1"
								rows="10" cols="80" />


						</div>
					</div>
					<!-- /.box -->
				</div>
				<div class="col-md-3">

					<!-- Profile Image -->
					<div class="box box-primary">
						<div class="box-body box-profile">



							<div class="form-group">
								<label>Author</label> 
								<form:input path="author" class="form-control" name="author" readonly ="true"
									placeholder="${author}" />
							</div>
							

							<div class="form-group">
								<label>Category</label>
								
								<form:select multiple="true" path="category"
											class="form-control select2">
											<form:options items="${category}" itemLabel="name"
												itemValue="id" />
										</form:select>
								
							</div>
							<div class="form-group">
								<label>Featured Image</label>
								<form:input path="featuredImage" type="file" />
							</div>
							<button type="submit" class="btn btn-primary btn-block">Xuất bản</button>

						</div>
						<!-- /.box-body -->
					</div>
					<!-- /.box -->
				</div>
			</form:form>

		</div>
		<!-- ./row -->
	</section>

	<script
		src="${pageContext.request.contextPath}/template/admin/bower_components/ckeditor/ckeditor.js"></script>
	<script
		src="${pageContext.request.contextPath}/template/admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
	<script>
		$(function() {
			// Replace the <textarea id="editor1"> with a CKEditor
			// instance, using default configuration.
			CKEDITOR.replace('content')
			//bootstrap WYSIHTML5 - text editor
			$('.textarea').wysihtml5()
		})
	</script>
</body>
</html>

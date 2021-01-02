<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Thêm bài viết</title>
</head>
<body>
	<section class="content-header">
		<h1>
			Post <small>quản lý post</small>
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

			<div class="col-md-9">
				<div class="box box-info">
					<div class="box-header">
						<h3 class="box-title">Thêm nội dung</h3>
					</div>
					<!-- /.box-header -->
					<div class="box-body pad">
						<form>
							<div class="form-group">
								<label>Tiêu đề</label> <input class="form-control" name="name"
									placeholder="Nhập nội dung tiêu đề">
							</div>
							<div class="form-group">
								<label>Nội dung</label>
							</div>
							<textarea id="editor1" name="editor1" rows="10" cols="80">
                                            
                    		</textarea>
						</form>
					</div>
				</div>
				<!-- /.box -->
			</div>
			<div class="col-md-3">

				<!-- Profile Image -->
				<div class="box box-primary">
					<div class="box-body box-profile">

						<form>
							<button href="#" class="btn btn-primary btn-block">
								<b>Xuất bản</b>
							</button>
							<div class="form-group">
								<label>Author</label> <input class="form-control" name="name"
									placeholder="Nhập nội dung tiêu đề">
							</div>
							<div class="form-group">
								<label>Category</label> <input class="form-control" name="name"
									placeholder="Nhập nội dung tiêu đề">
							</div>
							<div class="form-group">
								<label>Featured Image</label>
							</div>
						</form>


					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
			</div>
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
			CKEDITOR.replace('editor1')
			//bootstrap WYSIHTML5 - text editor
			$('.textarea').wysihtml5()
		})
	</script>
</body>
</html>

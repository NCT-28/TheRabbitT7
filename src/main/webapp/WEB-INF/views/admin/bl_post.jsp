<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
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
			<li><a href="${pageContext.request.contextPath}/quan-tri"><i
					class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="${pageContext.request.contextPath}/quan-tri">Quản
					lý</a></li>
			<li class="active">Post</li>
		</ol>
	</section>
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box box-default">
					<div class="box-body">
						<a class="btn btn-primary"
							href="${pageContext.request.contextPath}/quan-tri/post/them-post">Thêm
							Post</a>

					</div>
				</div>
			</div>
		</div>

		<!-- /.row -->
		<div class="row">
			<div class="col-xs-12">
				<div class="box">
					<div class="box-header">
						<h3 class="box-title">
							<form
								action="${pageContext.request.contextPath}/quan-tri/category"
								method="Post">
								<input type="hidden" name="array_id" value=""> <select
									id="select-tacvu" class="form-control" disabled>
									<option value="">Tùy chọn</option>
									<option value="enable">Kích hoạt</option>
									<option value="disable">Vô hiệu</option>
									<option value="delete">Xoá</option>
								</select>
							</form>
						</h3>


						<div class="box-tools">
							<form action="${pageContext.request.contextPath}/quan-tri/post"
								method="get">
								<div class="input-group input-group-sm" style="width: 150px;">

									<input type="text" name="tu-khoa"
										class="form-control pull-right" placeholder="Nhập nội dung">

									<div class="input-group-btn">
										<button type="submit" class="btn btn-default">
											<i class="fa fa-search"></i>
										</button>
									</div>

								</div>
							</form>
						</div>
					</div>
					<!-- /.box-header -->
					<div class="box-body table-responsive no-padding">
						<table class="table table-hover">

							<tr>
								<th>
									<button type="button" class="btn btn-primary" id="select_all">All</button>
									<button type="button" class="btn btn-info"
										id="disable_select_all" style="display: none;">Hủy</button>
								</th>
								<th>STT</th>
								<th>Tên Thể Loại</th>
								<th>URL</th>
								<th>Số lượng bài viết</th>
								<th>Trạng Thái</th>
								<th></th>
							</tr>
							<c:set var="cate" value="${postMess}" />
							<c:forEach items="${cate.values}" var="us" varStatus="status">
								<tr>
									<td style="width: 5%; text-align: center;"><input
										class="checkbox all" type="checkbox" name="check[]"
										id="${us.id }"></td>
									<td>${status.index + 1}</td>
									<td>${us.title}</td>
									<td>/${us.url}</td>
									<td>
										<%-- <c:forEach
												items="${slTruyen}" var="sl">
												<c:if test="${sl.key==us.id }">
													${sl.value }
												</c:if>
											</c:forEach> --%>
									</td>
									<td><c:if test="${us.locked == true}">
											<span class="label label-warning">Disable</span>
										</c:if> <c:if test="${us.locked == false}">
											<span class="label label-success">Enable</span>
										</c:if></td>
									<td style="width: 15%; padding-top: 1%;"><a
										class="btn btn-primary btn-sm" title="Tất cả Truyện"
										href="${pageContext.request.contextPath}/quan-tri/abcd?id=${us.id}">
											<i class="fa fa-list-ul"></i>
									</a> <a data-toggle="modal" data-target="#formSuaTheLoai"
										class="btn btn-success btn-sm cap-nhat-the-loai"
										title="Chỉnh sửa thể loại" id="${us.id }"> <i
											class="fa  fa-edit"></i>
									</a> <a class="btn btn-danger btn-sm xoa-the-loai"
										title="Xóa thể loại" id="${us.id }" data-toggle="modal"
										data-target="#formXoaTheLoai"> <i class="fa fa-close"></i>
									</a></td>
								</tr>
							</c:forEach>
						</table>
						<div class="grid_3 grid_5 agileits">
							<c:if test="${cate.total/5 >= 1}">
								<div class="col-md-6">
									<nav>
										<ul class="pagination pagination-lg">
											<c:forEach begin="0" end="${cate.total/15}" var="index">
												<li><a href="category?pageNo=${index +1}"
													class="nav-item">${index +1}</a></li>
											</c:forEach>
										</ul>
									</nav>
								</div>
							</c:if>
						</div>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
			</div>
		</div>
	</section>
</body>
</html>
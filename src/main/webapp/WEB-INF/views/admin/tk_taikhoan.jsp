<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Quản trị - Tài Khoản</title>
<style>
.example-modal .modal {
	position: relative;
	top: auto;
	bottom: auto;
	right: auto;
	left: auto;
	display: block;
	z-index: 1;
}

.example-modal .modal {
	background: transparent !important;
}
</style>

</head>
<body>
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Tài Khoản <small>Quản lý tài khoản hệ thống</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="${pageContext.request.contextPath}/quan-tri"><i
					class="fa fa-dashboard"></i> Home</a></li>
			<li><a href="#">Quản lý</a></li>
			<li class="active">User</li>
		</ol>
	</section>
	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
				<div class="box box-default">
					<div class="box-body">
						<c:if test="${not empty sessionScope.delete}">
							<div class="alert alert-danger alert-dismissible">
								<button type="button" class="close" data-dismiss="alert"
									aria-hidden="true">&times;</button>
								<h4>
									<i class="fa fa-close"></i> Xóa thành công :
								</h4>
								${value}
							</div>
						</c:if>
						<button type="button" class="btn btn-primary" data-toggle="modal"
							data-target="#add-form">Thêm Mới</button>
					</div>

					<%
						request.getSession().removeAttribute("delete");
					%>
				</div>
			</div>
		</div>

		<div class="modal fade" id="add-form">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title">Thên tài khoản</h4>
					</div>
					<div class="modal-body">
						<h4>Nhập thông tin về tài khoản</h4>
						<div class="row">
							<div class="col-lg-12">
								<form
									action="${pageContext.request.contextPath}/quan-tri/tai-khoan/add-update"
									method="post">
									<div class="form-group">
										<label>Tên tài khoản</label> <input class="form-control"
											name="userName" placeholder="Tên tài khoản">
									</div>
									<div class="form-group">
										<label>Họ Tên</label> <input class="form-control"
											name="name" placeholder="Nhập giới thiệu về thể loại">
									</div>

									<div class="form-group">
										<label>Điện thoại</label>
										<div class="input-group">
											<div class="input-group-addon">
												<i class="fa fa-phone"></i>
											</div>
											<input type="text" class="form-control" name="phoneNumber"
												data-inputmask='"mask": "(999) 999-9999"' data-mask>
										</div>
										<!-- /.input group -->
									</div>
									<div class="form-group">
										<label>Email</label>
										<div class="input-group">
											<span class="input-group-addon"><i
												class="fa fa-envelope"></i></span> 
												<input type="email" name="email"
												class="form-control" placeholder="Email?">
										</div>
									</div>									
									<div class="form-group">
										<label>Quyền</label> <select class="form-control select2"
											multiple="multiple" data-placeholder="Select a State"
											style="width: 100%;" name = "roles">
											<option>Alabama</option>
											<option>Alaska</option>
											<option>California</option>
											<option>Delaware</option>
											<option>Tennessee</option>
											<option>Texas</option>
											<option>Washington</option>
										</select>
									</div>
									<button type="submit" class="btn btn-primary">Đồng ý</button>
								</form>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default pull-right"
							data-dismiss="modal">Close</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
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
							<form
								action="${pageContext.request.contextPath}/quan-tri/tai-khoan"
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
								<th>Tài khoản</th>
								<th>URL</th>
								<th>Trạng Thái</th>
								<th>Thao tác</th>
							</tr>
							<c:set var="models" value="${users}" />
							<c:forEach items="${models.value}" var="model" varStatus="status">
								<tr>
									<td style="width: 5%; text-align: center;"><input
										class="checkbox all" type="checkbox" name="check[]"
										id="${model.id }"></td>
									<td>${status.index + 1}</td>
									<td>${model.login}</td>
									<td>/${model.url}</td>

									<td><c:if test="${mo.locked == true}">
											<span class="label label-warning">Disable</span>
										</c:if> <c:if test="${us.locked == false}">
											<span class="label label-success">Enable</span>
										</c:if></td>
									<td style="width: 15%; padding-top: 1%;"><a
										class="btn btn-primary btn-sm" title="Tất cả Truyện"
										href="${pageContext.request.contextPath}/quan-tri/abcd?id=${model.id}">
											<i class="fa fa-list-ul"></i>
									</a> <a data-toggle="modal" data-target="#edit-form"
										class="btn btn-success btn-sm cap-nhat-the-loai"
										title="Chỉnh sửa thể loại" id="${model.id }"> <i
											class="fa  fa-edit"></i>
									</a> <a class="btn btn-danger btn-sm xoa-the-loai"
										title="Xóa thể loại" id="${model.id }" data-toggle="modal"
										data-target="#delete-form"> <i class="fa fa-close"></i>
									</a></td>
								</tr>
							</c:forEach>
						</table>
						<div class="grid_3 grid_5 agileits">
							<c:if test="${models.count/5 >= 1}">
								<div class="col-md-6">
									<nav>
										<ul class="pagination pagination-lg">
											<c:forEach begin="0" end="${models.count/15}" var="index">
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


	<!-- /.content -->

	<div class="modal fade" id="edit-form" tabindex="-1" role="dialog">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="col-lg-12">
				<div class="panel panel-success">

					<div class="panel-heading">
						<h4>Chỉnh Sửa Thông Tin Tài Khoản</h4>
					</div>
					<div class="panel-body">
						<h4>Nhập thông tin về tài khoản</h4>
						<div class="row">
							<div class="col-lg-12">
								<form
									action="${pageContext.request.contextPath}/quan-tri/category/add-update-category"
									method="post">
									<div class="form-group">
										<label>ID:</label> <input class="form-control" name="id"
											id="id" readonly>
									</div>
									<div class="form-group">
										<label>Login</label> <input class="form-control" name="name"
											id="name" placeholder="Nhập lại tên thể loại truyện">
									</div>
									<div class="form-group">
										<label>sv</label> <input class="form-control"
											name="description" id="description"
											placeholder="Nhập lại giới thiệu về thể loại truyện">
									</div>
									<div class="form-group">

										<label class="radio-inline"> <input type="radio"
											name="locked" id="trangThai1" value="true"> Enable
										</label> <label class="radio-inline"> <input type="radio"
											name="locked" id="trangThai0" value="0"> Disable
										</label>

									</div>
									<button type="submit" class="btn btn-success">Đồng ý</button>
									<button type="button" class="btn btn-warning"
										data-dismiss="modal">Hủy</button>
								</form>
							</div>
						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!-- //Modal content-->
		</div>
	</div>
	<div class="modal fade" id="delete-form" tabindex="-1" role="dialog"
		style="text-align: center;">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="col-lg-12">
				<div class="panel panel-red">

					<div class="panel-heading">
						<h3>Xóa Thể Loại Truyện</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form
									action="${pageContext.request.contextPath}/quan-tri/category/xoa-the-loai"
									method="post">
									<div class="form-group">
										<label>Bạn có chắc muốn xóa bỏ thể loại: </label>
										<h4 id="name"></h4>
									</div>
									<!-- background: transparent; -->
									<input type="text" name="name" id="name"
										style="width: 0px; height: 0px; border: none; background: transparent;" />
									<input type="text" name="id" id="id"
										style="width: 0px; height: 0px; border: none; background: transparent;" />
									<div class="form-group">
										<label>Nhấn "Đồng ý" để xác nhận xóa thể loại.<br>
											Bạn có chắc chắn đây là lựa chọn của bạn!
										</label>
									</div>
									<button type="submit" class="btn btn-danger">Đồng ý</button>
									<button type="button" class="btn btn-warning"
										data-dismiss="modal">Hủy</button>
								</form>
							</div>

						</div>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
			<!-- //Modal content-->

		</div>
	</div>

	<script type="text/javascript">
		// Chức năng chọn hết
		var array_id = new Array();
		document.getElementById("select_all").onclick = function() {
			// Lấy danh sách checkbox
			let checkboxes = document.getElementsByName('check[]');
			document.getElementById("select-tacvu").disabled = false;
			// Lặp và thiết lập checked
			for (let i = 0; i < checkboxes.length; i++) {
				checkboxes[i].checked = true;
				let id = $(checkboxes[i]).attr("id");
				array_id.push(id);
				console.log(array_id[i]);
			}
			
			document.getElementById("select_all").style.display = 'none';
			document.getElementById("disable_select_all").style.display = 'block';
			
		};

		// Chức năng bỏ chọn hết
		document.getElementById("disable_select_all").onclick = function() {
			
			// Lấy danh sách checkbox
			var checkboxes = document.getElementsByName('check[]');
			
			document.getElementById("select-tacvu").disabled = true;
			
			// Lặp và thiết lập Uncheck
			for (var i = 0; i < checkboxes.length; i++) {
				checkboxes[i].checked = false;
				let id = $(this).attr('id');
				let index = array_id.indexOf(id);
				array_id.splice(index,1);
			}
			console.log(array_id.length);
			document.getElementById("select_all").style.display = 'block';
			document.getElementById("disable_select_all").style.display = 'none';
		};
		
		$(document).ready(function() {
			$(document).on("click",'.all',function(){
				let id = $(this).attr('id');
				if($(this).is(":checked"))
					{
						array_id.push(id);
					}
				else
					{
						let index = array_id.indexOf(id);
						array_id.splice(index,1);
					}	
				document.getElementById("select-tacvu").disabled = false;
				if(array_id.length==0){
					document.getElementById("select-tacvu").disabled = true;
				}
				//console.log(array_id.length);
			});
		});
			
		$("#select-tacvu").change(()=>{
            let value = $('#select-tacvu').val();
            $.confirm({
            title: 'Thông báo!',
            content: 'Bạn chắc chắn thực hiện thao tác này?',
            buttons: {
                        confirm: {
                        text: 'Xác nhận',
                        btnClass: 'btn-blue',
                        keys: ['enter'],
                        action: function(){
                            if(value == "delete")
                            {
                                $.confirm({
                                title: 'Cảnh báo!',
                                content: 'Đây là hành động xóa dữ liệu. Dữ liệu sẽ mất vĩnh viễn. Bạn chắc chắn muốn xóa?',
                                buttons: {
                                            confirm: {
                                            text: 'Xác nhận',
                                            btnClass: 'btn-red',
                                            keys: ['enter'],
                                            action: function(){
                                                let url = $("#select-tacvu").parent().attr('action')+"/"+value;
                                                var json = JSON.stringify(array_id);
                                                $("input[name=array_id]").val(json);
                                                $("#select-tacvu").parent().attr("action",url);
                                                $("#select-tacvu").parent().submit();
                                            }
                                            },
                                            cancel: {
                                                text: 'Trở lại',
                                                keys: ['esc'],
                                                action: function(){
                                                    $("#select-tacvu").val("");
                                                }
                                            }
                                            }
                                        });
                            }
                            else
                            {
                                let url = $("#select-tacvu").parent().attr('action')+"/"+value;
                                var json = JSON.stringify(array_id);
                                $("input[name=array_id]").val(json);
                                $("#select-tacvu").parent().attr("action",url);
                                $("#select-tacvu").parent().submit();
                            }
                           
                        }
                        },
                        cancel: {
                            text: 'Trở lại',
                            keys: ['esc'],
                            action: function(){
                                $("#select-tacvu").val("");
                            }
                        }
                        }
                    });
       		 });
		
		
		//Xoa từng thể loại
		$(document).on('click','.xoa-the-loai',function() {
			let id = $(this).attr("id");
			$.ajax(
				{
					url : "${pageContext.request.contextPath}/quan-tri/category/get-category-by-id",
					type : "GET",
					dataType : "json",
					data : {id : id},
					success : function(data)
					{
						var tenTheLoai = " "+ data.name;
						$("#delete-form #name").html(tenTheLoai);
						$("#delete-form #id").val(data.id);
						$("#delete-form #name").val(data.name);
						
					},
					error : function(error)
					{
						alert(error);
					}
				});
		});
		
		
		
		$(document).ready(function() {
			$(document).on('click','.cap-nhat-the-loai',function() {
			let id = $(this).attr("id");
			$.ajax(
					{
						url : "${pageContext.request.contextPath}/quan-tri/category/get-category-by-id",
						type : "GET",
						dataType : "json",
						data : {id : id},
						success : function(data)
						{
							$("#edit-form #id").val(data.id);
							$("#edit-form #name").val(data.name);
							$("#edit-form #description").val(data.description);
										
							if (data.locked == true) {
								$("#formSuaTheLoai #trangThai1").prop("checked","true");
							} else
								$("#formSuaTheLoai #trangThai0").prop("checked","true");
						},
						error : function(error)
						{
							alert(error);
						}
					});
				});
			});
    
	</script>
	<!-- Select2 -->

</body>
</html>
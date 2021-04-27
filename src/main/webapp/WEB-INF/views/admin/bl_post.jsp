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
								<th>Title</th>
								<th>URL</th>
								
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
									<td><c:if test="${us.locked == true}">
											<span class="label label-warning">Disable</span>
										</c:if> <c:if test="${us.locked == false}">
											<span class="label label-success">Enable</span>
										</c:if></td>
									<td style="width: 15%; padding-top: 1%;">
									<a
										class="btn btn-primary btn-sm" title="Xem trước"
										href="${pageContext.request.contextPath}/quan-tri/post/view/${us.url}">
											<i class="fa fa-eye"></i>
									</a> 
									<a data-toggle="modal" data-target="#formSuaTheLoai"
										class="btn btn-success btn-sm cap-nhat-the-loai"
										title="Chỉnh sửa" id="${us.id }"> <i
											class="fa  fa-edit"></i>
									</a>
									<a class="btn btn-danger btn-sm delete-post"
										title="Xóa" id="${us.id }" data-toggle="modal"
										data-target="#deletePost"> <i class="fa fa-close"></i>
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
	
	
	<div class="modal fade" id="deletePost" tabindex="-1" role="dialog"
		style="text-align: center;">
		<div class="modal-dialog">
			<!-- Modal content-->
			<div class="col-lg-12">
				<div class="panel panel-red">

					<div class="panel-heading">
						<h3>Xóa Thể Loại</h3>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-lg-12">
								<form
									action="${pageContext.request.contextPath}/quan-tri/post/delete"
									method="post">
									<div class="form-group">
										<label>Bạn có chắc muốn xóa bỏ thể loại: </label>
										<h4 id="title"></h4>
									</div>
									<!-- background: transparent; -->
									<input type="text" name="title" id="title"
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
		$(document).on('click','.delete-post',function() {
			let id = $(this).attr("id");
			$.ajax(
				{
					url : "${pageContext.request.contextPath}/quan-tri/post/get-by-id",
					type : "GET",
					dataType : "json",
					data : {id : id},
					success : function(data)
					{
						var title = " "+ data.title;
						$("#deletePost #title").html(title);
						$("#deletePost #id").val(data.id);
						$("#deletePost #title").val(data.title);
						
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
							$("#formSuaTheLoai #id").val(data.id);
							$("#formSuaTheLoai #name").val(data.name);
							$("#formSuaTheLoai #description").val(data.description);
										
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
	
	
</body>
</html>
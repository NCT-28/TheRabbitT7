<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<!--/main-->
	<section class="main-content-w3layouts-agileits">
		<div class="container">
				<h3 class="tittle">Sign In Now</h3>
				<div class="row inner-sec">
					<div class="login p-5 bg-light mx-auto mw-100">
					<form  action="${pageContext.request.contextPath}/logins" method='POST'>
							<div class="form-group">
							  <label for="exampleInputEmail1 mb-2">Tài khoản</label>
							  <input type='text' name='username' class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="" required="">
							  <small id="emailHelp" class="form-text text-muted">Nhập tài khoản mail của bạn</small>
							</div>
							<div class="form-group">
							  <label for="exampleInputPassword1 mb-2">Password</label>
							  <input type='password' name='password' class="form-control" id="exampleInputPassword1" placeholder="" required="">
							</div>
							<div class="form-check mb-2">
							  <input type="checkbox" class="form-check-input" id="exampleCheck1">
							  <label class="form-check-label" for="exampleCheck1">Lưu thông tin</label>
							</div>
							<input name="submit" type="submit" value="Sign In" class="btn btn-primary submit mb-4" />
							<p><a href="#"> Nếu bạn chưa có tài khoản hãy rành chút thời gian để gia nhập cùng chúng tớ?</a></p>
						  </form>
		</div>
		</div>
	</div>
	</section>
</body>
</html>
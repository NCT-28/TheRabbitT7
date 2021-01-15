<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<!-- Breadcrumb -->
	<section class="breadcrumb-outer text-center bg-orange">
		<div class="container">
			<div class="breadcrumb-content">
				<h2>Login Or Register</h2>
				<nav aria-label="breadcrumb">
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Home</a></li>
						<li class="breadcrumb-item active" aria-current="page">Login
							Or Register</li>
					</ul>
				</nav>
			</div>
		</div>
	</section>
	<!-- BreadCrumb Ends -->
	<section class="login">
		<div class="container">
			<div class="row">
				<div class="col-md-6">
					<div class="login-form">
						<form action="${pageContext.request.contextPath}/logins"
							method="post">
							<div class="row">
								<div class="col-xs-12">
									<div class="form-title">
										<h2>Sign In Now</h2>
									</div>
								</div>
								<div class="form-group col-xs-12">
									<label>Tài Khoản</label> <input type='text' name='username'
										class="form-control" id="exampleInputEmail1"
										aria-describedby="emailHelp" placeholder="" required="">
									<small id="emailHelp" class="form-text text-muted">Nhập
										tài khoản của bạn</small>
								</div>
								<div class="form-group col-xs-12">
									<label>Password</label> <input type='password' name='password'
										class="form-control" id="exampleInputPassword1" placeholder=""
										required="">
								</div>
								<div class="col-xs-12">
									<div class="checkbox-outer pull-left">
										<input type="checkbox" name="vehicle2" value="Car">
										Remember Me?
									</div>
								</div>
								<div class="col-xs-12">
									<div class="comment-btn mar-bottom-20">
										<button class="btn-blog" type="submit">Đăng Nhâp</button>
									</div>
								</div>
								<div class="col-xs-12">
									<div class="login-accounts pull-right">
										<a href="forgot-password.html" class="forgotpw">Forgot
											Password?</a>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
				<div class="col-md-6">
					<div class="register-form">
						<form action="${pageContext.request.contextPath}/register"
							method="post">
							<div class="row">
								<div class="col-xs-12">
									<div class="form-title">
										<h2>Register</h2>
										<p>Nếu bạn chưa có tài khoản hãy rành chút thời gian để
											gia nhập cùng chúng tớ?</p>
									</div>
								</div>
								<div class="form-group col-xs-12">
									<label>Tài khoản:</label> <input type="text" name="userName"
										class="form-control" id="Name"
										placeholder="Nhập tên đăng ký (tên này sẽ là tên đăng nhập)"
										required="">
								</div>
								<div class="form-group col-xs-12">
									<label>Email:</label> <input type="email" name="email"
										class="form-control" id="email" placeholder="abc@xyz.com"
										required="">
								</div>
								<div class="form-group col-xs-12">
									<label>Phone Number:</label> <input type="text"
										class="form-control" name="phoneNumber" id="date1"
										placeholder="Nhập SDT của bạn ">
								</div>
								<div class="form-group col-xs-6">
									<label>Nhập Password :</label> <input type="password"
										name="passWord" class="form-control" id="date"
										placeholder="Nhập mật khuẩu" required=""">
								</div>
								<div class="form-group col-xs-6 col-left-padding">
									<label>Nhập lại Password :</label> <input type="password"
										class="form-control" id="phnumber"
										placeholder="Nhập lại mật khẩu">
								</div>
								<div class="col-xs-12">
									<div class="checkbox-outer">
										<input type="checkbox" name="vehicle2" value="Car"> I
										agree to the <a href="#">terms and conditions.</a>
									</div>
								</div>
								<div class="col-xs-12">
									<button type="submit" class="btn-blog">Đăng Ký</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>
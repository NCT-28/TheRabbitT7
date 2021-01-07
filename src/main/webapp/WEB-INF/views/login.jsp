<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<h2>Login OR Register</h2>
				<nav aria-label="breadcrumb">
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Home</a></li>				
						<li class="breadcrumb-item active" aria-current="page">Login Or Register</li>
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
						<form action="${pageContext.request.contextPath}/logins">
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
										tài khoản mail của bạn</small>
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
										<input name="submit" type="submit" value="Đăng Nhập"
											class="btn-blog" />
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
						<form>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-title">
										<h2>Register</h2>
										<p>Nếu bạn chưa có tài khoản hãy rành chút thời
								gian để gia nhập cùng chúng tớ?</p>
									</div>
								</div>
								<div class="form-group col-xs-12">
									<label>Name:</label> <input type="text" class="form-control"
										id="Name" placeholder="Enter full name">
								</div>
								<div class="form-group col-xs-12">
									<label>Email:</label> <input type="email" class="form-control"
										id="email" placeholder="abc@xyz.com">
								</div>
								<div class="form-group col-xs-12">
									<label>Phone Number:</label> <input type="text"
										class="form-control" id="date1" placeholder="Select Date">
								</div>
								<div class="form-group col-xs-6">
									<label>Select Password :</label> <input type="password"
										class="form-control" id="date" placeholder="Enter Password">
								</div>
								<div class="form-group col-xs-6 col-left-padding">
									<label>Confirm Password :</label> <input type="password"
										class="form-control" id="phnumber"
										placeholder="Re-enter Password">
								</div>
								<div class="col-xs-12">
									<div class="checkbox-outer">
										<input type="checkbox" name="vehicle2" value="Car"> I
										agree to the <a href="#">terms and conditions.</a>
									</div>
								</div>
								<div class="col-xs-12">
									<div class="comment-btn mar-top-30">
										<a href="#" class="btn-blog">Register Now</a>
									</div>
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
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
	<div class="login-box">
		<div class="login-logo">
			<a href="${pageContext.request.contextPath}/"><b>The </b>Rabbit</a>
		</div>
		<!-- /.login-logo -->


		<div class="register-box-body">
			<p class="login-box-msg">Register a new membership</p>

			<form action="${pageContext.request.contextPath}/api/public/register" method="post">
				<div class="form-group has-feedback">
					<input type="text" class="form-control"  name="username" placeholder="User Name">
					<span class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control" name="password" placeholder="Password">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" class="form-control"
						   placeholder="Retype password"> <span
						class="glyphicon glyphicon-log-in form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<input type="text" class="form-control" name="name" placeholder="Last Name">
					<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<input type="email" class="form-control" name="email" placeholder="Email">
					<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>

				<div class="form-group has-feedback">
					<input type="number" class="form-control" name="phonenumber" placeholder="Phone Number">
					<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>

				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label> <input type="checkbox"> I agree to the <a
								href="#">terms</a>
							</label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Register</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

			<div class="social-auth-links text-center">
				<p>- OR -</p>
				<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i
					class="fa fa-facebook"></i> Sign up using Facebook</a> <a href="#"
					class="btn btn-block btn-social btn-google btn-flat"><i
					class="fa fa-google-plus"></i> Sign up using Google+</a>
			</div>

			<a href="${pageContext.request.contextPath}/auth/login"
				class="text-center">Nếu bạn đã có tài khoản, quay lại đăng nhập!</a>
		</div>
	</div>

</body>
</html>
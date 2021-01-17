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
			<p class="login-box-msg">Lấy lại tài khoản.</p>

			<form action="${pageContext.request.contextPath}/" method="post">

				<div class="form-group has-feedback">
					<input type="text" class="form-control"
						placeholder="Nhập mail của tài khoản của bạn."> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>

				<div class="row">

					<!-- /.col -->
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Gửi
							yêu cầu!</button>
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
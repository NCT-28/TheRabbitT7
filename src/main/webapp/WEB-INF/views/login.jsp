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
		<div class="login-box-body">
			<p class="login-box-msg">Sign in</p>

			<form action="${pageContext.request.contextPath}/auth/logins"
				method="post">
				<div class="form-group has-feedback">
					<input type="text" name="username" class="form-control"
						placeholder="Email"> <span
						class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input type="password" name="password" class="form-control"
						placeholder="Password"> <span
						class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label> <input type="checkbox" name="remember-me"> Remember Me
							</label>
						</div>
					</div>
					<div class="col-xs-4">
						<button type="submit" class="btn btn-primary btn-block btn-flat">Sign
							In</button>
					</div>

				</div>
			</form>

			<div class="social-auth-links text-center">
				<c:if test="${param.error == 'true'}">
					<div style="color: red; margin: 10px 0px;">

						Đăng nhập không thành công, xin kiểm tran lại!!!<br />
					</div>
				</c:if>
				<p>- OR -</p>
				<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i
					class="fa fa-facebook"></i> Sign in using Facebook</a> <a href="#"
					class="btn btn-block btn-social btn-google btn-flat"><i
					class="fa fa-google-plus"></i> Sign in using Google+</a>
			</div>
			<!-- /.social-auth-links -->

			<a href="${pageContext.request.contextPath}/auth/forget">Lấy lại
				mật khẩu!</a><br> <a
				href="${pageContext.request.contextPath}/auth/register"
				class="text-center">Đăng ký tài khoản mới!</a>

		</div>
		<!-- /.login-box-body -->
	</div>
</body>
</html>
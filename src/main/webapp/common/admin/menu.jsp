<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/url.jsp"%>

<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="dist/img/user2-160x160.jpg" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p>${pageContext.request.userPrincipal.name}</p>
				<a href="#"><i class="fa fa-circle text-success"></i> Online</a>
			</div>
		</div>
		<!-- search form -->
		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control"
					placeholder="Search..."> <span class="input-group-btn">
					<button type="submit" name="search" id="search-btn"
						class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form>
		<!-- /.search form -->
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu" data-widget="tree">
			<li class="header">MAIN NAVIGATION</li>
			<li class="active"><a
				href="${pageContext.request.contextPath}/quan-tri"> <i
					class="fa fa-dashboard"></i> <span>Dashboard</span> <span
					class="pull-right-container"> </span>
			</a></li>
			<li><a href="#"> <i class="fa fa-files-o"></i> <span>Tin
						Nhắn</span> <span class="pull-right-container"> <span
						class="label label-primary pull-right">4</span>
				</span>
			</a></li>
			<li>
				<a href="${pageContext.request.contextPath}/quan-tri/category"> <i
					class="fa fa-table"></i> <span>Category</span> <span
					class="pull-right-container">
					<small
						class="label pull-right bg-blue">17</small> 
				</span>
				</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/quan-tri/post"> <i
					class="fa  fa-pencil-square-o"></i> <span>Post</span> <span
					class="pull-right-container"> 
					<small
						class="label pull-right bg-blue">90</small>
				</span>
				</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/quan-tri/tag"> <i
					class="fa fa-tags"></i> <span>Tags</span> <span
					class="pull-right-container"> 
					<small
						class="label pull-right bg-blue">7</small>
				</span>
				</a>
			</li>
			<li>
				<a href="${pageContext.request.contextPath}/quan-tri/post">
				 <i class="fa fa-pie-chart"></i> <span>Thống kê</span> <span
					class="pull-right-container"> 
					<small
						class="label pull-right bg-blue">10</small>
				</span>
				</a>
			</li>

			<li><a href="pages/calendar.html"> <i class="fa fa-calendar"></i>
					<span>Calendar</span> <span class="pull-right-container"> <small
						class="label pull-right bg-red">3</small> <small
						class="label pull-right bg-blue">17</small>
				</span>
			</a></li>
			<li><a href="pages/mailbox/mailbox.html"> <i
					class="fa fa-envelope"></i> <span>Mailbox</span> <span
					class="pull-right-container"> <small
						class="label pull-right bg-yellow">12</small> <small
						class="label pull-right bg-green">16</small> <small
						class="label pull-right bg-red">5</small>
				</span>
			</a></li>
			<li><a href="https://adminlte.io/docs"><i class="fa fa-book"></i>
					<span>Documentation</span></a></li>
			<li class="header">LABELS</li>
			<li><a><i class="fa fa-circle-o text-red"></i> <span>Quan
						trọng</span></a></li>
			<li><a><i class="fa fa-circle-o text-yellow"></i> <span>Cảnh
						báo</span></a></li>
			<li><a><i class="fa fa-circle-o text-aqua"></i> <span>Thông
						tin</span></a></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>

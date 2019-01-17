<%@page import="com.jm.pojo.Menus"%>
<%@page import="com.jm.pojo.UserCustom"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>聚美装饰管理系统</title>
 <%@include file="commoncss.jsp"%>
	

</head>
<body class="nav-md">
	<div class="container body">
		<div class="main_container">
			<div class="col-md-3 left_col">
				<div class="left_col scroll-view">
				 <div class="navbar nav_title" style="border: 0;">
	              <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>Gentelella Alela!</span></a>
	            </div>
					<div class="clearfix"></div>

					<!-- menu profile quick info -->
					<div class="profile clearfix">
						<div class="profile_pic">
							<img src="../images/img.jpg" alt="..."
								class="img-circle profile_img">
						</div>
						<div class="profile_info">
							<span>欢迎,</span>
							<h2>${sessionScope.userCustom.realname}</h2>
						</div>
					</div>
					
					<!-- /menu profile quick info -->

					<br />

					<!-- sidebar menu -->
					<div id="sidebar-menu"
						class="main_menu_side hidden-print main_menu">
						<div class="menu_section">
							<center><font color="red" size="3px">聚美装修管理系统</font></center>
							<ul class="nav side-menu">
									<li><a onclick="loadjsp('index')" href="javascript:void(0)"><i class="fa fa-home"></i>首页 </a></li>
								<c:forEach var="m" items="${sessionScope.listTreeNode}" varStatus="status">
									<li><a><i class="${m.icon}"></i> ${m.treeNodeName} 
  										<span class="fa fa-chevron-down"></span></a>
										<ul class="nav child_menu">
											<c:forEach var="m2" items="${m.menu}" varStatus="status">
												<li><a onclick="loadjsp('${m2.menuurl}')" href="javascript:void(0)">${m2.menuname}</a></li>
											</c:forEach>
										</ul>
									</li>
								</c:forEach>
							</ul>
						</div>
					</div>
					<!-- /sidebar menu -->

					<!-- /menu footer buttons -->
					<div class="sidebar-footer hidden-small">
						<a data-toggle="tooltip" data-placement="top" title="Settings">
							<span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="FullScreen">
							<span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Lock"> <span
							class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
						</a> <a data-toggle="tooltip" data-placement="top" title="Logout"
							href="login.html"> <span class="glyphicon glyphicon-off"
							aria-hidden="true"></span>
						</a>
					</div>
					<!-- /menu footer buttons -->
				</div>
			</div>

			<!-- top navigation -->
			<div class="top_nav">
				<div class="nav_menu">
					<nav>
					<div class="nav toggle">
						<a id="menu_toggle"><i class="fa fa-bars"></i></a>
					</div>

					<ul class="nav navbar-nav navbar-right">
						<li class=""><a href="javascript:;"
							class="user-profile dropdown-toggle" data-toggle="dropdown"
							aria-expanded="false"> <img src="../images/img.jpg" alt="">${sessionScope.userCustom.realname}<span class=" fa fa-angle-down"></span></a>
							<ul class="dropdown-menu dropdown-usermenu pull-right">
								<li><a href="javascript:;"> Profile</a></li>
								<li><a href="javascript:;"> <span
										class="badge bg-red pull-right">50%</span> <span>Settings</span>
								</a></li>
								<li><a href="javascript:;">Help</a></li>
								<li><a href="login.jsp"><i
										class="fa fa-sign-out pull-right"></i> Log Out</a></li>
							</ul>
						</li>


						<!--邮件消息栏  -->
						<li role="presentation" class="dropdown"><a
							href="javascript:;" class="dropdown-toggle info-number"
							data-toggle="dropdown" aria-expanded="false"> <i
								class="fa fa-envelope-o"></i> <span class="badge bg-green">6</span>
						</a>
							<ul id="menu1" class="dropdown-menu list-unstyled msg_list"
								role="menu">
								<li><a> <span class="image"><img
											src="images/img.jpg" alt="Profile Image" /></span> <span> <span>John
												Smith</span> <span class="time">3 mins ago</span>
									</span> <span class="message"> Film festivals used to be
											do-or-die moments for movie makers. They were where... </span>
								</a></li>
								
								<li>
									<div class="text-center">
										<a> <strong>See All Alerts</strong> <i
											class="fa fa-angle-right"></i>
										</a>
									</div>
								</li>
							</ul>
						</li>
					</ul>
					</nav>
				</div>
			</div>
			<!-- /top navigation -->

			<!-- page content -->
			<div class="right_col" role="main" id="right_col" >
			<%-- 	<%@include file="index.jsp"%> --%>
			<%-- 	<jsp:include page="index.jsp" flush="true"></jsp:include> --%>
				
			</div>
			<!-- /page content -->

			<!-- footer content -->
			<footer>
			<div class="pull-right">
				<center>聚美装修是一家集装修建材公司</center>
			</div>
			<div class="clearfix"></div>
			</footer>
			<!-- /footer content -->
		</div>
	</div>
	 <!-- jQuery -->
	<script src="../jsFrame/jquery/jquery-3.3.1.js"></script>
	<!-- Bootstrap -->
	<script
		src="../jsFrame/bootstrap/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<!-- Custom Theme Scripts -->
	<script src="../js/custom.js"></script>
	
	<script src="../js/common.js"></script>
	<script type="text/javascript">

	$(function(){
		loadjsp('index');
	});
	</script>
</body>
</html>
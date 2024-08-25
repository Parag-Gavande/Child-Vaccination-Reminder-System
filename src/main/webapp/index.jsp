<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.servlet.*, javax.servlet.http.*"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!----======== CSS ======== -->
<link rel="stylesheet" href="css/dashboardstyles.css">

<!----===== Iconscout CSS ===== -->
<link rel="stylesheet"
	href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<title>Vaccination Reminder</title>
</head>

<body>
	<nav>
		<div class="logo-name">
			<div class="logo-image">
				<img src="images/logo.png" alt="">
			</div>

			<span class="logo_name">Vaccine Reminder</span>

		</div>

		<div class="menu-items">
			<ul class="nav-links">
			    <li style="background: #EFE8F4;"><a href="index.jsp"> <i
						class="uil uil-home"></i> <span class="link-name">Home
							</span>
				</a></li>	
				<li><a href="child_login.jsp"> <i
						class="uil uil-signin"></i> <span class="link-name">Child
							Login</span>
				</a></li>
				<li><a href="hospitalLogin.jsp"> <i
						class="uil uil-signin"></i> <span class="link-name">Hospital
							Login</span>
				</a></li>
				<li><a href="about.jsp"> <i
						class="uil uil-info-circle"></i> <span class="link-name">About
							</span>
				</a></li>
				
			</ul>


		</div>
	</nav>

	<section class="dashboard">
		<div class="top">
			<i class="uil uil-bars sidebar-toggle"></i>

			<div style="text-align: center; width: 100%;">
				<h1 style="display: inline-block; margin: 0;">
					<i class="uil uil-clock"></i> Vaccine Reminder System
				</h1>
			</div>

			<!-- <img src="images/profile.jpg" alt=""> -->
		</div>

		<div class="dash-content">
			<!-- Include dynamic content here -->
			<img height="350vh" width="1250vh" src="images/vaccine_img4.avif"
				alt="">
			<img height="700vh" width="1250vh" src="images/vaccine_img7.jpg"
				alt="">
			<div class="overview">
				<!-- Add your overview content -->

			</div>

			<div class="activity"></div>
		</div>
	</section>

	 <script src="javascript/script.js"></script>
</body>
</html>

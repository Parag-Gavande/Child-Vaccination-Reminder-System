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

<title>About</title>
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
			    <li><a href="index.jsp"> <i
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
				<li style="background: #EFE8F4;"><a href="about.jsp"> <i
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
			<img height="350vh" width="1250vh" src="images/vaccine_img5.jpg"
				alt="">
			<div style="padding: 20px;">
				<h1>Welcome to the Child Vaccine Reminder System</h1>
            <p>
                The Child Vaccine Reminder System is designed to help parents and healthcare providers manage and keep track of children's vaccination schedules. Timely vaccinations are crucial to ensuring children's health and protection against preventable diseases. Our system provides the following features:
            </p>
            	<ul style="padding: 20px;">
                <li><strong>View Vaccines:</strong> Access the list of all available vaccines and their details.</li>
                <li><strong>Vaccine Log:</strong> Keep track of administered vaccines and monitor vaccination history.</li>
                <li><strong>Upcoming Vaccines:</strong> Receive reminders for upcoming vaccines based on the child's age and vaccination schedule.</li>
                <li><strong>Secure Access:</strong> Login securely to access personalized information and manage vaccination data.</li>
                <li><strong>Change Password:</strong> Easily update your account password to keep your data secure.</li>
            	</ul>
            <p>
                Our goal is to make vaccine management easier and more efficient, ensuring that no child misses a crucial vaccination. Thank you for using our system to protect your child’s health.
            </p>
			</div>
			<div class="overview">
				<!-- Add your overview content -->

			</div>

			<div class="activity"></div>
		</div>
	</section>

	 <script src="javascript/script.js"></script>
</body>
</html>

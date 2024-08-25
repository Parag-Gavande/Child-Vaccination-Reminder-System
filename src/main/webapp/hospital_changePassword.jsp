<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- CSS -->
<link rel="stylesheet" href="css/dashboardstyles.css">
<link rel="stylesheet" href="css/add_vaccine_styles.css">

<!-- Iconscout CSS -->
<link rel="stylesheet"
	href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<title>Change Password</title>
</head>

<body>
	<nav>
		<div class="logo-name">
			<div class="logo-image">
				<img src="images/logo.png" alt="">
			</div>
			<span class="logo_name">Vaccination Reminder</span>
		</div>

		<div class="menu-items">
			<ul class="nav-links">
				<li><h2 style="padding: 15px; color: gray;">Hospital
						Dashboard</h2></li>
				<li><a href="UpcomingVaccine"> <i
						class="uil uil-calendar-alt"></i> <span class="link-name">Upcoming
							Vaccines</span>
				</a></li>
				<li><a href="add_vaccine.jsp">
						<i class="uil uil-plus-square"></i> <span class="link-name">Add
							Vaccine</span>
				</a></li>
				<li><a href="ViewVaccines"> <i
						class="uil uil-clipboard-alt"></i> <span class="link-name">View
							Vaccines</span>
				</a></li>
				<li ><a href="add_child.jsp"> <i class="uil uil-user-plus"></i>
						<span class="link-name">Add Child</span>
				</a></li>
				<li><a href="ViewChild"> <i class="uil uil-users-alt"></i>
						<span class="link-name">View Children</span>
				</a></li>
				<li><a href="add_vaccineLog.jsp"> <i
						class="uil uil-file-plus"></i> <span class="link-name">Add
							Vaccine Log</span>
				</a></li>
				<li><a href="ViewVaccineLog"> <i class="uil uil-file-plus"></i>
						<span class="link-name"> View Vaccine Log</span>
				</a></li>
				<li style="background: #EFE8F4;"><a href="hospital_changePassword.jsp"> <i
						class="uil uil-lock-alt"></i> <span class="link-name">Change
							Password</span>
				</a></li>
				<li><a href="HospitalLogout"> <i class="uil uil-signout"></i>
						<span class="link-name">Logout</span>
				</a></li>
			</ul>
		</div>
	</nav>

	<section class="dashboard">
		<div class="top">
			<i class="uil uil-bars sidebar-toggle"></i>
			<div style="text-align: center; width: 100%;">
				<h1 style="display: inline-block; margin: 0;">
					<i class="uil uil-lock-alt"></i> Change Password
				</h1>
			</div>
			<!-- <img src="images/profile.jpg" alt=""> -->
		</div>

		<div class="dash-content">
			<section class="dash-content-container">
				<h2>Change Your Password</h2>

				<form action="HospitalPasswordChange" method="post" class="form">
					<div class="input-box">
						<label for="oldPassword">Current Password</label> <input
							type="password" id="oldPassword" name="oldPassword" required>
					</div>

					<div class="input-box">
						<label for="newPassword">New Password</label> <input
							type="password" id="newPassword" name="newPassword" required>
					</div>

					<div class="input-box">
						<label for="confirmPassword">Confirm New Password</label> <input
							type="password" id="confirmPassword" name="confirmPassword"
							required>
					</div>

					<button type="submit">Change Password</button>

					<%
					String successMessage = (String) request.getAttribute("successMessage");
					String errorMessage = (String) request.getAttribute("errorMessage");
					if (successMessage != null) {
					%>
					<div class="success-message">
						<p style="color: green;"><%=successMessage%></p>
					</div>
					<%
					}
					if (errorMessage != null) {
					%>
					<div class="error-message">
						<p style="color: red;"><%=errorMessage%></p>
					</div>
					<%
					}
					%>
				</form>
			</section>
		</div>
	</section>

	<script src="javascript/script.js"></script>
</body>
</html>

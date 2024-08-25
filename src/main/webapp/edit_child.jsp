<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.entity.Child"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/dashboardstyles.css">
<link rel="stylesheet" href="css/add_vaccine_styles.css">
<title>Edit Child</title>
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
				<li><a href="add_vaccine.jsp"> <i
						class="uil uil-plus-square"></i> <span class="link-name">Add
							Vaccine</span>
				</a></li>
				<li><a href="ViewVaccines"> <i
						class="uil uil-clipboard-alt"></i> <span class="link-name">View
							Vaccines</span>
				</a></li>
				<li><a href="add_child.jsp"> <i class="uil uil-user-plus"></i>
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
				<li><a href="upcoming_vaccines.jsp"> <i
						class="uil uil-calendar-alt"></i> <span class="link-name">Upcoming
							Vaccines</span>
				</a></li>
				<li><a href="hospital_changePassword.jsp"> <i
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

			<div>
				<h1>
					<i class="uil uil-tachometer-fast-alt"></i> Dashboard
				</h1>
			</div>

			<img src="images/profile.jpg" alt="">
		</div>

		<div class="dash-content">
			<section class="dash-content-container">
				<form action="EditChild" method="post" class="form">
					<%
					Child child = (Child) request.getAttribute("child");
					if (child != null) {
					%>
					<input type="hidden" name="id" value="<%=child.getId()%>">
					<div class="input-box">
						<label for="childName">Child Name:</label> <input type="text"
							id="childName" name="childName" value="<%=child.getChildName()%>"
							required>
					</div>
					<div class="input-box">
						<label for="parentName">Parent Name:</label> <input type="text"
							id="parentName" name="parentName"
							value="<%=child.getParentName()%>" required>
					</div>
					<div class="input-box">
						<label for="dob">Date of Birth:</label> <input type="date"
							id="dob" name="dob" value="<%=child.getDob()%>" required>
					</div>
					<div class="input-box">
						<label for="parentContact">Parent Contact:</label> <input
							type="text" id="parentContact" name="parentContact"
							value="<%=child.getParentContact()%>" required>
					</div>
					<div class="input-box">
						<label for="email">Email:</label> <input type="email" id="email"
							name="email" value="<%=child.getEmail()%>" required>
					</div>
					<div class="input-box">
						<label for="address">Address:</label> <input type="text"
							id="address" name="address" value="<%=child.getAddress()%>"
							required>
					</div>
					<button type="submit">Update Child</button>
					<%
					} else {
					%>
					<p>Child not found.</p>
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.entity.VaccineLog"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="css/dashboardstyles.css">
<link rel="stylesheet" href="css/add_vaccine_styles.css">
<title>Edit Vaccine Log</title>
</head>

<body>
	<nav>
		<div class="logo-name">
			<div class="logo-image">
				<img src="images/logo.png" alt="Logo">
			</div>
			<span class="logo_name">Vaccination Reminder</span>
		</div>

		<div class="menu-items">
			<ul class="nav-links">
				<li><a href="add_vaccine.jsp"><i
						class="uil uil-plus-square"></i><span class="link-name">Add
							Vaccine</span></a></li>
				<li><a href="view_vaccines.jsp"><i
						class="uil uil-clipboard-alt"></i><span class="link-name">View
							Vaccines</span></a></li>
				<li><a href="add_child.jsp"><i class="uil uil-user-plus"></i><span
						class="link-name">Add Child</span></a></li>
				<li><a href="view_children.jsp"><i
						class="uil uil-users-alt"></i><span class="link-name">View
							Children</span></a></li>
				<li><a href="add_vaccineLog.jsp"><i
						class="uil uil-file-plus"></i><span class="link-name">Add
							Vaccine Log</span></a></li>
				<li style="background: #EFE8F4;"><a><i
						class="uil uil-calendar-alt"></i><span class="link-name">View
							Vaccine Logs</span></a></li>
				<li><a href="upcoming_vaccines.jsp"><i
						class="uil uil-calendar-alt"></i><span class="link-name">Upcoming
							Vaccines</span></a></li>
				<li><a href="change_password.jsp"><i
						class="uil uil-lock-alt"></i><span class="link-name">Change
							Password</span></a></li>
				<li><a href="HospitalLogout"><i class="uil uil-signout"></i><span
						class="link-name">Logout</span></a></li>
			</ul>
		</div>
	</nav>

	<section class="dashboard">
		<div class="top">
			<i class="uil uil-bars sidebar-toggle"></i>
			<div>
				<h1>
					<i class="uil uil-tachometer-fast-alt"></i> Edit Vaccine Log
				</h1>
			</div>
			<img src="images/profile.jpg" alt="Profile">
		</div>

		<div class="dash-content">
			<section class="dash-content-container">
				<form action="EditVaccineLog" method="post" class="form">
					<%
					VaccineLog vaccineLog = (VaccineLog) request.getAttribute("vaccineLog");
					if (vaccineLog != null) {
					%>
					<input type="hidden" name="id" value="<%=vaccineLog.getId()%>">
					<div class="input-box">
						<label for="childId">Child ID:</label> <input type="text"
							id="childId" name="childId"
							value="<%=vaccineLog.getChild().getId()%>" required>
					</div>
					<div class="input-box">
						<label for="vaccineName">Vaccine Name:</label> <input type="text"
							id="vaccineName" name="vaccineName"
							value="<%=vaccineLog.getVaccineName()%>" required>
					</div>
					<div class="input-box">
						<label for="date">Date:</label> <input type="date" id="date"
							name="date" value="<%=vaccineLog.getDate()%>" required>
					</div>
					<div class="input-box">
						<label for="ageMonths">Age (Months):</label> <input type="number"
							id="ageMonths" name="ageMonths"
							value="<%=vaccineLog.getAgeMonths()%>" required>
					</div>
					<button type="submit">Update Vaccine Log</button>
					<%
					} else {
					%>
					<p>Vaccine Log not found.</p>
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

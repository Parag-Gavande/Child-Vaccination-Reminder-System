<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="com.entity.VaccineLog"%>
<%@ page import="com.dao.VaccineLogDAO"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet" href="css/dashboardstyles.css">
<link rel="stylesheet" href="css/table.css">

<link rel="stylesheet"
	href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<title>Upcoming Vaccines</title>
</head>

<body>
	<nav>
		<!-- Navigation Bar -->
		<div class="logo-name">
			<div class="logo-image">
				<img src="images/logo.png" alt="Logo">
			</div>
			<span class="logo_name">Vaccination Reminder</span>
		</div>

		<div class="menu-items">
			<ul class="nav-links">
				<li><h2 style="padding: 15px; color: gray;">Hospital
						Dashboard</h2></li>
				<li style="background: #EFE8F4;"><a href="UpcomingVaccine"> <i
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
					<i class="uil uil-calendar-alt"></i> Upcoming Vaccines
				</h1>
			</div>
			<div></div>
		</div>

		<div class="dash-content">
			<section class="view-vaccines-container">
				<h2>Upcoming Vaccines for Next 30 Days</h2>

				<table class="vaccines-table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Child ID</th>
							<th>Vaccine Name</th>
							<th>Date</th>
							<th>Age (Months)</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<VaccineLog> upcomingVaccines = (List<VaccineLog>) request.getAttribute("upcomingVaccines");
						if (upcomingVaccines != null) {
							for (VaccineLog log : upcomingVaccines) {
						%>
						<tr>
							<td><%=log.getId()%></td>
							<td><%=log.getChild().getId()%></td>
							<td><%=log.getVaccineName()%></td>
							<td><%=log.getDate()%></td>
							<td><%=log.getAgeMonths()%></td>
						</tr>
						<%
						}
						} else {
						%>
						<tr>
							<td colspan="5">No upcoming vaccines found</td>
						</tr>
						<%
						}
						%>
					</tbody>
				</table>
			</section>
		</div>
	</section>

	<script src="javascript/script.js"></script>
</body>
</html>

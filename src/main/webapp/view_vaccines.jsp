<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.entity.Vaccine"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!----======== CSS ======== -->
<link rel="stylesheet" href="css/dashboardstyles.css">
<link rel="stylesheet" href="css/table.css">

<!----===== Iconscout CSS ===== -->
<link rel="stylesheet"
	href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<title>View Vaccines</title>
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
				<li style="background: #EFE8F4;"><a href="ViewVaccines"> <i
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
				<li ><a href="ViewVaccineLog"> <i class="uil uil-file-plus"></i>
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
			<div style="text-align: center; width: 100%;">
				<h1 style="display: inline-block; margin: 0;">
					<i class="uil uil-tachometer-fast-alt"></i> View Vaccines
				</h1>
			</div>
			<!-- <img src="images/profile.jpg" alt=""> -->
		</div>
		<div class="dash-content">
			<!-- View Vaccines Section -->
			<section class="view-vaccines-container">
				<table class="vaccines-table">
					<tr>
						<th>Vaccine Name</th>
						<th>Details</th>
						<th>Price</th>
						<th>Months</th>
						<th>Edit</th>
						<th>Delete</th>
					</tr>
					<%
					List<Vaccine> vaccines = (List<Vaccine>) request.getAttribute("vaccines");
					if (vaccines != null && !vaccines.isEmpty()) {
						for (Vaccine vaccine : vaccines) {
					%>
					<tr>
						<td><%=vaccine.getVaccineName()%></td>
						<td><%=vaccine.getVaccineDetails()%></td>
						<td><%=vaccine.getPrice()%></td>
						<td><%=vaccine.getMonths()%></td>
						<td><a href="EditVaccine?id=<%=vaccine.getId()%>">Edit</a></td>
						<td><a href="DeleteVaccine?id=<%=vaccine.getId()%>">Delete</a></td>
					</tr>
					<%
					}
					} else {
					%>
					<tr>
						<td colspan="6">No vaccines found.</td>
					</tr>
					<%
					}
					%>


				</table>
			</section>
		</div>
	</section>

	<script src="javascript/script.js"></script>
</body>
</html>

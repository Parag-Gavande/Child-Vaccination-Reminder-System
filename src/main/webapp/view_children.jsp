<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.entity.Child"%>
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
<title>View Children</title>
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
				<li><a href="add_child.jsp"> <i class="uil uil-user-plus"></i>
						<span class="link-name">Add Child</span>
				</a></li>
				<li style="background: #EFE8F4;"><a href="ViewChild"> <i class="uil uil-users-alt"></i>
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
			<div style="text-align: center; width: 100%;">
				<h1 style="display: inline-block; margin: 0;">
					<i class="uil uil-tachometer-fast-alt"></i> View Children
				</h1>
			</div>
			<!-- <img src="images/profile.jpg" alt=""> -->
		</div>
		<div class="dash-content">
			<section class="view-vaccines-container">
				<table class="vaccines-table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Child Name</th>
							<th>Parent Name</th>
							<th>Date of Birth</th>
							<th>Parent Contact</th>
							<th>Email</th>
							<th>Address</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
					</thead>
					<tbody>
						<%
						List<Child> children = (List<Child>) request.getAttribute("children");
						if (children != null && !children.isEmpty()) {
							for (Child child : children) {
						%>
						<tr>
							<td><%=child.getId()%></td>
							<td><%=child.getChildName()%></td>
							<td><%=child.getParentName()%></td>
							<td><%=child.getDob()%></td>
							<td><%=child.getParentContact()%></td>
							<td><%=child.getEmail()%></td>
							<td><%=child.getAddress()%></td>
							<td><a href="EditChild?id=<%=child.getId() %>">Edit</a></td>
							<td><a href="DeleteChild?id=<%=child.getId() %>">Delete</a></td>
						</tr>
						<%
						}
						} else {
						%>
						<tr>
							<td colspan="7">No children found.</td>
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

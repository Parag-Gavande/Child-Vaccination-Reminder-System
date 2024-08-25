<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, javax.servlet.*, javax.servlet.http.*"%>
<%@ page import="com.entity.Vaccine"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!----======== CSS ======== -->
<link rel="stylesheet" href="css/dashboardstyles.css">
<link rel="stylesheet" href="css/add_vaccine_styles.css">
<!----===== Iconscout CSS ===== -->
<link rel="stylesheet"
	href="https://unicons.iconscout.com/release/v4.0.0/css/line.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

<title>Edit Vaccine</title>
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
				<form action="EditVaccine" method="post" class="form">
					<%
					Vaccine vaccine = (Vaccine) request.getAttribute("vaccine");
					if (vaccine != null) {
					%>
					<input type="hidden" name="id" value="<%=vaccine.getId()%>">
					<div class="input-box">
						<label for="vaccineName">Vaccine Name:</label> <input type="text"
							id="vaccineName" name="vaccineName"
							value="<%=vaccine.getVaccineName()%>" required>
					</div>
					<div class="input-box">
						<label for="vaccineDetails">Vaccine Details:</label>
						<textarea id="vaccineDetails" name="vaccineDetails" required><%=vaccine.getVaccineDetails()%></textarea>
					</div>
					<div class="input-box">
						<label for="price">Price:</label> <input type="number" id="price"
							name="price" step="0.01" value="<%=vaccine.getPrice()%>" required>
					</div>
					<div class="input-box">
						<label for="months">Months:</label> <input type="number"
							id="months" name="months" value="<%=vaccine.getMonths()%>"
							required>
					</div>

					<button type="submit">Update Vaccine</button>
					<%
					} else {
					%>
					<p>Vaccine not found. Please try again.</p>
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



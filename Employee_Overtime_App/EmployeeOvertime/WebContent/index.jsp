<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.*" %>
<%@ page import="entities.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/EmployeeOvertime/employee.css" type="text/css">
<title>Employee Overtime</title>
</head>
<body>
	<h1>Employee Overtime Application</h1>
	<% EmployeeModel em = new EmployeeModel(); %>
	<% ActivityModel am = new ActivityModel(); %>
	<% EmployeeActivityModel eam = new EmployeeActivityModel(); %>
	
	<!-- Table of Employees -->
	<br>
	<h3>List of Employees by Seniority</h3>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr id="table_g">
			<th>ID</th>
			<th>Name</th>
			<th>Hire Date</th>
			<th>Seniority</th>
			<th>Option</th>
		</tr>
		<c:forEach var="e" items="<%= em.getAllEmployees() %>">
			<tr id="table_t">
				<td>${e.employeeId}</td>
				<td>${e.employeeName}</td>
				<td>${e.employeeHireDate}</td>
				<td>${e.employeeSeniority}</td>
				<td>
				<a href="EmployeeController?action=delete&id=${e.employeeId}" onclick="return confirm('Are you sure you want to delete')">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="addEmployee.jsp">Add a new Employee</a></p>
	
	<!-- Table of Activities -->
	<br>
	<h3>List of Activities by Date</h3>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr id="table_g">
			<th>ID</th>
			<th>Name</th>
			<th>Date</th>
			<th>Option</th>
		</tr>
		<c:forEach var="a" items="<%= am.getAllActivity() %>">
			<tr id="table_t">
				<td>${a.activityId}</td>
				<td>${a.activityName}</td>
				<td>${a.activityDate}</td>
				<td>
				<a href="ActivityController?action=delete&id=${a.activityId}" onclick="return confirm('Are you sure you want to delete')">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="addActivity.jsp">Add a new Activity</a></p>
	
		<!-- Table of Employees and Activities -->
	<br>
	<h3>List of Assigned Employees by Date</h3>
	<table cellpadding="2" cellspacing="2" border="1">
		<tr id="table_g">
			<th>Employee</th>
			<th>Activity</th>
			<th>Date</th>
			<th>Option</th>
		</tr>
		<c:forEach var="ea" items="<%= eam.getAllEmployeesWithActivities() %>">
			<tr id="table_t">
				<td>${ea.employeeName}</td>
				<td>${ea.activityName}</td>
				<td>${ea.activityDate}</td>
				<td>
				<a href="ActivityActivityController?action=delete&id=${ea.employeeName}" onclick="return confirm('Are you sure you want to delete')">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<p><a href="addActivity.jsp">Add a new Activity</a></p>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="/EmployeeOvertime/employee.css" type="text/css">
<title>Insert title here</title>
</head>
<body>
	<h2>Add an Overtime or Other Activity</h2>
	
	<c:if test="${not empty errorMessage}">
    <h3 style="color: red">${errorMessage}</h3>
	</c:if>

	<form action="ActivityController" method="post">
	<table id="table_g">
		<tr>
			<td>Name</td>
			<td><input type="text" name="activityName"></td>
		</tr>
		<tr>
			<td>Date</td>
			<td><input type="text" name="activityDate"></td>
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td colspan="2" align="left"><input type="submit" value="Save"></td>
		</tr>
	</table>
	</form>

</body>
</html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="employee" class="com.cdac.met.EmployeeBean" scope="session"/>
<jsp:setProperty name="employee" property="*"/>
<c:if test="${empty employee.id}">
	<c:redirect url="customer.jsp"/>
</c:if>
<html>
	<head>
		<title>TestWebApp</title>
	</head>
	<body>
		<h1>Welcome employee ${employee.id}</h1>
		
		<form method="POST">
			<p>
				<select name="employeeid">
					<option>Employees</option>
					<option>Department</option>	
				</select>
		</form>
		
		<h3>Employees</h3>
		<table border="1">
			<tr>
				<th>Employeeid</th>
				<th>Name</th>
				<th>Salary</th>
				<th>Commission</th>
				<th>DeptNo</th>
				<th>Age</th>
			</tr>
			<c:forEach var="entry" items="${employee.getEmployee()}">
				<tr>
					<td>${entry.empId}</td>
					<td>${entry.empName}</td>
					<td>${entry.salary}</td>
					<td>${entry.commission}</td>
					<td>${entry.deptNo}</td>
					<td>${entry.age}</td>
				</tr>
			</c:forEach>
		</table>
		<p>
			<a href="customer.jsp?signout=true">Logout</a>
		</p>
	</body>
</html>


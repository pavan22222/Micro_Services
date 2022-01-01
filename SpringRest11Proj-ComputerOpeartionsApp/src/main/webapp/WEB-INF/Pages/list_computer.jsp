<%@ page isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<c:choose>
	<c:when test="${list ne null and !empty list}">
	<h1 style="color:green;text-align:center">Computer Related Operations Form</h1>
		<table border="2" align="center" bgcolor="cyan">
			<thead>
				<th>Hardware Id</th>
				<th>Comapany Name</th>
				<th>HDD</th>
				<th>SDD</th>
				<th>RAM</th>
				<th>PRICE</th>
				<th>DOM</th>
			</thead>
			<tbody>
				<c:forEach var="computer" items="${list}">

					<tr>
						<td>${computer.hardwareId}</td
						<td>${computer.company}</td>
						<td>${computer.hdd}</td>
						<td>${computer.ssd}</td>
						<td>${computer.ram}</td>
						<td>${computer.price}</td>
						<td>${computer.dom}</td>
				
					</tr>
				</c:forEach>

			</tbody>


		</table>

	</c:when>
	<c:otherwise>
		<h2 style="color: red; text-align: center">${list}</h2>
	</c:otherwise>

</c:choose>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.1 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml11.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Beneficiaries</title>
</head>
<body>
	<h1>Beneficiaries</h1>
	<table>
	<c:forEach var="benef" items="${beneficiary}">
	<tr>
		<td>${benef.beneficiaryId}</td>
		<td>${benef.name}</td>
		<td>${benef.registeredDate}</td>
		<td><a href="beneficiaries/${benef.beneficiaryId}">edit</a></td>
	</tr>
	</c:forEach>
	</table>
	
<!--  	<a href="addCar.html"> Add a Car</a> -->
</body>
</html>
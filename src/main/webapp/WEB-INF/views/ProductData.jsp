<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>Welcome to Product Data!!</h3>
<table border="1">
	<tr>
		<th>ID</th>
		<th>CODE</th>
		<th>NAME</th>
		<th>TYPE</th>
		<th>COST</th>
		<th>OPERATION</th>
	</tr>
	<c:forEach items="${list}" var="ob">
		<tr>
			<td><c:out value="${ob.prodId}"/> </td>
			<td><c:out value="${ob.prodCode}"/> </td>
			<td><c:out value="${ob.prodName}"/> </td>
			<td><c:out value="${ob.prodType}"/> </td>
			<td><c:out value="${ob.prodCost}"/> </td>
			<td>
				<a href="delete?id=${ob.prodId}">DELETE</a>
			</td>
		</tr>
	</c:forEach>
	
</table>
${message}
</body>
</html>





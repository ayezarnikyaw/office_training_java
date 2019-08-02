<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert User Info</title>
</head>
<body>
<%       String fn =""; 
		 fn =request.getParameter("txtFName");
         String ln = "";
         ln = request.getParameter("txtLName");
         String em = "";
         em = request.getParameter("txtEmail");%>
<form action="UserShow.jsp" method="get">
<table>
<tr>
<td>First Name</td>
<td><input type="text" name="txtFName" value="<%= fn %>"></td>
</tr>
<tr>
<td>Last Name</td>
<td><input type="text" name="txtLName" value="<%= ln %>"></td>
</tr>
<tr>
<td>Email</td>
<td><input type="text" name="txtEmail" value="<%= em %>"></td>
</tr>
<tr>
<td colspan="2"><center><input type="submit" value="Show"></center></td>
</tr>
</table>
</form>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Guest Book Login</title>
</head>
<body bgcolor="lightgreen">
<form method = "post" action = "guestBookView.jsp">
<p>Enter your first name, last name and email address to register in our guest book.</p>
<table>
<tr>
<td>First name</td>
<td>
<input type="text" name="first" />
</td>
</tr>
<tr>
<td>Last name</td>
<td>
<input type="text" name="last" />
</td>
</tr>
<tr>
<td>Email</td>
<td>
<input type = "text" name = "email" />
</td>
</tr>
<tr>
<td colspan = "2">
<input type = "submit" value = "Submit" />
</td>
</tr>
</table>
</form>
</body>
</html>
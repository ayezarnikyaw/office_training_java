<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html >
<html>
<head>
<title>Guest Book List</title>
</head>
<body>
<font color="red">
<%response.reset();%>
<h2> An SQL Exception occurred while interacting with the guest book database</h2>
<br/><br/>
The error message was:<br/>
The statement was aborted because it would have caused a duplicate key value
in a unique or primary key constraint defined on GUESTS(EMAIL).
<br/><br/>
Please Try again
<br/><br/>
<%=exception.toString()%>
</h2>
</font>
</body></html>
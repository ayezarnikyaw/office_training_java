<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
<html>
<head>
<title> DateTimeTest </title>
</head>
<body>
Current time: <%= new java.util.Date() %> <br/>
Random number: <%= Math.random() %><br/>
Your hostname: <%= request.getRemoteHost() %><br/>
Your parameter: <%= request.getParameter("yourParameter") %><br/>
Server: <%= application.getServerInfo() %><br/>
Session ID: <%= session.getId() %><br/>
</body>
</html>
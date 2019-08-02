<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<title>Table</title>
</head>
<body>
<TABLE border="1">
<%
int n=10;
for ( int i = 0; i < n; i++ ) {
%>
<TR>
<TD>Number</TD>
<TD><%= i+1 %></TD>
</TR>
<%
}
%>
</TABLE>
</body>
</html>
<%@ page import="java.sql.*" language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><center>
	<%@include file="menu.jsp" %><br>
<%	 
try{
	 String url = "jdbc:mysql://localhost:3306/mystudent";
	 String username = "root";
	 String password = "";
	 Connection con;
	Class.forName ("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection (url, username, password);
                String s = "select * from Guest";
                PreparedStatement smt = con.prepareStatement(s);
                ResultSet rs=smt.executeQuery();
               
              %>
<table border="1" width="50%"><caption> Student Data </caption>
    <tr><th>First Name</th><th>LastName</th><th>Email</th></tr>
    <% 
           	while(rs.next())   {
	%>
	<tr>
		<td><%=rs.getString(1)%></td>
		<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			</tr>
	<%
	}	
		rs.close();
		smt.close();
		con.close();
}catch(ClassNotFoundException e)
{ 
	e.printStackTrace();
}catch(SQLException e)
	{
	e.toString();
	}
%><center>
</body>
</html>
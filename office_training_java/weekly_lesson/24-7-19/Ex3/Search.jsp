<%@ page import="java.sql.*" %>
<html>
<body><center>
	<%@include file="menu.jsp" %><br>
<%	 String email=request.getParameter("e");
try{
	 String url = "jdbc:mysql://localhost:3306/testdb";
	 String username = "root";
	 String password = "";
	 Connection con;
	Class.forName ("com.mysql.jdbc.Driver");
	con = DriverManager.getConnection (url, username, password);
                String s = "select * from Guest where email=?";
                PreparedStatement smt = con.prepareStatement(s);
                smt.setString(1, email);
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

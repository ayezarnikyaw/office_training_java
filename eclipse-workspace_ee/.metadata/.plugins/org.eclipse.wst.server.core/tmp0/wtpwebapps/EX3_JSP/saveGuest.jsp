<%@ page import="java.sql.*" %>
<html>
	
<body><center>
<%@include file="menu.jsp" %><br>
					
<%	
try{
			
		String fname=request.getParameter("txtFName");
		String lname=request.getParameter("txtLName");
		String email=request.getParameter("txtEmail");
		 String url = "jdbc:mysql://localhost:3306/mystudent";
		 String username = "root";
		 String password = "";
		 Connection con;
		Class.forName ("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection (url, username, password);
					
	String sql="INSERT INTO guest Values(?,?,?)";
	PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1,fname);
		pstmt.setString(2,lname);
		pstmt.setString(3,email);
	int r=pstmt.executeUpdate();		
	if(r>0)
              out.println("Insert successful");
              else out.println("Insertion fail");
					
		pstmt.close();
		con.close();
	}catch(ClassNotFoundException e)
	{ 
		e.printStackTrace();
	}catch(SQLException e)
		{e.printStackTrace();

	
		}
			%>
			
		</center>	
			
	</body>
</html>

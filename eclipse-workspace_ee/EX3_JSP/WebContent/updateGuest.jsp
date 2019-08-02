<%@ page import="java.sql.*" %>
<html>
<body><center>
<%@include file="menu.jsp" %><br>
<%	
			try{
								
					String oldmail=request.getParameter("o");
					String newmail=request.getParameter("n");
					 String url = "jdbc:mysql://localhost:3306/mystudent";
					 String username = "root";
					 String password = "";
					 Connection con;
					Class.forName ("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection (url, username, password);
					String sql="update  Guest set email=? where email=?";
					PreparedStatement pstmt=con.prepareStatement(sql);
					pstmt.setString(2,oldmail);
					pstmt.setString(1,newmail);
				int r=pstmt.executeUpdate();		
					
		if(r>0)
              out.println("update successful");
              else out.println("update fail");
					
					
					
					pstmt.close();
					con.close();
			}catch(ClassNotFoundException e)
			{ 
			 e.printStackTrace();
			}catch(SQLException e)
			{
			 e.printStackTrace();
			}
			%>	
		</center>
	</body>
</html>

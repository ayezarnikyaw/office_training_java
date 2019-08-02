<%@ page import="java.sql.*" %>
<html>
<body><center>
<%@include file="menu.jsp" %><br>
				
<%
	 try {
               
			        
           String email=request.getParameter("e");
           String url = "jdbc:mysql://localhost:3306/testdb";
  		 String username = "root";
  		 String password = "";
  		 Connection con;
  		Class.forName ("com.mysql.jdbc.Driver");
  		con = DriverManager.getConnection (url, username, password);
                String s = "delete from Guest where email=?";
                PreparedStatement psmt = con.prepareStatement(s);
                psmt.setString(1, email);
               int r=psmt.executeUpdate();
               if(r>0)
              out.println("delete successful");
              else out.println("Delete fail");
		psmt.close();
		con.close();
               
            } catch (Exception e) {    e.printStackTrace();        }
           
          %>
          	<center></body></html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.sql.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<body>
<%       String fn = request.getParameter("txtFName");
                String ln = request.getParameter("txtLName");
                String em = request.getParameter("txtEmail");
                if (fn == null || ln == null || em == null
|| fn.length() == 0 || ln.length() == 0 || em.length() == 0) {
                    response.sendRedirect("UserInfo.jsp");
                }else {
if(insert(fn,ln,em)){%>
<b>Insert Successful!!!</b>
<h1>Your Information!</h1>
                        First Name:<b><%= fn%></b><br>
                        Last Name:<b><%= ln%></b><br>
                        Email: <b><%= em%></b><br><br>
                        Go back to <a href="UserInfo.jsp">UserInfo</a> page.
<%  }else{%>
<b>Something wrong in database!!!</b>
<%  }
                }
    %>
</body>
<%!
boolean insert(String fn, String ln, String em) {
	 String url = "jdbc:mysql://localhost:3306/testdb";
	 String username = "root";
	 String password = "";
	 Connection con;
	 boolean flag;
	try{
		Class.forName ("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection (url, username, password);
		  String s = "insert into Guest values(?,?,?)";
          PreparedStatement smt = con.prepareStatement(s);
          smt.setString(1, fn);
          smt.setString(2, ln);
          smt.setString(3, em);
          smt.executeUpdate();
          flag=true;
		}
		catch(Exception e)
		{
		System.out.println("connection error");
		flag=false;
		}
           return flag;
}	              
				             
    %>
</html>

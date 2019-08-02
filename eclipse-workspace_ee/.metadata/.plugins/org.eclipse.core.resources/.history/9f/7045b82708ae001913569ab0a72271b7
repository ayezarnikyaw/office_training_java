import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet
{
	Connection con;
	/* Database Begin*/
	
	 String url = "jdbc:mysql://localhost:3306/mystudent";
	 String username = "root";
	 String password = "";
	public void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException 
	{
		String name=request.getParameter("userName");
		String pass=request.getParameter("passW");		
		
		try{
			Class.forName ("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection (url, username, password);
			}
			catch(Exception e)
			{
			System.out.println("connection error");
			}
		 System.out.println("success connection for check");							
		 
		 boolean flag=false;
		 
		 String sql = "select username from mytable where username= ? and password=?";
		 
			try {
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,name);
				stmt.setString(2,pass);
				ResultSet rs = stmt.executeQuery();
				while(rs.next())
				{
					flag=true;
				}
			    rs.close();
			    if(flag==true)
			    {
			    	RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/loginSuccessful.jsp");
					rd.forward(request, response);
			    }
			    else
			    	response.sendRedirect("login.jsp");
			    con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	}
public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
		doGet(request,response);
	}
}

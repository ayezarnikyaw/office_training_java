import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class SignUpServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
		boolean isMissingValue = false;
		
		String userName =request.getParameter("username");
		if (userName.equals("") || userName.equals("Missing_user_name")) 
		{
			userName = new String("Missing_user_name");
			isMissingValue = true;
		}
		String passWord =request.getParameter("password");
		if (passWord.equals("")|| passWord.equals("Missing_password")) 
		{
			passWord = new String("Missing_password");
			isMissingValue = true;
		}
		String repassW =request.getParameter("repass");
		if (passWord.equals("")|| passWord.equals("Missing_retype_password")) 
		{
			passWord = new String("Missing_retype_password");
			isMissingValue = true;
		}
		String eMail =request.getParameter("email");
		if (passWord.equals("")|| passWord.equals("Missing_email")) 
		{
			passWord = new String("Missing_email");
			isMissingValue = true;
		}
		String add =request.getParameter("address");
		if (passWord.equals("")|| passWord.equals("Missing_address")) 
		{
			passWord = new String("Missing_address");
			isMissingValue = true;
		}	

			if (isMissingValue) {
				response.sendRedirect("signup.jsp");
			} 
			
			else if(repassW.equals(passWord))
			{
				
				Connection con ;
				 String url = "jdbc:mysql://localhost:3306/mystudent";
				 String username = "root";
				 String password = "";
				Statement stm;
				String sql=new String();
				try{
					Class.forName ("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection (url, username, password);
				stm= con.createStatement(); 
				
				sql="INSERT INTO mytable VALUES ('"+userName+"','"+passWord+"','"+eMail+"','"+add+"')";
				
				System.out.println(sql);
				
				stm.executeUpdate(sql); 
				
				System.out.println("Insertion is completed.");
				
				}catch(ClassNotFoundException ec)
				{ System.out.println(ec.getMessage());
				}
				catch(SQLException es)
				{ System.out.println(es.getMessage());
				}
				
				response.sendRedirect("login.jsp");
				
			}
			else
			{
				response.sendRedirect("login.jsp");
			} 
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
		doGet(request,response);
	}
}

package assignment_registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register  extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws ServletException,IOException{
		String name = "";
		String gender = "";
		String nrc = "";
		String father_name = "";
		String address = "";
		String phone = "";
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie: cookies) {
				if(cookie.getName().equals("name"))
					name = cookie.getValue();
				else if(cookie.getName().equals("gender"))
					gender = cookie.getValue();
				else if(cookie.getName().equals("nrc"))
					nrc = cookie.getValue();
				else if(cookie.getName().equals("father_name"))
					father_name = cookie.getValue();
				else if(cookie.getName().equals("address"))
					address = cookie.getValue();
				else if(cookie.getName().equals("phone"))
					phone = cookie.getValue();
				
					
				
			}
		}
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<Head><CENTER><TITLE>Student Registration</TITLE></CENTER></HEAD>");
		out.println("<BODY><CENTER>");
		out.println("<H2>Student Registration</H2><BR>");
		out.println("<FORM method = 'GET' ACTION=\"ResultServlet\">");
		out.println("<TABLE>" +
				"<TR>" +
				"<TD>Name : </TD> " +
				"<TD><INPUT Type=\"text\" name=\"name\" value=" + name + "> </TD>" +
				"</TR>" +
				"<TR>" +
				"<TD>Gender : </TD>" +
				"<TD><INPUT Type=\"radio\" name=\"gender\" value=\"Male\" checked>Male "
						+ "<INPUT Type=\"radio\" name=\"gender\" value=\"Female\">Female </TD>" +
				"</TR>" +
				"<TR>" +
				"<TD>NRC : </TD>" +
				"<TD> <INPUT Type=\"text\" name=\"nrc\" value=" + nrc + "> </TD>" +
				"</TR>" +
				"<TR>" +
				"<TD>Father Name : </TD>" +
				"<TD> <INPUT Type=\"text\" name=\"father_name\" value=" + father_name + "> </TD>" +
				"</TR>" +
				"<TR>" +
				"<TD>Address : </TD>" +
				"<TD> <TEXTAREA name=\"address\" value=" + address + "></TEXTAREA> </TD>" +
				"</TR>" +
				"<TR>" +
				"<TD>Phone : </TD>" +
				"<TD> <INPUT Type=\"text\" name=\"phone\" value=" + phone + "> </TD>" +
				"</TR>" +
				"</TABLE>" +
				"<BR/><INPUT Type=\"submit\" name=\"submit\" value=\"submit\" > ");
		out.println("</FORM>");
		out.println("</CENTER></BODY>");
		out.println("</HTML>");
		
		
		
	}
		
	
}

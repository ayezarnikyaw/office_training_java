import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 

public class StudentRegistration extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException
		{
			String Name       = "";  
			String NRC 		  = "";  
			String FatherName = "";  
			String Address    = "";  
			String Phone      = "";
			
			
			response.setContentType("text/html");                
			PrintWriter out = response.getWriter();                 
			out.println("<HTML>");  
			out.println("<HEAD> <CENTER> <TITLE> Student Registration </TITLE> </CENTER></HEAD>");                 
			out.println("<BODY><CENTER>"); 
			out.println("<H2> Student Registration </H2><BR/>");                 
			out.println("<FORM method='GET' ACTION=\"registrationServlet\">");
			out.println("<TABLE>" +                             
							"<TR>" +                             
								"<TD>Name : </TD> " +                              
								"<TD><INPUT Type=\"text\" name=\"Name\" value=" + Name + "> "+ "</TD>" +                             
							"</TR>" +
						    "<TR>" + 
						    	"<TD>Gender : </TD>" +
						    	"<TD><INPUT Type=\"radio\" name=\"r\" value=\"Male\" checked>Male<INPUT Type=\"radio\" name=\"r\" value=\"Female\">Female</TD>" + 
						    "</TR>" +
							"<TR>" +                               
								"<TD>NRC : </TD>" +                               
								"<TD> <INPUT Type=\"text\" name=\"NRC\" value=" + NRC + "> </TD>" +                               
							"</TR>" + 
							"<TR>" +                               
								"<TD>Father Name : </TD>" +                               
								"<TD> <INPUT Type=\"text\" name=\"FatherName\" value=" + FatherName + "> </TD>" +                               
							"</TR>" + 
							"<TR>" +                               
								"<TD>Address : </TD>" +                               
								"<TD> <textarea rows=\"3\" cols=\"15\" name=\"Address\" >"+Address+"</textarea></TD>" +                               
							"</TR>" + 
							"<TR>" +                               
								"<TD>Phone : </TD>" +                               
								"<TD> <INPUT Type=\"text\" name=\"Phone\" value=" + Phone + "> </TD>" +                               
							"</TR>" + 
						"</TABLE>" +                                
						"<BR/><INPUT Type=\"submit\" name=\"submit\" value=\"Submit\"> ");                               
			out.println("</FORM>");                                
			out.println("</CENTER></BODY>");                               
			out.println("</HTML>"); 
		}
}

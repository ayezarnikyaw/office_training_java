package ex_3_cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class RegistrationForm extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException
{
String firstName = "";
String lastName = "";
String emailAddress = "";
Cookie[] cookies = request.getCookies();
if (cookies != null)
{
for(Cookie cookie: cookies)
{
if (cookie.getName().equals("firstName"))
firstName=cookie.getValue();
else if (cookie.getName().equals("lastName"))
lastName=cookie.getValue();
else if (cookie.getName().equals("emailAddress"))
emailAddress=cookie.getValue();
}
}
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<HTML>");
out.println("<HEAD> <CENTER> <TITLE> Please Register </TITLE> </CENTER></HEAD>");
out.println("<BODY><CENTER>");
out.println("<H2> Please Register </H2><BR/>");
out.println("<FORM method='GET' ACTION=\"registrationServlet\">");
out.println("<TABLE>" +
"<TR>" +
"<TD>FirstName : </TD> " +
"<TD><INPUT Type=\"text\" name=\"firstName\" value=" + firstName + "> </TD>" +
"</TR>" +
"<TR>" +
"<TD>Last Name&nbsp : </TD>" +
"<TD><INPUT Type=\"text\" name=\"lastName\" value=" + lastName + "> </TD>" +
"</TR>" +
"<TR>" +
"<TD>Email : </TD>" +
"<TD> <INPUT Type=\"text\" name=\"emailAddress\" value=" + emailAddress + "> </TD>" +
"</TR>" +
"</TABLE>" +
"<BR/><INPUT Type=\"submit\" name=\"submit\"> ");
out.println("</FORM>");
out.println("</CENTER></BODY>");
out.println("</HTML>");
}
}

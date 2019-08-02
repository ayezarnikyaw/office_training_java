package ex_3_cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
public class RegistrationServlet extends HttpServlet {
public void doGet(HttpServletRequest request,HttpServletResponse response)throws
ServletException, IOException
{
response.setContentType("text/html");
boolean isMissingValue = false;
String firstName =request.getParameter("firstName");
if (firstName.equals("") || firstName.equals("Missing_first_name"))
{
firstName = new String("Missing_first_name");
isMissingValue = true;
}
String lastName =request.getParameter("lastName");
if (lastName.equals("")|| lastName.equals("Missing_last_name"))
{
lastName = new String("Missing_last_name");
isMissingValue = true;
}
String email = request.getParameter("emailAddress");
if (email.equals("")|| email.equals("Missing_email")) {
email = new String("Missing_email");
isMissingValue = true;
}
Cookie c1 =new Cookie("firstName",firstName);
c1.setMaxAge(60);
response.addCookie(c1);
Cookie c2 = new Cookie("lastName", lastName);
response.addCookie(c2);
c2.setMaxAge(60);
Cookie c3 = new Cookie("emailAddress",email);
response.addCookie(c3);
c3.setMaxAge(60);
String formAddress ="./register";
if (isMissingValue) {
response.sendRedirect(formAddress);
}
else
{
response.setContentType("text/html");

PrintWriter out = response.getWriter();
out.println("<HTML>");
out.println("<HEAD> <CENTER> <TITLE> thanks </TITLE> </CENTER></HEAD>");
out.println("<BODY><CENTER>");
out.println("<H2> Thanks for registration! </H2><BR/>");
out.println("<LI> First Name : " + firstName);
out.println("<LI> Last Name : " + lastName);
out.println("<LI> Email : " + email);
out.println("</CENTER> </BODY>");
out.println("</HTML>");
}
}
}

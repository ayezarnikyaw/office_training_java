package ex_1_cookie;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class RepeatVisitors extends HttpServlet
{ public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
{ boolean newUser = true;
Cookie[ ] cookies = request.getCookies();
if (cookies != null)
{
for(Cookie c: cookies)
{ if ((c.getName().equals("repeatVisitor")) &&(c.getValue().equals("yes")))
{ newUser = false; break;
}
}
}
String title=null;
if (newUser)
{ Cookie returnVisitorCookie =new Cookie("repeatVisitor", "yes");
returnVisitorCookie.setMaxAge(60*60*24*365);
response.addCookie(returnVisitorCookie);
title="Welcome New User";
}
else
{
title = "Welcome Back";
}
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<H1>" + title + "<H1>");
}
public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
{
doGet(request,response);
}
}

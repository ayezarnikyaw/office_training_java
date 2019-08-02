package ex_2_cookie;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ClientAccessCounts extends HttpServlet
{ public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
{ String countString="1";
Cookie[ ] cookies = request.getCookies();
if (cookies != null)
{ for(Cookie cookie: cookies)
{ if (cookie.getName().equals("accessCount"))
countString=cookie.getValue();
}
}
int count = 1;
try
{ count = Integer.parseInt(countString); }
catch(NumberFormatException nfe) { }
Cookie c = new Cookie("accessCount",String.valueOf(count+1));
response.addCookie(c);
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<HTML>\n");
out.println("<HEAD><TITLE> <H1>Access Count Servlet </H1> </TITLE>");
out.println("<BODY BGCOLOR=\"#FDF5E6\">\n<CENTER>\n");
out.println("<H2>This is visit number " + count + " by this browser.</H2>\n");
out.println("</BODY>\n");
out.println("</HTML>\n");
}
}

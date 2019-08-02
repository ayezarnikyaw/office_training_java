package ex1_session;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class ShowSession extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response) throws
ServletException,IOException
{
String title = "Session Tracking Example";
HttpSession session = request.getSession(true);
String heading; Integer accessCount = (Integer)session.getAttribute("accessCount");
if (accessCount == null) {
accessCount = new Integer(0);
heading = "Welcome, Newcomer"; }
else {
heading = "Welcome Back"; accessCount = new Integer(accessCount.intValue() + 1);
}
session.setAttribute("accessCount", accessCount);
response.setContentType("text/html");
PrintWriter out = response.getWriter();
out.println("<HTML>");
out.println("<HEAD> <CENTER> <TITLE>" + title + "</TITLE> </CENTER> </HTML>");
out.println("<BODY BGCOLOR=\"#FDF5E6\">\n" +
"<H1 ALIGN=\"CENTER\">" + heading + "</H1>\n" +
"<H2>Information on Your Session:</H2>\n" +
"<TABLE BORDER=1 ALIGN=\"CENTER\">\n" +
"<TR BGCOLOR=\"#FFAD00\">\n" + " <TH>Info Type<TH>Value\n" + "<TR>\n" +
" <TD>ID\n" + " <TD>" + session.getId() + "\n" + "<TR>\n" +
" <TD>Creation Time\n" +
" <TD>" + new Date(session.getCreationTime()) + "\n" +
"<TR>\n" + " <TD>Time of Last Access\n" +
" <TD>" + new Date(session.getLastAccessedTime()) + "\n" +
"<TR>\n" + " <TD>Number of Previous Accesses\n" +
" <TD>" + accessCount + "\n" +
"</TR>"+
"</TABLE>\n" +
"</BODY></HTML>");
}
}

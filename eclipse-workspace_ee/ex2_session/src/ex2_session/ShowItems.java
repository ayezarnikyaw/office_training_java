package ex2_session;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
public class ShowItems extends HttpServlet
{
public void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,
IOException
{
HttpSession session = request.getSession();
ArrayList<String>previousItems=(ArrayList<String>) session.getAttribute("previousItems");
if (previousItems == null)
{ previousItems = new ArrayList<String>(); 
session.setAttribute("previousItems", previousItems);
}
String newItem1 = request.getParameter("newItem1");
if ((newItem1 != null) && !newItem1.trim().equals(""))
previousItems.add(newItem1);
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String title = "Items Purchased";
String docType ="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
out.println(docType + "<HTML>\n" +
"<HEAD><TITLE>"
+ title +
"</TITLE></HEAD>\n" +
"<BODY BGCOLOR=\"#FDF5E6\">\n" + "<H1>" + title + "</H1>");
if (previousItems.size() == 0)
out.println("<I>No items</I>");
else {
out.println("<UL>");
for(String item : previousItems)
{
out.println(" <LI>" + item);
}
out.println("</UL>");
}
out.println("</BODY></HTML>");
}
}

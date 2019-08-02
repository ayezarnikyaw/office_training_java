package ex3_session;

import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
public class LikeDislikeServlet extends HttpServlet {
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
IOException {
response.setContentType("text/html");
response.setBufferSize(8192);
HttpSession session = request.getSession(true);
String name = request.getParameter("txtName");
String email = request.getParameter("txtEmail");
String like = request.getParameter("r1");

String reason[]=request.getParameterValues("c1");
String caption[]={"Quality","Price","Service","Usefulness","Other"};
ArrayList<Integer> count=(ArrayList<Integer>)session.getAttribute("count");
if(count==null)
{ count=new ArrayList<Integer>();
count.add(new Integer(0));
count.add(new Integer(0));
}
ArrayList<Integer> resonsCount1=(ArrayList<Integer>)session.getAttribute("resonsCount1");
if(resonsCount1==null)
{ resonsCount1=new ArrayList<Integer>();
resonsCount1.add(new Integer(0));
resonsCount1.add(new Integer(0));
resonsCount1.add(new Integer(0));
resonsCount1.add(new Integer(0));
resonsCount1.add(new Integer(0));
}
ArrayList<Integer> resonsCount2=(ArrayList<Integer>)session.getAttribute("resonsCount2");
if(resonsCount2==null)
{ resonsCount2=new ArrayList<Integer>();
resonsCount2.add(new Integer(0));
resonsCount2.add(new Integer(0));
resonsCount2.add(new Integer(0));
resonsCount2.add(new Integer(0));
resonsCount2.add(new Integer(0));
}
switch(like)
{case "like":count.set(0,(Integer)(count.get(0).intValue()+1));
for(String s:reason)
{
switch(s)
{case "quality":resonsCount1.set(0,(Integer)(resonsCount1.get(0).intValue()+1));break;
case "price":resonsCount1.set(1,(Integer)(resonsCount1.get(1).intValue()+1));break;
case "service":resonsCount1.set(2,(Integer)(resonsCount1.get(2).intValue()+1));break;
case "usefulness":resonsCount1.set(3,(Integer)(resonsCount1.get(3).intValue()+1));;break;
case "other":resonsCount1.set(4,(Integer)(resonsCount1.get(4).intValue()+1));break;
}
}break;
case "dislike":count.set(1,(Integer)(count.get(1).intValue()+1));
for(String s:reason)
{
switch(s)
{case "quality":resonsCount2.set(0,(Integer)(resonsCount2.get(0).intValue()+1));break;
case "price":resonsCount2.set(1,(Integer)(resonsCount2.get(1).intValue()+1));break;
case "service":resonsCount2.set(2,(Integer)(resonsCount2.get(2).intValue()+1));break;
case "usefulness":resonsCount2.set(3,(Integer)(resonsCount2.get(3).intValue()+1));;break;
case "other":resonsCount2.set(4,(Integer)(resonsCount2.get(4).intValue()+1));break;
}
}
break;
}
session.setAttribute("count",count);
session.setAttribute("resonsCount1",resonsCount1);
session.setAttribute("resonsCount2",resonsCount2);
PrintWriter out = response.getWriter();
out.println("<html>" + "<head><title>Student Registration</title></head>");
out.println("<body>");

out.println("<h1>Servey Result</h1>");
out.println("<h3>Like</h3>");
out.println("<b>"+count.get(0).intValue()+" customers like the products.</b>");
out.println("<table>");
out.println("<tr>");
out.println("<th>Resons</th>");
out.println("<th>No. of liked customers</th>");
out.println("</tr>");
for(int i=0;i<5;i++)
{
out.println("<tr>");
out.println("<td>"+caption[i]+"</td>");
out.println("<td>"+resonsCount1.get(i).intValue()+"</th>");
out.println("</tr>");
}
out.println("</table>");
out.println("<h3>Dislike</h3>");
out.println("<b>"+count.get(1).intValue()+" customers dislike the products.</b>");
out.println("<table>");
out.println("<tr>");
out.println("<th>Resons</th>");
out.println("<th>No. of liked customers</th>");
out.println("</tr>");
for(int i=0;i<5;i++)
{
out.println("<tr>");
out.println("<td>"+caption[i]+"</td>");
out.println("<td>"+resonsCount2.get(i).intValue()+"</th>");
out.println("</tr>");
}
out.println("</table>");
/*out.println("Name:"+name+"<br/>");
out.println("Eamil:"+email+"<br/>");
out.println("Like Or Dislike:"+like+"<br/>");
out.println("Reason:");
for(int i=0;i<reason.length;i++)
out.println(reason[i]);*/
out.println("</body>");
out.close();
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
}
}
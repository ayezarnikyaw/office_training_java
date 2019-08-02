import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

public class StudentRegistrationServlet extends HttpServlet {
	static ArrayList<Student> al;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean isMissingValue = false;
		String n = request.getParameter("Name");		
		
		String Gender = request.getParameter("r");
		
		String nr = request.getParameter("NRC");
		
		String f = request.getParameter("FatherName");
		
		String ad = request.getParameter("Address");
		
		String p = request.getParameter("Phone");
		
	    
		HttpSession session = request.getSession(true); 
		
		 al=(ArrayList<Student>)session.getAttribute("stu");
		   if(al==null) 
		   { al=new ArrayList<Student>();
		   	 al.add(new Student(nr,n,Gender,p,f,ad));   
		   
		   }   
		   else
		   {
				 al.add(new Student(nr,n,Gender,p,f,ad));  
		   }
		   session.setAttribute("stu",al);
		

		String formAddress = "./registration";
	
				

				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<HTML>");
				out.println("<HEAD> <CENTER> <TITLE> thanks </TITLE> </CENTER>");
				out.println("<style type='text/css' media='print'>");
				
					out.println("@page"+
				    "{"+
				     "size: auto; "+
				     "margin: 0mm;"+
				     "}");
	
					out.println("body"+ 
				    "{"+
				    "background-color:#FFFFFF;"+
				    "border: solid 1px black ;"+
				    "margin: 0px;"+
				     "}");		
				out.println(" </style>");
				
				out.println("<script type=\"text/javascript\">");		
				
				
				out.println("var cssPagedMedia = (function () {");
				out.println("var style = document.createElement('style')");
				out.println("document.head.appendChild(style)");
				out.println("return function (rule) {");
				out.println("style.innerHTML = rule");
				out.println("}");
				out.println("}())");

				out.println("cssPagedMedia.size = function (size) {");
				out.println("cssPagedMedia('@page {size: ' + size + '}')");
				out.println("}");
				
				out.println("function printPDF() {");
					out.println("cssPagedMedia.size('A4 Portrait')");
					out.println("var printButton = document.getElementById('btnprint2');");
					out.println("var printButton2 = document.getElementById('btnprint');");
					out.println("printButton.style.visibility = 'hidden';");
					out.println("printButton2.style.visibility = 'hidden';");
					out.println("window.print()");
					out.println("printButton.style.visibility = 'visible';");
					out.println("printButton2.style.visibility = 'visible';");
					out.println("}");
				out.println("</script>");
	        
				out.println("</HEAD>");
				out.println("<BODY><CENTER>");
				out.println("<form method='GET' ACTION=\"printExcel\">");
				out.println("<H2> Thanks for registration! </H2><BR/>");
				out.println("<TABLE>");
				out.println("<tr>");
				out.println("<th>Name");
				out.println("</th>");
				out.println("<th>Gender");
				out.println("</th>");
				out.println("<th>NRC");
				out.println("</th>");
				out.println("<th>Father's Name");
				out.println("</th>");
				out.println("<th>Address");
				out.println("</th>");
				out.println("<th>Phone");
				out.println("</th>");
				out.println("<tr>");
				out.println("</tr>");
				out.println("</tr>");
				for(int i=0;i<al.size();i++) {
					Student s=(Student)al.get(i);
					out.println(                     
						    "<TR>" + 
						    	"<TD>"+ s.getName() +"</TD>" +						                                
								"<TD>"+ s.getGender() +"</TD>" +                           
								"<TD>"+ s.getNrc() +"</TD>" +                              
								"<TD>"+ s.getFather()+"</TD>" +                               
								"<TD>"+ s.getAddr() +"</TD>" +                         
								"<TD>"+ s.getPh() +"</TD>" +                               
							"</TR>" 
						); 
				}
				out.println("</TABLE>");			
				out.println("<input type='button' name='btnprint' id='btnprint' value='printPDF' onclick='printPDF();'>");
				out.println("<input type='submit'name='btnprint2' id='btnprint2' value='printExcel' onclick='printExl();'>");
				out.println("</form>");
				out.println("</CENTER>");				
				out.println("</BODY>");
				out.println("</HTML>");				
		
	}
}

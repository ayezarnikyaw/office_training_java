package assignment_vote;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VoteResult extends HttpServlet{
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		
	boolean chkmail = false;
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	response.setBufferSize(8192);
	HttpSession session = request.getSession(true);
	String name = request.getParameter("acc_name");
	String email = request.getParameter("email");
	
	String vote = request.getParameter("singer");
	ArrayList<Integer> count=(ArrayList<Integer>)session.getAttribute("count");
	

	ArrayList<String>previousEmails=(ArrayList<String>) session.getAttribute("previousEmails");
	
	if(previousEmails != null) {
		chkmail = previousEmails.contains(email); 
	}
	if(chkmail == true) {
		out.println("This email is already vote!");	
		out.close();			
	}else {
		previousEmails = new ArrayList<String>();
		session.setAttribute("previousEmails", previousEmails);			
		
		previousEmails.add(email);

		if(count==null){ 		
			count=new ArrayList<Integer>();
			count.add(new Integer(0));
			count.add(new Integer(0));
			count.add(new Integer(0));
			count.add(new Integer(0));
			count.add(new Integer(0));
		}
		
		switch(vote){
		case "1":
			count.set(0,(Integer)(count.get(0).intValue()+1));
			break;
		case "2":
			count.set(1,(Integer)(count.get(1).intValue()+1));
			break;
		case "3":
			count.set(2,(Integer)(count.get(2).intValue()+1));
			break;
		case "4":
			count.set(3,(Integer)(count.get(3).intValue()+1));
			break;
		case "5":
			count.set(4,(Integer)(count.get(4).intValue()+1));
			break;
		}
		session.setAttribute("count",count);
	
		String title = "Myanmar Idol Volting Result";
		String docType ="<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 Transitional//EN\">\n";
		out.println(docType + "<HTML>\n" +
		"<HEAD><TITLE>"
		+ title +
		"</TITLE></HEAD>\n" +
		"<BODY BGCOLOR=\"aliceblue\">\n" + "<H1>" + title + "</H1>");
		out.println("<table>");
		out.println("<tr>"
				+ "<th>Thar Nge</th>"
				+ "<th style='color:red;'>Zin Gyi</th>"
				+ "<th>Mai Mai Sai</th>"
				+ "<th style='color:red;'>Poe Mi </th>"
				+ "<th>Billy la Min Aye</th>"
				+ "</tr>");
	
	    out.println("<tr>" +
	    			"<td>" + count.get(0).intValue() + "</td>"+ 
	    		    "<td style='color:red;'>" + count.get(1).intValue() + "</td>"+ 
	    		    "<td>" + count.get(2).intValue() + "</td>"+
	    		    "<td style='color:red;'>" + count.get(3).intValue() + "</td>"+
	    		    "<td>" + count.get(4).intValue() + "</td>" +
	    		    "</tr>");
		out.println("</table>");
		out.println("</BODY></HTML>");
	}
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
		}
}

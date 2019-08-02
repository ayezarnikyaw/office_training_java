import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;
public class VotingSystem extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
	IOException {
		response.setContentType("text/html");	
		PrintWriter out = response.getWriter();	
		
		boolean chkmail = false;
		String name = request.getParameter("acc_name");
		String vote = request.getParameter("rdoVote");
		String email = request.getParameter("email");
		
		if(name == null || vote == null || email == null) {
			out.println("Please fill information completely!");	
			out.close();
		} else {
			HttpSession session = request.getSession(true);
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
				
				ArrayList<Integer> singerCount=(ArrayList<Integer>)session.getAttribute("singerCount");
				if(singerCount==null) { 
					singerCount=new ArrayList<Integer>();
					singerCount.add(new Integer(0));
					singerCount.add(new Integer(0));
					singerCount.add(new Integer(0));
					singerCount.add(new Integer(0));
					singerCount.add(new Integer(0));
				}
				
				switch(vote) {
					case "2":singerCount.set(0,(Integer)(singerCount.get(0).intValue()+1));break;
					case "3":singerCount.set(1,(Integer)(singerCount.get(1).intValue()+1));break;
					case "4":singerCount.set(2,(Integer)(singerCount.get(2).intValue()+1));break;
					case "6":singerCount.set(3,(Integer)(singerCount.get(3).intValue()+1));;break;
					case "9":singerCount.set(4,(Integer)(singerCount.get(4).intValue()+1));break;
				
				}
				
				session.setAttribute("singerCount",singerCount);
				
				out.println("<html>" + "<head><title>Myanmar Idol Voting Result</title></head>");
				out.println("<body>");
				out.println("<h1>Myanmar Idol Voting Result</h1>");
				out.println("<table>");
				out.println("<tr>");
				out.println("<th><b>Thar Nge</b></th>");
				out.println("<th><b>Zin Gyi</b></th>");
				out.println("<th><b>Mai Mai Sai</b></th>");
				out.println("<th><b>Poe Mi</b></th>");
				out.println("<th><b>Billy La Min Aye</b></th>");
				out.println("</tr>");
				out.println("<tr>");
				for(int i=0;i<5;i++){
					out.println("<td>"+singerCount.get(i).intValue()+"</td>");
				}
				out.println("</tr>");
				out.println("</table>");
				out.println("</body>");
				out.close();
			}
		}
		
	}
}

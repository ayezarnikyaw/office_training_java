package assignment_registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResultServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws 
	ServletException,IOException {
		response.setContentType("text/html");
		boolean isMissingValue = false;
		
		String name = request.getParameter("name");

		if(name.equals("") || name.equals("Missing_name")) {
			name = new String("Missing_name");
			isMissingValue = true;
		}
		String gender = request.getParameter("gender");
		/*
		 * if(gender.equals("") || gender.equals("Missing_gender")) { gender = new
		 * String("Missing_gender"); isMissingValue = true; }
		 */
		String nrc = request.getParameter("nrc");
		if(nrc.equals("") || nrc.equals("Missing_nrc")) {
			nrc = new String("Missing_nrc");
			isMissingValue = true;
		}
		String father_name = request.getParameter("father_name");
		if(father_name.equals("") || father_name.equals("Missing_father_name")) {
			father_name = new String("Missing_father_name");
			isMissingValue = true;
		}
		String address = request.getParameter("address");
		if(address.equals("") || address.equals("Missing_address")) {
			address = new String("Missing_address");
			isMissingValue = true;
		}
		String phone = request.getParameter("phone");
		if(phone.equals("") || phone.equals("Missing_phone")) {
			phone = new String("Missing_phone");
			isMissingValue = true;
		}
		Cookie c1 = new Cookie("name",name);
		c1.setMaxAge(60);
		response.addCookie(c1);
		Cookie c2 = new Cookie("gender",gender);
		c2.setMaxAge(60);
		response.addCookie(c2);
		Cookie c3 = new Cookie("nrc",nrc);
		c3.setMaxAge(60);
		response.addCookie(c3);
		Cookie c4 = new Cookie("father_name",father_name);
		c4.setMaxAge(60);
		response.addCookie(c4);

		Cookie c5 = new Cookie("address",address);
		c5.setMaxAge(60);
		response.addCookie(c5);

		Cookie c6 = new Cookie("phone",phone);
		c6.setMaxAge(60);		
		response.addCookie(c6);

		String formAddress = "./register";
		if(isMissingValue) {
			response.sendRedirect(formAddress);
		}else {
			response.setContentType("text/html");
			
		}
//		PrintWriter out = response.getWriter();
		//count
		String countString="1";
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
		
		out.println("<HTML>");
		out.println("<HEAD></HEAD>");
		out.println("<body>");
		out.println("<p>StudentID : UCS " + count + "</p>");
		out.println("<p>Name : " + name + "</p>");
		out.println("<p>Gender : " + gender + "</p>");
		out.println("<p>NRC : " + nrc + "</p>");
		out.println("<p>Father : " + father_name + "</p>");
		out.println("<p>Address : " + address + "</p>");
		out.println("<p>Phone : " + phone + "</p>");
		out.println("</body>");
		out.println("</html>");
		
		
		
	}
	
}

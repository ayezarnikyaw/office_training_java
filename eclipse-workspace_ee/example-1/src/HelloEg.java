

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HelloEg extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
response.setContentType("text/html");
response.setBufferSize(8192);
PrintWriter out = response.getWriter();
out.println("<html>" + "<head><title>First Servlet</title></head>");
out.println("<body>");
out.println("<h1>Hello J2EE Programmers </H1>");
out.println("</body>");
out.close();
}
public void doPost(HttpServletRequest request,HttpServletResponse response)throws
ServletException,IOException{
doGet(request,response);
}
}

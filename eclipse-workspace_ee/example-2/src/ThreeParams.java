
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;public class ThreeParams extends HttpServlet{
public void doGet(HttpServletRequest request, HttpServletResponse response) throws
ServletException, IOException {
response.setContentType("text/html");
response.setBufferSize(8192);
PrintWriter out = response.getWriter();
out.println( "<UL>\n" +
"<LI>param1: " + request.getParameter("param1")+ "\n" +
"<LI>param2: " + request.getParameter("param2")+ "\n" +
"<LI>param3: " + request.getParameter("param3")+ "\n" +
"</UL>\n" );
}
public void doPost(HttpServletRequest request,HttpServletResponse response)throws
ServletException,IOException{
doGet(request,response);
}
}
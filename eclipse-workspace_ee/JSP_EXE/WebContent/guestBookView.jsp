<?xml version = "1.0"?>
<!DOCTYPE >
<%@ page errorPage = "errorpage.jsp" %>
<%@ page import = "java.util.*" %>
<%
String first=request.getParameter("first");
String last=request.getParameter("last");
String email=request.getParameter("email");
%>
<html xmlns = "http://www.w3.org/1999/xhtml">
<head>
<title>Guest List</title>
</head>
<body>
<p style = "font-size: 2em;">Guest List</p>
<table>
<thead>
<tr>
<th style = "width: 100px;">Last name</th>
<th style = "width: 100px;">First name</th>
<th style = "width: 200px;">Email</th>
</tr>
</thead>
<tbody>
<%
ArrayList<String> guestList = new ArrayList<String>();
guestList.add(first);
guestList.add(last);
guestList.add(email);
HttpSession s=request.getSession(true);
ArrayList<ArrayList>list=(ArrayList<ArrayList>)s.getAttribute("list");
if (list==null)
list=new ArrayList<ArrayList>();
int flag=0;
for(int j=0;j<list.size();j++ )
{
ArrayList<String> g=list.get(j);
if(g.get(2).equals(email))
{
flag=1;break;
}
}
if(guestList.get(2).toString().equals(""))
{flag=1;
}
if (flag==0)
{
list.add(guestList);
}
else{
%>
<p><font color='red'><i>Invalid Email</i></font></p>
<%
}
s.setAttribute("list",list);
System.out.println("list size:"+list.size());
for(int j=0;j<list.size();j++)
{ArrayList<String> g=list.get(j);
%>
<tr>
<%
for(int i=0;i<g.size();i++)
{
%>
<td><%=g.get(i)%></td>
<%
}
%>
</tr>
<%
}
%>
</tbody>
</table>
</body>
</html>
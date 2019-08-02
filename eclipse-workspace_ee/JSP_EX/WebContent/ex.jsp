<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="java.util.Collections"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="i" begin="1" end="5" step="1">
<c:out value="${i}"/> <br/>
</c:forEach>
<%
String arr[]={"Monday","Tuesday","Wednesday"};
Vector V=new Vector();
V.addAll(Arrays.asList(arr));
pageContext.setAttribute("vec", V);
%>
<c:forEach var="day" items="${vec}">
<c:out value="${day}"/> <br/>
</c:forEach>
<UL>
<c:forEach var="country" items="Australia,Canada,Japan,Philippines,USA">
<LI> <c:out value="${country}"/>
</c:forEach>
</UL>
</body>
</html>
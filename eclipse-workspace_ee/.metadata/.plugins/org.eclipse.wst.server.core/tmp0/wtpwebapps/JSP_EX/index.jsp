<html>
<body>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<body>
<%
String[] messages={"JSTL", "1.0","configured", "correctly!"};
pageContext.setAttribute("messages", messages);
%>
<H1>Testing JSTL 1.0</H1>
<UL>
<c:forEach var="message" items="${messages}">
<LI><B><c:out value="${message}"/></B>
</c:forEach>
</UL>
<c:forEach var="i" begin="1" end="10">
<LI><c:out value="${i}"/>
<c:choose>
<c:when test="${i < 4}">
(small)
</c:when>
<c:when test="${i < 8}">
(medium)
</c:when>
<c:otherwise>
(large)
</c:otherwise>
</c:choose>
</c:forEach>
</body>
</html>
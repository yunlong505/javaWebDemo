<html>
<body>
<h2>Get Session</h2>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="javax.servlet.http.Cookie"%>

<%
    String name = (String)session.getAttribute("name");
    String se = (String)session.getAttribute("JSESSIONID");
%>

session中的name: <%=name%>
session中的JSESSIONID: <%=se%>

</body>
</html>

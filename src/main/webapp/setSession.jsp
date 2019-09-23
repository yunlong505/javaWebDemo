<html>
<body>
<h2>Set Session</h2>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="javax.servlet.http.Cookie"%>

<%
    session.setAttribute("name", "teemo");
%>
<%--浏览器支持cookie的话,可以用下面的方法--%>
<a href="getSession.jsp">跳转到获取session的页面</a>
<%--浏览器不支持cookie的话,可以用下面的方法--%>
<%--<a href="<%=response.encodeURL("getSession.jsp")%>">跳转到获取session的页面</a>--%>

</body>
</html>

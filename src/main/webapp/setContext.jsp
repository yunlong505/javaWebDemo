<%--
  Created by IntelliJ IDEA.
  User: Harris
  Date: 2019/6/1
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>setContext</title>


    <%
        request.setAttribute("name","gareen");
//        response.sendRedirect("getContext.jsp");
    %>
    <jsp:forward page="getContext.jsp"/>

</head>
<body>

</body>
</html>

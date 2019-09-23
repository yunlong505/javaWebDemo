<%--
  Created by IntelliJ IDEA.
  User: Harris
  Date: 2019/6/1
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>MVC查询Hero列表</title>
    <script>
        $(function(){
            $("a").addClass("btn btn-default btn-xs");

        });
    </script>
</head>
<body>
<table style="width:500px; margin:44px auto" class="table table-striped table-bordered table-hover  table-condensed" align="center" border="1" cellspacing="0">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>hp</td>
        <td>damage</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:forEach items="${heros}" var="hero" varStatus="st"  >
        <tr>
            <td>${hero.id}</td>
            <td>${hero.name}</td>
            <td>${hero.hp}</td>
            <td>${hero.damage}</td>
            <td><a href="editHero?id=${hero.id}">edit</a></td>
            <td><a href="deleteHero?id=${hero.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
<dav>
    <ul class="pager">
        <li> <a href="?start=0">[首页]</a></li>
        <li> <a href="?start=${pre}">[上一页]</a></li>
        <li> <a href="?start=${next}">[下一页]</a></li>
        <li> <a href="?start=${last}">[末 页]</a></li>
        <li> <a href="http://localhost:8080/out">[退 出]</a></li>

    </ul>
</dav>




</body>
</html>

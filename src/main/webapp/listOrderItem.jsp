<%--
  Created by IntelliJ IDEA.
  User: Harris
  Date: 2019/6/4
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<script src="http://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="http://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="http://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>购物车清单</title>
</head>
<body>
<h1 align="center">购物车</h1>
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>商品名称</td>
        <td>单价</td>
        <td>数量</td>
        <td>小计</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${list}" var="oi" varStatus="st">
        <tr>
            <td>${oi.product.name}</td>
            <td>${oi.product.price}</td>
            <td>${oi.num}</td>
            <td>${oi.num*oi.product.price}</td>
            <td>
                <form action="/deleteOrderItem">
                    <input type="hidden" name="id" value="${oi.product.id}">
                    <input type="submit" value="删除">
                </form>
            </td>
                <%--<td><a href="deleteOrderItem?pid=${oi.product.id}">删除</a></td>--%>
        </tr>
    </c:forEach>
    <c:if test="${!empty list}">
        <tr>
            <td colspan="5" align="center">
                <a href="/createOrder" >生成订单</a>
            </td>
        </tr>
    </c:if>
</table>
</body>
</html>

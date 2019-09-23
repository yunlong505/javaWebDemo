<%--
  Created by IntelliJ IDEA.
  User: Harris
  Date: 2019/6/4
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>产品清单</title>
    <script src="jquery/jquery.min.js"></script>
    <%--<link href="bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">--%>
    <%--<script src="bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script>--%>

    <script>

        $(function () {
            // $(".addCartButton").removeAttr("disabled");
            $(".addCartButton").click(function () {
                $(this).attr("disabled", "disabled");
                var button = $(this);
                var pid = button.attr("pid");
                var number = $("input.number[pid=" + pid + "]").val();
                var page = "/addOrderItem";

               // 用load的方法
               //  var page = "/addOrderItem?num="+number+"&pid="+pid;
               //  $(".addCartButton").load(page,function(responseTxt,statusTxt,xhr){
               //      if(statusTxt=="success")
               //         $("#addCartSuccessMessage").fadeIn(1200);
               //         $("#addCartSuccessMessage").fadeOut(1200 ,function() {
               //          button.removeAttr("disabled");
               //      });
               //      if(statusTxt=="error")
               //          alert("Error: "+xhr.status+": "+xhr.statusText);
               //  });
                //用git的方法
                $.get(
                    page,
                    {"pid": pid, "num": number},
                    function (result) {
                        $("#addCartSuccessMessage").fadeIn(1200);
                        $("#addCartSuccessMessage").fadeOut(1200, function () {
                            button.removeAttr("disabled");
                        });
                    }
                );
            });
        //     $("#addCartSuccessMessage").hide();
        });


        // $(function () {
        //     $("input.addCartButton").removeAttr("disabled");
        //     $("input.addCartButton").click(function () {
        //         $(this).attr("disabled", "disabled");
        //         var button = $(this);
        //         var pid = $(this).attr("pid");
        //         var number = $("input.number[pid=" + pid + "]").val();
        //         var page = "/addOrderItem";
        //         $.get(
        //             page,
        //             {"num": number, "pid": pid},
        //             function (result) {
        //                 $("#addCartSuccessMessage").fadeIn(1200);
        //                 $("#addCartSuccessMessage").fadeOut(1200, function () {
        //                     button.removeAttr("disabled");
        //                 });
        //             }
        //         );
        //     });
        //     $("#addCartSuccessMessage").hide();
        // });


    </script>

</head>
<body>
<c:if test="${!empty user}">
    <div align="center">当前用户:${user.name}</div>
</c:if>
<div align="center" style="height:20px;margin:20px;">
    <span  style="color:Chartreuse" hidden="hidden" id="addCartSuccessMessage">加入购物车成功</span>
</div>
<table align='center' border="1" cellspacing="0">
    <tr>
        <td>id</td>
        <td>产品</td>
        <td>价格</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="st">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>
                    <%--<form action="addOrderItem" method="post">--%>
                    <%--数量<input value="1" name="num">--%>
                    <%--<input type="hidden" name="pid" value="${product.id}">--%>
                    <%--<input type="submit" class="sub" value="加入购物车">--%>
                    <%--</form>--%>

                    <%--自己写的有问题 number和pid取的都是第一个,解决办法是先取button，在number和button上都加上pid，先去button再根据button上的pid取num--%>
                    <%--数量<input value="1" class="number" name="num">--%>
                    <%--<input type="hidden" name="pid" class="pidClass" value="${product.id}">--%>
                    <%--<input type="submit"  class="addCartButton" value="加入购物车">--%>

                数量<input pid="${product.id}" class="number" type="text" value="1" name="num">
                <input class="addCartButton" pid="${product.id}" type="submit" value="加入购物车">
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="4"><a href="/listOrderItem">查看购物车</a></td>
    </tr>
</table>
</body>
</html>

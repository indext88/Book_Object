<%@page import="cn.edu.svtcc.test.pojo.BookDo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>header</title>
     <link type="text/css" rel="stylesheet" href="..\css\header.css"/>
     <script type="text/javascript" src="..\js\jquery-3.3.1.js"></script>
</head>

<body>
<div class="header">
 <div class="topp">
    <div class="nav">
        <ul>
            <li name="user" >
                <c:if test="${sessionScope.name!=null}">
                <span style="margin-top: 4px;color: gray;margin-left: -5px;">
                ${sessionScope.name}
                </span>
                </c:if>
                <c:if test="${sessionScope.name==null}">       
                 <a href="#">用户登录</a></c:if>
                <ul>
                    <li>
                        <a href="../web-page/tel.jsp">登录</a>
                    </li>
                    <li>
                        <a href="../web-page/zuce.jsp">注册</a>
                    </li>
                </ul>
            </li>
                <ul>
                    <li>
                        <a href="#">我的书籍&nbsp;&nbsp;</a>
                    </li>
                    <li>
                    <a href="javascript:void(0)" id="order">我的订单&nbsp;&nbsp;</a>
                    </li>
                    <li>
                        <a href="#">关于我们&nbsp;&nbsp;</a>
                    </li>
                    <li>
                        <a href="#">客服服务&nbsp;&nbsp;</a>
                    </li>
                </ul>
                </ul>
    </div>
</div>

<div class="middlee">


    <div class="img">
        <img src="..\Img\zz.gif" height="190px" width="200px" style="margin-left:20px;margin-top:-20px;">
    </div>
    <div class="Search_Har">
        <form class="shousuo" action="../BookSeverlet?opt=tname" method="post">
            <input type="submit" class="box" value="搜索">
            <input type="text" class="box2" name="tname">
        </form>
    </div>
</div>

<div class="tables">
    <table class="Table_Classification">
        <tr>
            <th>
                <a href="../BookSeverlet?opt=title_a">首页</a>
            </th>
            <th>
                <div class="avm">
                    <ul>
                        <li>
                            <a href="#">全部分类</a>
                        </li>
                    </ul>
                </div>
            </th>
            <th>
                <a href="#">文学著作</a>
            </th>
            <th>
                <a href="#">幼儿教育</a>
            </th>
            <th>
                <a href="#">励志人生</a>
            </th>
            <th>
                <a href="#">计算机应用</a>
            </th>
            <th>
                <a href="#">学习辅导</a>
            </th>
            <th>
                    <a href="../shoppingSevelet?opt=showcart">购物车</a>
            </th>
        </tr>
    </table>
</div>
</div>
<script>
			var $order_page=$("#order");
			$order_page.click(function(){
				$.ajax({
					 url:"../PaymentSeverlet?opt=order_page",
	                 type:"post",
	                 dataType:"json",
	                 data:{},
	                 success:function(data){
	                	 if(data.code==1){
	                		 alert("你还未登录");
	                		 window.location.href="../web-page/tel.jsp";
	                	 }
	                	 if(data.code == 2){
	                     	window.location.href = "../web-page/order_page.jsp";                      
	                	 }
	                 }
				})
			})
</script>
</body>

</html>
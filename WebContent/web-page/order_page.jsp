<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>我的订单</title>
    <script type="text/javascript" src="..\js\jquery-3.3.1.js"></script>
    <link type="text/css" rel="stylesheet" href="..\css\order_page.css"/>
    </head>
       <body>
       <%@ include file="header.jsp"%>
           <div class="table_all">
           
           
               <table class="table_a">
                   <tr>
                       <td style="width:150px;">订单号</td>
                       <td style="width:200px;">创建时间</td>
                       <td style="width:150px;">用户ID</td>
                       <td style="width:150px;">金额</td>
                       <td style="width:150px;">操作</td>
                   </tr>
                   </table>
                   <table class="table_b">
                   <c:forEach items="${sessionScope.order_page}" var="i">
                   <tr  class="xiangqing">
                       <td style="width:150px;" class="id">${i.getId()}</td>
                       <td style="width:200px;">${i.getOrderDate()}</td>
                       <td style="width:150px;">${i.getUserId()}</td>
                       <td style="width:150px;">${i.getTotalPrice()}</td>
                       <td style="width:150px;"><input type="button" style="border:0px;" class="del" value="删除"></td>
                   </tr>
                </c:forEach>
               </table>
           </div>
           <script type="text/javascript">
           $select=$(".btn");
           $order_del=$(".del");
           
           $order_del.click(function(){
        	   var $id=$(this).parent().siblings(".id").text();
        	   console.log($id);
        	   $(this).parent().parent().remove();
        	   $.ajax({
                   url:"../PaymentSeverlet?opt=order_del",
                   type:"post",
                   data:{id:$id},
                   success:function(data){
        		   if(data.code==1){
        			   alert("删除成功");
        			   $(".table_b").remove();
        		   }
        		   if(data.code==3){
        			   alert("删除失败");
        		   }
        	   }
               })
           })
           </script>
</body>
</html>
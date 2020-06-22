<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="..\css\order.css">
<script type="text/javascript" src="..\js\jquery-3.3.1.js"></script>
</head>
<body>
<%@ include file="header.jsp" %>
 <div class="shopping_all">
        <table style="background-color: #d6d4d4;">
            <tr>
                <td style="width:80px"></td>
                <td style="width:430px">商品信息</td>
                <td style="width:130px">单价</td>
                <td style="width:160px">数量</td>
                <td style="width:145px">金额</td>
            </tr>
        </table>
        <table>
        <c:forEach items="${sessionScope.order}" var="item">
            <tr>
                <td class="td_img">
                    <div class="img_all">
                        
                        <div class="book_img">
                            <img src="../Img/cover.jpg" width="80px" height="105px">
                        </div>
                    </div>
                </td>
                <td class="td_name">
                    <div class="book_name">${item.getItem().getTitle() }</div>
                </td>
                <td class="td_price_a">
                    <div class="book_price">${item.getItem().getUntiPrice() }</div>
                </td>
                <td class="td_num">
                    <div class="book_jianxi" id="number">
                        <span href="${item.getItem().getIsbn()}">${item.getAmout()}</span>
                    </div>
                </td>
                <td class="td_price_b">
                    <div class="book_price_b">${item.getItem().getUntiPrice() * item.getAmout()}</div>
                </td>
            </tr>
            </c:forEach>
           
        </table>
        <table class="table_c">
        <form action="../PaymentSeverlet?opt=zhifu" methon="post">
            <tr>
                <td class="td_all"></td>
                <td class="td_favorites"></td>
                <td class="td_share"></td>
                <td class="td_sum_a">合计(不含运费):</td>
                <td class="td_sum_b">￥
                    <span id="j" name="price">0.0</span>元</td>
                <td class="td_btn">
                    <a href="../PaymentSeverlet?opt=zhifu">
                    <input type="button" value="确认支付" class="btn_sum"></a>
                </td>
            </tr>
            </form>
        </table>

        </div>
        <script>
          $(function(){
              var $sumprice=0.0;
              $(".book_price_b").each(function(){
                 $sumprice+=parseFloat($(this).text());
              })
              $("#j").text($sumprice);
          })

        </script>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购物车显示</title>
<link type="text/css" rel="stylesheet" href="..\css\shopping_show.css"></style><!-- 链接外部css样式表 -->
<script type="text/javascript" src="..\js\shopping_show.js"></script><!-- 链接外部js样式表 -->
<script type="text/javascript" src="..\js\jquery-3.3.1.js"></script>
</head>
<body>
<%@ include file="header.jsp" %>
  <div class="shopping_all">
        <table>
            <tr>
                <td style="width:150px">
                    <input type="checkbox" id="check_all_a" onclick="checkall()">全选</td>
                <td style="width:400px">商品信息</td>
                <td style="width:130px">单价</td>
                <td style="width:160px">数量</td>
                <td style="width:145px">金额</td>
                <td>操作</td>
            </tr>
        </table>
        <table id="table_books">
         <c:if test="${sessionScope.collection==null }">
               <center class="gou">购物车空空如也</center>
               </c:if>
        
                <c:forEach items="${sessionScope.collection}" var="its">
            <tr>
                <td class="td_img">
                    <div class="img_all">
                        <input type="checkbox" name="checkname">
                        <div class="book_img">
                            <img src="../Img/cover.jpg" width="80px" height="105px">
                        </div>
                    </div>
                </td>
                <td class="td_name">
                    <div class="book_name">${its.item.title}</div>
                </td>
                <td class="td_price_a">
                    <div class="book_price">${its.item.untiPrice}</div>
                </td>
                <td class="td_num">
                    <div class="book_jianxi">
                         <input id="num_reducee" type="button" value="-" class="num_reduce"></a>
                        <span href="${its.item.isbn}">${its.amout}</span>
                        <input id="num_addd"type="button" value="+" class="num_add">
                     </div>
                </td>
                <td class="td_price_b">
                    <div class="book_price_b"> ${its.amout*its.item.untiPrice}</div>
                </td>
                <td class="td_operation">
                    <div class="book_operation">
                    <a href="../shoppingSevelet?opt=del&isbn=${its.item.isbn}" id="del_Book">删除</a></div>
                </td>
            </tr>
            </c:forEach>
        </table>
        <table class="table_c">
            <tr>
                <td class="td_duo">
                    <input type="checkbox"  id="check_all_b" onclick="checkallb()">
                </td>
                <td class="td_all">全选</td>
                <td class="td_del"><a href="javascript:void(0)" id="mmmm" onclick="dell()">删除</a></td>
                <td class="td_favorites">移入收藏夹</td>
                <td class="td_share">分享</td>
                <td class="td_change">已选商品<span  id="zz">0</span>件</td>
                <td class="td_sum_a">合计(不含运费):</td>
                <td class="td_sum_b" >￥<span  id="j" name="sum_porice">0.0</span>元</td>
                <td class="td_btn">
                <input type="submit" value="结算" class="btn_sum" name="btn_summ">
                </td>
            </tr>
            
        </table>
        </div>
        <script type="text/javascript">
        var $num_reducee=$(".num_reduce");
        var $num_addd=$(".num_add");
        var $jishuan=$(".btn_sum");
        //订单支付
          $jishuan.click(function(){
                var $isbn=new Array();
                var $i = 0;
                $("input[name=checkname]").each(function () {
                    //console.dir($(e).is(":checked"))
                    if ($(this).is(":checked")) {
                        // console.dir($(e).parent().parent().parent().find(".book_price_b"))
                        var num= $(this).parent().parent().parent().find(".td_num").children().children("span").attr("href");
                        $isbn[$i++]=num;
                    }
                })
             $.ajax({
                 url:"../PaymentSeverlet?opt=dingdan",
                 type:"post",
                 dataType:"json",
                 data:{"order":JSON.stringify($isbn)},
                 success:function(data){
                	 if(data.code==1){
                		 alert("你还未登录");
                		 window.location.href="../web-page/tel.jsp";
                	 }
                	 if(data.code == 2){
                      	alert("创建订单错误，请重新登录");
                     	window.location.href = "Login.jsp";                      
                     }
                     if(data.code == 3){
                     	alert("订单错误，请重试");
                     }
                     if(data.code == 100){
                     	window.location.href = "../web-page/order.jsp"; 
                     }   
             	}  
             })
        })
        
        
        //数量减少
       $num_reducee.click(function() {
    	   var v = Number($(this).next().text());
    	   var $this=$(this);
           var m=0.0;
           var all_price = 0.0;
           var num = 0;
           var dianjia=Number($(this).parent().parent().siblings().eq(2).text());
           var sumjia = Number($("#j").text());//总价
           var number = Number($("#zz").text());//数量
           if(v<=1){
        	   alert("购买数量最低为1");
           }else{
        	   if ($(this).parent().parent().siblings().eq(0).children(0).children(0).is(":checked")) {
                   all_price = sumjia - dianjia;
                   num = number - 1;
                   $("#j").text(all_price + "");
                   $("#zz").text(num + "");
           }	   
        	   v--;
               m=dianjia*v;
               $.ajax({
               	url:"../shoppingSevelet?opt=jian",
               	type:"post",
               	data:{isbn:$(this).next().attr("href")},
               	success:function(data){
               		$this.parent().parent().siblings().eq(3).children(0).text(m+"");
               		$this.next().text(v+"");
               	}
                })
                return false;  
              
           }
           });
       //数量增加
        $num_addd.click(function(){
                      var v = Number($(this).prev().text());
                      var m=0.0;
                      var $this=$(this);
                      var all_price = 0.0;
                      var num = 0;
                      var dianjia=Number($(this).parent().parent().siblings().eq(2).children(1).text());
                      var sumjia = Number($("#j").text());
                      var number = Number($("#zz").text());
                      v++
                     // $this.prev().val(v+"");
                      m=dianjia*v;
                      if ($(this).parent().parent().siblings().eq(0).children(0).children(0).is(":checked")) {
                          all_price = sumjia + dianjia;
                          num = number + 1;
                          $("#j").text(all_price + "");
                          $("#zz").text(num + "");
                      }
                      $.ajax({
                    	url:"../shoppingSevelet?opt=jia",
                    	type:"post",
                    	data:{isbn:$(this).prev().attr("href")},
                    	success:function(data){
                    		$this.prev().text(v+"");
                    		$this.parent().parent().siblings().eq(3).children(0).text(m+"");
                    	}
                    	 
                     })
                     return false;
                  });
        $("input[name=checkname]").click(function () {
            var total = 0;
            var num = 0;
            $("input[name=checkname]").each(function (i, e) {
                //console.dir($(e).is(":checked"))
                if ($(e).is(":checked")) {
                    // console.dir($(e).parent().parent().parent().find(".book_price_b"))
                    total += parseFloat($(e).parent().parent().parent().find(".book_price_b").text());
                    num += parseFloat($(e).parent().parent().parent().find(".td_num").text());
                    
                    console.log(num);
                }
            })
            $("#j").text(total + "");
            $("#zz").text(num + "");

        })
        //上全选
        function checkall(){
            var all=document.getElementById("check_all_a");
            var one=document.getElementsByName("checkname");
            var all_b=document.getElementById("check_all_b");
            var total = 0;
            var num = 0;
            if(all.checked==true){
                for(var i=0;i<one.length;i++){
                    one[i].checked=true
                    all_b.checked=true
                }
                $("input[name=checkname]").each(function (i, e) {
                    if ($(e).is(":checked")) {
                        total += parseFloat($(e).parent().parent().parent().find(".book_price_b").text())
                        num += parseFloat($(e).parent().parent().parent().find(".td_num").text())
                    }
                })
                $("#j").text(total + "")
                $("#zz").text(num + "");
            }else{
                for(var j=0;j<one.length;j++){
                    one[j].checked=false;
                    all_b.checked=false;
                }
                $("#j").text("0")
                $("#zz").text("0");
                
            }
           
        }
        //下全选
        function checkallb(){
            var all=document.getElementById("check_all_a");
            var one=document.getElementsByName("checkname");
            var all_b=document.getElementById("check_all_b");
            var total = 0;
            var num = 0;
            if(all_b.checked==true){
                for(var i=0;i<one.length;i++){
                    one[i].checked=true
                    all.checked=true
                }
                $("input[name=checkname]").each(function (i, e) {
                    if ($(e).is(":checked")) {
                        total += parseFloat($(e).parent().parent().parent().find(".book_price_b").text())
                        num += parseFloat($(e).parent().parent().parent().find(".td_num").text())
                    }
                })
                $("#j").text(total + "");
                $("#zz").text(num + "");
            }else{
                for(var j=0;j<one.length;j++){
                    one[j].checked=false;
                    all.checked=false;
                }
                $("#j").text("0");
                $("#zz").text("0");
            }


        }
        //全部删除
        function dell(){
            var all=document.getElementById("check_all_a");
            var all_b=document.getElementById("check_all_b");
            if(all.checked==true||all_b==true){
            window.location.href="../shoppingSevelet?opt=clear";
            }
            else{
                alert("请全选！！")
            }
        }
        
        </script>
</body>
</html>
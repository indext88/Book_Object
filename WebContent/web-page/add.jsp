<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品购买</title>
<link type="text/css" rel="stylesheet" href="..\css\shopping_add.css">
<script type="text/javascript" src="..\js\shopping_add.js"></script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="all_shopping">
		<div class="img_all">
			<div class="shopping_img">
				<img src="../Img/cover.jpg" width="400px" height="600px">
			</div>
		</div>
		<c:set value="${sessionScope.blist}" var="blist"></c:set>
		<div class="text_all">
			<ul>
				<li><div class="book_name">${sessionScope.blist.title}</div></li>
				<li>
					<div class="book_a">青春的每一本书来都源自读者的需要</div>
				</li>
				<li>
					<div class="book_auto">${sessionScope.blist.author}</div>
				</li>
				<li>
					<div class="price">
						价格：
						<div class="book_price">￥${sessionScope.blist.untiPrice}元</div>
					</div>
				</li>
				<li>
					<div class="book_jianjie">
						简介：
						<div>${sessionScope.blist.contentDescription}</div>
					</div>
				</li>
				<li>
					<div class="book_num">
						购买数量：
						<div class="book_jianxi">
							<form method="post" action="../shoppingSevelet?opt=buy">
								<input type="button" value="-" class="num_reduce"
									onclick="num_reducee()"> 
									<input type="text" value="1"
									class="text" id="num" name="num"> <input type="button"
									value="+" class="num_add" onclick="num_addd()">
						</div>
					</div>
				</li>
				<li>
					<div class="shopping_btn">
						<input type="button" value="立即购买" class="btn1"> <input
							type="submit" value="加入购物车" class="btn2">
						</form>
					</div>
				</li>
			</ul>
		</div>
	</div>
</body>
</html>
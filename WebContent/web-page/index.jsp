<%@page import="cn.edu.svtcc.test.pojo.CategoriesDo"%>
<%@page import="cn.edu.svtcc.test.dao.CategoriesDaoimpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="..\css\index.css">
<script type="text/javascript" src="..\js\index.js"></script>
</head>
<body>
	<!-- 得到统计的在线人数 -->
	在线人数：${applicationScope.onlineNums}
	<!-- ${sessionScope.blist} -->
	<%@ include file="header.jsp"%>
	<div class="all">

		<div class="topp">
			<div class="herff">

				<c:if test="${applicationScope.categories!=null}">
					<c:forEach items="${applicationScope.categories}" var="c">
						<ul>
							<li><a href="../BookSeverlet?opt=byCategory&cid=${c.id}"
								style="cursor: hand;">${c.name}</a></li>
						</ul>
					</c:forEach>
				</c:if>
			</div>
			<div class="img">
				<img src="..\Img\img_1.jpg" id="img" width="850px" height="400px"
					style="margin-top: 18px;">
			</div>
			<img src="..\Img\img_a.jpg" width="330px" height="190px"
				style="margin-top: -2px;"> <img src="..\Img\img_b.jpg"
				width="330px" height="190px" style="margin-top: 20px;">


			<div class="books">
				<c:set value="${applicationScope.Booklist}" var="book_list"></c:set>
				<c:if test="${book_list!=null}">
					<ul>
						<c:forEach items="${book_list.datas}" var="b">
							<li class="book_li">
								<div class="book_img">
									<img src="../Img/cover.jpg" width="120px" height="160px">
								</div>
								<div class="book_name">&nbsp;&nbsp;${b.title}</div>
								<div class="book_price">${b.untiPrice}元&nbsp;&nbsp;&nbsp;&nbsp;
									 <!--<a href="../CartServlet?opt=add&isbn=${b.isbn}">加入购物车</a>--> 
									<a href="../shoppingSevelet?opt=add&isbn=${b.isbn}">加入购物车</a>
								</div>
							</li>
						</c:forEach>
					</ul>
				</c:if>
				</div>
				</div>
				</div>
	<%@ include file="footer.jsp"%>
</body>
</html>
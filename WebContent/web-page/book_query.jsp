<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>图书查询</title>
    <link type="text/css" rel="stylesheet" href="..\css\book_query.css">
</head>
<body>


<%@ include file="header.jsp" %>
    <div class="query_all">             
        <c:set value="${sessionScope.blist}" var="blist"></c:set>
				<c:if test="${blist!=null}">
						<c:forEach items="${blist.datas}" var="b">
	  <div class="book_all">
	  <a href="../shoppingSevelet?opt=add&isbn=${b.isbn}"><img src="../Img/cover.jpg" width="180px" height="250px" style="margin-left:30px;"></a>
       <div class="price">￥${b.untiPrice}元</div>
        <div class="name"><a href="../shoppingSevelet?opt=add&isbn=${b.isbn}">${b.title}</a></div>
        <div class="author">${b.author}</div>
        </div>
						</c:forEach>
				</c:if>
				<c:if test="${blist==null}">
				<center>抱歉！没有你查询的图书</center>
				</c:if>
        
        
    
    <div class="mm">
					<c:if test="${blist.totalPage>1}">
共${blist.totalRecord}本图书信息，共有${blist.totalPage}页,当前${blist.pageNum}页
<br>
						<a href="../BookSeverlet?opt=withPage&pageNum=1"> <input
							type="button" value="首页"></a>
						<c:if test="${blist.pageNum>1}">
							<a href="../BookSeverlet?opt=withPage&pageNum=${blist.pageNum-1}">
								<input type="button" value="上一页" id="previous">
							</a>
						</c:if>
						<c:forEach begin="${blist.start}" end="${blist.end}" step="1"
							var="i">
							<c:if test="${blist.pageNum == i}">
            ${i}
           </c:if>
							<c:if test="${blist.pageNum != i}">
								<a href="../BookSeverlet?opt=withPage&pageNum=${i}">${i}</a>
							</c:if>
						</c:forEach>

						<c:if test="${blist.end!=blist.totalPage}">
							<a href="../BookSeverlet?opt=withPage&pageNum=${blist.pageNum+1}">
								<input type="button" value="下一页" id="next">
							</a>
						</c:if>
						<a href="../BookSeverlet?opt=withPage&pageNum=${blist.totalPage}"><input
							type="button" value="尾页" id="ends" onclick="endsss()"></a>
					</c:if>
				</div>
			</div>
    <%@ include file="footer.jsp" %>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="cn.edu.svtcc.severlet.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link type="text/css" rel="stylesheet" href="..\css\tel.css"></style><!-- 链接外部css样式表 -->
<script type="text/javascript" src="..\js\tel.js"></script><!-- 链接外部js样式表 -->
<script type="text/javascript" src="..\js\jquery-3.3.1.js"></script>
</head>

 <title>用户登录</title>
</head>
<body>
    <div class="tel_fangkuang">
        <div class="err" id="tishi">用户或密码错误</div>
        <div class="denlu">
            用&nbsp;&nbsp;户&nbsp;&nbsp;登&nbsp;&nbsp;录
        </div>
        <div class="tijiao">
            <form action="" method="POST">
                <div class="usem">用户名：<input type="text" class="yonghu" name="usern" ></div>
                <div class="password">密&nbsp;&nbsp;&nbsp;码：<input type="password" class="pwd" name="passwordd"></div>
                <div class="btn">
                    <input type="button" value="登录" class="tel">
                    <a href="../web-page/index.jsp"><input type="button" value="退出" class="exit"></a>
                </div>
            </form>
        </div>
        <div class="zuce">
            没有账户?<a href="../web-page/zuce.jsp">注册</a></span>
        </div>

    </div>
    <script>
     var i = 0;
    var timeInterval = 5000;
    var mm=new Array();
    mm[0]="aa_b.jpg";
    mm[1]="zx_b.jpg";
    mm[2]="cc_b.jpg";
    setInterval(qiehuan, timeInterval);
    function qiehuan() {
        if (i ==mm.length-1) {
            i = 0;
        }
        else {
            i += 1;
        }
        var img=mm[i];
        document.body.style.backgroundImage="url("+"../Img/"+img+")";
        }
        var bt2=document.getElementById("btn2");
    
    	$(".tel").click(function(){
            $.ajax({
                url:"../HomePageSeverlet?opt=tel",
                dataType:"json",
                type:"post",
                data:{Uname:$(".yonghu").val(),pwdd:$(".pwd").val()},
                success:function(data){
                    if(data.code=="ok"){
                        window.location.href="../web-page/index.jsp";
                        }else if(data.code="no"){
                            $("#tishi").css("display","block");
                            $(".yonghu").val("");
                            $(".pwd").val("");
                        }
                }
            })
        });

    
       
    </script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>注册用户</title>
    <link type="text/css" rel="stylesheet" href="..\css\zuce.css"></style><!-- 链接外部css样式表 -->
    <script type="text/javascript" src="..\js\jquery-3.3.1.js"></script>
    <script type="text/javascript" src="..\js\zuce.js"></script><!-- 链接外部js样式表 -->
</head>

<body>
    <div class="mm">
        <br>
        <br>
        <div class="title">注册用户</div>
        <form method="post" action="../HomePageSeverlet?opt=zuce" id="tijiao">

            <div class="youhu">
                <table style="border-collapse:separate; border-spacing:0px 20px;">
                    <tr>
                        <td class="buju">用户名：</td>
                        <td>
                            <input type="text" name="loginId" id="loginId" placeholder="用户名由字母、数字、文字组成" class="name" onblur="nn()" onfocus="na()">
                        </td>
                        <td>
                            <div class="tiaojian">
                                <span id="mms"></span>
                            </div>
                        </td>
                    </tr>

                    <tr>
                        <td class="buju"> 密码：</td>
                        <td>
                            <input type="password" name="loginPwd" id="loginPwd" placeholder="密码由字母、数字、符号组成" class="pwd" onblur="pwd()"
                                onfocus="pwdd()">
                        </td>
                        <td>
                            <div class="tiaojian">
                                <span id="ps"></span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="buju">确认密码：</td>
                        <td>
                            <input type="password" name="userPwdd" id="userPwdd" placeholder="再次确认密码" class="pwd" onblur="psw()"
                                onfocus="psww()">
                        </td>
                        <td>
                            <div class="tiaojian">
                                <span id="pss"></span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="buju">姓名：</td>
                        <td>
                            <input type="text" name="name" id="name" placeholder="请输入姓名" class="name" onblur="user()" onfocus="users()">
                        </td>
                        <td>
                            <div class="tiaojian">
                                <span id="user"></span>
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td class="buju">联系电话：</td>
                        <td>
                            <input type="text" name="phone" id="phone" placeholder="联系电话" class="phone" onblur="ph()" onfocus="phs()">
                        </td>
                        <td>
                            <div class="tiaojian">
                                <span id="dianhua"></span>
                            </div>
                        </td>
                        <tr>
                            <td class="buju">E-mail：</td>
                            <td>
                                <input type="text" name="mail" id="mail" placeholder="输入电子邮箱！如：fasf@sin.com" class="mail" onblur="maill()"
                                    onfocus="maills()">
                            </td>
                            <td>
                                <div class="tiaojian">
                                    <span id="mal"></span>
                                </div>
                            </td>
                            <tr>
                                <td class="buju">家庭住址：</td>
                                <td>
                                    <input type="text" name="address" id="address" placeholder="家庭住址" class="address" onblur="ads()"
                                        onfocus="adss()">
                                </td>
                                <td>
                                    <div class="tiaojian">
                                        <span id="zhuzhi"></span>
                                    </div>
                                </td>
                                <br/>
                                <br/>
                                <tr>
                                    <td>
                                        <input type="button" name="btn1" id="btn1" value="提交" class="ss" disabled="disabled" onclick="danji()">
                                    </td>
                                    <td>
                                        <input type="reset" name="btn2" id="btn2" value="重置" class="reset" disabled="disabled">
                                    </td>
                                </tr>
                </table>
        </form>
        </div>
        <script type="text/javascript">
        function nn(){
        	 var username=document.getElementById("loginId").value;
             var mm=document.getElementById("mms").innerHTML;
             var username = document.getElementById("loginId").value;
             var re = /[^\a-zA-Z\u4E00-\u9FA5]/g;  //只能输入中文和英文 
             var bt2=document.getElementById("btn2");
             var bt1=document.getElementById("btn1");
             if (username == null || username == "") {
                 document.getElementById('mms').innerHTML = "<font color='red' size='1px'><b>*用户名不能为空</b></font>";
                 return false;
             } else if (re.test(username)) {
                 document.getElementById('mms').innerHTML = "<font color='red' size='1px'><b>*用户名由英文字母、文字组成</b></font>"
                 return false
             } else if (username.length > 20) {
                 document.getElementById('mms').innerHTML = "<font color='red' size='1px'><b>*用户名最大为20位</b></font>"
                 return false
             }
             else if (username.indexOf(" ") >= 0) {
                 document.getElementById('ps').innerHTML = "<font color='red' size='1px'><b>*用户名不能含有空格</b></font>";
                 return false;
             }
             $.ajax({
            	url:"../HomePageSeverlet?opt=zuce_b",
            	dataType:"json",
            	type:"post",
            	data:{name:username},
            	success:function(data){
					if(data.code == "ok"){
						document.getElementById("mms").innerHTML="<font color='red' size='1px'><b>*用户名已存在</b></font>"
					}else{
						document.getElementById("mms").innerHTML="<font color='green' size='3px'><b>√</b></font>"
					}
				}	 
             })
        }
        function na() {
            document.getElementById("mms").innerHTML = "";
        }
        
        </script>
</body>
</html>
 var i = 0;
    var timeInterval = 5000;
    var mm=new Array();
    mm[0]="aa.jpg";
    mm[1]="zx.jpg";
    mm[2]="cc.jpg";
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
        //判断用户名是否为空和输入格式    
        function nn() {
            
        }
        function na() {
            document.getElementById("mms").innerHTML = "";
        }
   

        //判断密码
        function pwd() {
            var userpwd = document.getElementById("loginPwd").value;
            var re = /.*[\u4e00-\u9fa5]+.*$/;//表达式为只能显示中文
            var bt2=document.getElementById("btn2");
            var bt1=document.getElementById("btn1");
            if (userpwd == null || userpwd == "") {
                document.getElementById('ps').innerHTML = "<font color='red' size='1px'><b>*密码不能为空</b></font>";
                return false;
            } else if (userpwd.indexOf(" ") >= 0) {
                document.getElementById('ps').innerHTML = "<font color='red' size='1px'><b>*密码不能含有空格</b></font>";
                return false;
            } else if (re.test(userpwd)) {
                document.getElementById('ps').innerHTML = "<font color='red' size='1px'><b>*密码由字母、数字、符号组成</b></font>";
                return false;
            }
            else {
                document.getElementById('ps').innerHTML = "<font color='green' size='3px'><b>√</b></font>";
                bt2.disabled=false;
                bt1.disabled=false;
                return true;
                

            }
        }
        function pwdd() {
            document.getElementById("ps").innerHTML = "";
        }

        //判断两次密码输入是否一致
        function psw() {
            var userpwdd = document.getElementById("userPwdd").value;
            var userpwd = document.getElementById("loginPwd").value;
            var bt2=document.getElementById("btn2");
            var bt1=document.getElementById("btn1");
            if (userpwdd == null || userpwdd == "") {
                document.getElementById('pss').innerHTML = "<font color='red' size='1px'><b>*密码不能为空</b></font>";
                return false;
            } else if (userpwdd != userpwd) {
                document.getElementById('pss').innerHTML = "<font color='red' size='1px'><b>*两次输入密码不同</b></font>";
                return false;
            } else {
                document.getElementById('pss').innerHTML = "<font color='green' size='3px'><b>√</b></font>";
                bt2.disabled=false;
                bt1.disabled=false;
                return true;
                
            }
        }
        function psww() {
            document.getElementById("pss").innerHTML = "";
        }


        //判断姓名
        function user() {
            var yonghu = document.getElementById("name").value;
            var re = /[^\a-zA-Z\u4E00-\u9FA5]/g;//只能为中文和英文
            var bt2=document.getElementById("btn2");
            var bt1=document.getElementById("btn1");
            if (yonghu == null || yonghu == "") {
                document.getElementById('user').innerHTML = "<font color='red' size='1px'><b>*姓名不能为空</b></font>";
                return false;
            } else if (re.test(yonghu)) {
                document.getElementById('user').innerHTML = "<font color='red' size='1px'><b>*姓名为字母或中文</b></font>";
                return false;
            } else if (yonghu.indexOf(" ") >= 0) {
                document.getElementById('user').innerHTML = "<font color='red' size='1px'><b>*密码不能含有空格</b></font>";
                return false;
            }
            else if (yonghu.length > 8) {
                document.getElementById('user').innerHTML = "<font color='red' size='1px'><b>*姓名最大为4字</b></font>";
                return false;
            } else {
                document.getElementById('user').innerHTML = "<font color='green' size='3px'><b>√</b></font>";
                
                bt2.disabled=false;
                bt1.disabled=false;
                return true;
            }
        }
        function users() {
            document.getElementById("user").innerHTML = "";
        }


        //联系电话
        function ph() {
            var dianhua = document.getElementById("phone").value;
            var num=/^\+?[1-9][0-9]*$/;//只能为数字
            var re = /^1[3,5,8,7]\d{9}$/;//电话格式
            var bt2=document.getElementById("btn2");
            var bt1=document.getElementById("btn1");
            if (dianhua == null || dianhua == "") {
                document.getElementById('dianhua').innerHTML = "<font color='red' size='1px'><b>*联系电话不能为空</b></font>";
                return false;
            }else if(!(num.test(dianhua))){
                document.getElementById('dianhua').innerHTML = "<font color='red' size='1px'><b>*联系电话为数字</b></font>";
                return false;
            } 
            else if (dianhua.length != 11) {
                document.getElementById('dianhua').innerHTML = "<font color='red' size='1px'><b>*电话为11位</b></font>";
                return false;
            }
            else if (!(re.test(dianhua))) {
                document.getElementById('dianhua').innerHTML = "<font color='red' size='1px'><b>*电话格式错误</b></font>";
                return false;
            } else {
                document.getElementById("dianhua").innerHTML = "<font color='green' size='3px'><b>√</b></font>";
                
                bt2.disabled=false;
                bt1.disabled=false;
                return true;
            }

        }
        function phs() {
            document.getElementById("dianhua").innerHTML = "";

        }


        //判断邮箱格式

        function maill() {
            var youxiang = document.getElementById("mail").value;
            var re = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;//邮件格式
            var bt2=document.getElementById("btn2");
            var bt1=document.getElementById("btn1");
            if (youxiang == null || youxiang == "") {
                document.getElementById('mal').innerHTML = "<font color='red' size='1px'><b>*电子邮箱不能为空</b></font>";
                return false;
            } else if (!(re.test(youxiang))) {
                document.getElementById('mal').innerHTML = "<font color='red' size='1px'><b>*邮箱格式错误</b></font>";
                return false;
            } else {
                document.getElementById("mal").innerHTML = "<font color='green' size='3px'><b>√</b></font>";
                
                bt2.disabled=false;
                bt1.disabled=false;
                return true;
            }
        }
        function maills() {
            document.getElementById("mal").innerHTML = "";
        }


        //家庭住址
        function ads() {
            
            var zuzi = document.getElementById("address").value;
            var bt1=document.getElementById("btn1");
            var bt2=document.getElementById("btn2");
            if (zuzi == null || zuzi == "") {
                document.getElementById('zhuzhi').innerHTML = "<font color='red' size='1px'><b>*家庭住址不能为空</b></font>";
                return false;
            } else{
                document.getElementById("zhuzhi").innerHTML = "<font color='green' size='3px'><b>√</b></font>";
                bt2.disabled=false;
                bt1.disabled=false;
                return true;  
            }
        }

        function adss() {
            document.getElementById("zhuzhi").innerHTML = "";
        }

        

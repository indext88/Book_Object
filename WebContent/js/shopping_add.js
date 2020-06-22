/**
 * 购买数量的添加和消减
 */
function num_reducee(){
        var x=document.getElementById("num").value;
        if(x>1){
            x=parseInt(x)-1;
           document.getElementById("num").value=x;
        }else{
            alert("购买数量不能小于1")
        }
    }
    function num_addd(){
        var x=document.getElementById("num").value;
        x=parseInt(x)+1;
        document.getElementById("num").value=x;
    }
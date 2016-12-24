/**
 * 
 */
function tj() {

	if (document.getElementById("un").value == '') {
		alert("请输入用户名");
		return false;
	}
	if (document.getElementById("psw").value == '') {
		alert("请输入密码！");
		return false;
	
	}
	document.forms[0].submit();
}
function checktxt(){
    var a=document.getElementById("un").value;
    if(a==null || a==""){
    document.getElementById("nameDiv").style.display="block";
   } else {
    document.getElementById("nameDiv").style.display="none";
  }
    
}
function checkpsw(){
    var a=document.getElementById("psw").value;
    if(a==null || a==""){
    document.getElementById("Div").style.display="block";
   } else {
    document.getElementById("Div").style.display="none";
  }
    
}



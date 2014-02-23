
<%
response.setHeader("Cache-Control","no-cache"); //HTTP 1.1
response.setHeader("Pragma","no-cache"); //HTTP 1.0
response.setDateHeader ("Expires", -1);
%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="shortcut icon" href="images/favicon.ico" />
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/ezAdvice.css" />
<script type='text/javascript'
	src='<%=request.getContextPath()%>/dwr/interface/JsAJAXController.js'></script>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/dwr/engine.js'></script>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/dwr/util.js'></script>

<style type="text/css">
.centeredImage {
	text-align: center;
	display: block;
}
</style>

<script>
	function signMeOut(){
		var http;
		if(window.XMLHttpRequest) {
			http = new XMLHttpRequest();
		}else if(window.ActiveXObject) {
			http = new ActiveXObject("Microsoft.XMLHTTP");
		}
		http.open('GET','<c:url value="/j_spring_security_logout"/>',true);
		http.send(null);
	}

	window.onbeforeunload = function(){
		if((window.event.clientX<0) || (window.event.clientY<0)){ 
			 if (window.opener && !window.opener.closed) window.opener.close();
		}
	};
	
	</script>

</head>


<body onload="javascript: signMeOut();">

	<div
		style="position: absolute; top: 50%; left: 50%; margin-top: -188px; margin-left: -275px; height: 377px; width: 560px; background-image: url(images/cmtLoginScreen.jpg); background-repeat: no-repeat;">
		<div style="position: absolute; top: 80px; left: 20px;">
			<div
				style="border-color: #bdd3ef; border-style: dashed; border-width: 1px; padding: 20px;">

				<font color="red"> Access to the specified resource (Access
					is denied) has been forbidden.<br />
				<br /> You have been SignedOut. Please close the browser and login
					again.
				</font>

			</div>
		</div>
	</div>
</body>
</html>

<!DOCTYPE html >
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html lang="en">

<head>
		<meta charset="utf-8">
		<title>Home</title>
		
		<link rel="icon" href="images/favicon.ico">		
		<link rel="shortcut icon" href="images/favicon.ico" />
		
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/camera.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/form.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/map.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/popcircle.css">
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/new.css">
		
		<script src="<%=request.getContextPath()%>/libjs/jquery.min.js"></script> <!-- also enables the concentric display -->
		<script src="<%=request.getContextPath()%>/libjs/jquery-migrate-1.1.1.min.js"></script>
		<script src="<%=request.getContextPath()%>/libjs/superfish.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/forms.js"></script>
		<script src="<%=request.getContextPath()%>/libjs/jquery.ui.totop.min.js"></script>
		<script src="<%=request.getContextPath()%>/libjs/jquery.equalheights.min.js"></script>
		<script src="<%=request.getContextPath()%>/libjs/jquery.easing.1.3.min.js"></script>
		<script src="<%=request.getContextPath()%>/libjs/jquery.ui.totop.min.js"></script>
		<script src="<%=request.getContextPath()%>/libjs/tms-0.4.1.min.js"></script>
		
		<script src="<%=request.getContextPath()%>/libjs/path.js"></script>

		
		<script>
		
		window.onload = function() {   // the code to bring up concentric circles is here -- Sudeep
			 
			$("html, body").scrollTop(0);
		    $('#radar').html('<div id="circle1"></div><div id="circle2"></div><div id="circle3"></div><div id="circle4"></div><div id="circle5"></div>');
		    $('#radar').fadeIn();
		    
		    $("#circle1")
		    .animate({height: "hide", width: "hide"}, 5000, "easeOutElastic")
		    .animate({height: "show", width: "show"}, 6000, "easeInElastic");
		     
		     $("#circle2")
		    .animate({height: "hide", width: "hide"}, 4000, "easeOutElastic")
		    .animate({height: "show", width: "show"}, 5000, "easeInElastic");
		     
		     $("#circle3")
		    .animate({height: "hide", width: "hide"}, 3000, "easeOutElastic")
		    .animate({height: "show", width: "show"}, 4000, "easeInElastic");
		     
		     $("#circle4")
		    .animate({height: "hide", width: "hide"}, 2000, "easeOutElastic")
		    .animate({height: "show", width: "show"}, 3000, "easeInElastic");
		     
		    $("#circle5")
		    .animate({height: "hide", width: "hide"}, 1000, "easeOutElastic")
		    .animate({height: "show", width: "show"}, 2000, "easeInElastic");
		     		    
		    
		    $('#circle1').delay(0).show(function () {
		    	addPeople($(this), 17, 22);
		    	}); 
		    $('#circle2').delay(500).show(function () {
		    	addPeople($(this), 9, 16);
		    	});
		    $('#circle3').delay(700).show(function () {
		    	addPeople($(this), 4, 8);
		    	});
		    $('#circle4').delay(900).show(function () {
		    	addPeople($(this), 0, 3);
		    	});

		    function addPeople(parent,objStart, objStop){
		    	
		    	 var radius = parent.height()/2;
		    	 var start = Math.floor(Math.random() * 360) + 1;
		    	 var rand = Math.floor(Math.random() * 100) + 1;
		    	 var count = 0; 
		    	 for (var i = objStart; i < (objStop+1); i++) {
		    		 
		    		 parent.append('<div id="person_'+i+'_'+rand+'" style="left:'+radius+'px;top:'+(radius*2)+'px; background:white url(images/LeeArmstrong_small.jpg) no-repeat scroll 0% 0%;" class="person"></div>');
		    		 
		    		 var arc_params = {
		    				 center: [radius,radius],
		    				 radius: radius,
		    				 start: 0,
		    				 end: (360/(objStop-objStart+1)*count)+Math.floor(Math.random()*40)+1,
		    				 dir: -1
		    		} 
		    		$('#person_'+i+'_'+rand).fadeIn(1000).animate({path : new $.path.arc(arc_params)}, 3000);
		    		 
		    		 $('#person_'+i+'_'+rand).hover( function () {
		    			 
		    			 var posTop = $(this).context.offsetTop-10;
		    			 var posLeft = $(this).context.offsetLeft; 
		    			 var name='Sankar Vikram';
		    			 var car='Login Here';
		    			 
		    			 $(this).parent().append('<div id="hoverinfo_'+i+'_'+rand+'" class="hoverinfo" style="top:'+(posTop)+'px;left:'+(posLeft)+'px;"><div class="inner"><p class="name">'+name+'</p><p class="model">'+car+'</p></div></div>'); 
		    			 
		    			 $('#hoverinfo_'+i+'_'+rand).hide().fadeIn();
		    		 }, function () {
		    		 $('#hoverinfo_'+i+'_'+rand).fadeOut(400).delay(400).remove();
		    		 }); 
		    		 
		    		 $('#person_'+i+'_'+rand).click( function () {
		                  openProfile();
		            });
		    		 
		    		count ++; 
		    	 }
		    	
		    }				    
		   
		  function openProfile(){
			  $("html, body").scrollTop(0);
		        $('#profile-image').html('<img src="images/DongGilKo.jpg" />');
		         $('#profile-name').html('Dr. Ko');
		        $('#radar').fadeOut();
		        $('#profile').delay(500).fadeIn();
		       
		  }		    
		    
		}	// window.onload close
		
		  function backToMap(){
		        $('#profile').fadeOut();
		       
		         $('#radar').delay(500).fadeIn();
		  }
		
		
			$(document).ready(function(){
				$('.slider_wrapper')._TMS({
					show:0,
					pauseOnHover:false,
					prevBu:'.prev',
					nextBu:'.next',
					playBu:false,
					duration:800,
					preset:'fade',
					pagination:true,//'.pagination',true,'<ul></ul>'
					pagNums:false,
					slideshow:8000,
					numStatus:false,
					banners: 'fade',
					waitBannerAnimation:false,
					progressBar:false
				});
			});
			$(document).ready(function(){
				!function(){
			var map=[]
			 ,names=[]
			 ,win=$(window)
			 ,header=$('header')
			 ,currClass
			$('.content').each(function(n){
			 map[n]=this.offsetTop
			 names[n]=$(this).attr('id')
			})
			win
			 .on('scroll',function(){
				var i=0
				while(map[i++]<=win.scrollTop());
				if(currClass!==names[i-2])
				currClass=names[i-2]
				header.removeAttr("class").addClass(names[i-2])
			 })
			}(); });
					function goToByScroll(id){
				$('html,body').animate({scrollTop: $("#"+id).offset().top},'slow');
				}
				$(document).ready(function(){
					$().UItoTop({ easingType: 'easeOutQuart' });
				});
		</script>
		
	</head>
	<body class="">
<!--==============================header=================================-->
		<header class="page1">
			<div class="container_12">
				<div class="grid_12">
				<!--<h1><a href="#" onClick="goToByScroll('page1'); return false;"><img src="images/logo.png" alt="Gerald Harris attorney at law"></a></h1> -->
					<div class="menu_block">
						<nav class="">
							<ul class="sf-menu">
								<li class="current men"><a onClick="goToByScroll('page1'); return false;" href="#">Home</a> <strong class="hover"></strong></li>
								<li class="men1"><a onClick="goToByScroll('page2'); return false;" href="#">Academics</a><strong class="hover"></strong></li>
								<li class=" men2"><a onClick="goToByScroll('page3'); return false;" href="#">Planning</a> <strong class="hover"></strong></li>
								<li class=" men3"><a onClick="goToByScroll('page4'); return false;" href="#">Traveling</a> <strong class="hover"></strong></li>
								<li class=" men4"><a onClick="goToByScroll('page5'); return false;" href="#">Experiences</a> <strong class="hover"></strong></li>
							</ul>
						</nav>
						<div class="clear"></div>
					</div>
					<div class="menu_block1">
						<nav class="">
							<ul class="sf-menu">
								<li class=""><a onClick="" href="#">Register</a> <strong class="hover"></strong></li>
								<li class=""><a onClick="" href="#">Log In</a> <strong class="hover"></strong></li>
							</ul>
						</nav>					
					</div>
				</div>
				<div class="clear"></div>
			</div>
		</header>
<!--=======content================================-->
		<div id="page1" class="content">
			<div class="ic"></div>
			<!--=======New content - Sudeep test================================-->
	<div id="profile" style="display: none;">
      <div id="profile-back" onclick="backToMap();">Go back</div>
     
      <div id="profile-holder">
            <div id="profile-image"></div>
            <br><br>
            <div id="profile-info">
                  <div id="profile-name"></div>
                  <div id="profile-buttons">                 
                       <h4 style="color: black;"> Username: <input type="text" name="username"></h4><br>
                       <h4 style="color: black;"> Password: <input type="text" name="password"></h4>
                         <input type="submit" value="Submit">
                  </div>
            </div>
     
      </div>
	</div>				
			
			<div id="radar">
<!-- 			<div id="circle1" style="display: block;"></div> -->
<!-- <div id="circle2" style="display: block;"></div> -->
<!-- <div id="circle3" style="display: block;"></div> -->
<!-- <div id="circle4" style="display: block;"></div> -->
<!-- <div id="circle5" style="display: block;"></div> -->
			</div>
			
			
			<!--=======old content================================-->
<!-- 			<div class="container_12"> -->
<!-- 				<div class="grid_12"> -->
<!-- 					<div class="slider_wrapper"> -->
<!-- 						<ul class="items"> -->
<!-- 							<li> -->
<!-- 								<img src="images/spacer.gif" alt=""> -->
<!-- 								<div class="caption banner"> -->
<!-- 									<h2>Let Us Show You the Way to Success</h2> -->
<!-- 								</div> -->
<!-- 							</li> -->
<!-- 							<li> -->
<!-- 								<img src="images/spacer.gif" alt=""> -->
<!-- 								<div class="caption banner"> -->
<!-- 									<h2>Interminable Energy for Your Project</h2> -->
<!-- 								</div> -->
<!-- 							</li> -->
<!-- 							<li> -->
<!-- 								<img src="images/spacer.gif" alt=""> -->
<!-- 								<div class="caption banner"> -->
<!-- 									<h2>We know how to solve your problems!</h2> -->
<!-- 								</div> -->
<!-- 							</li> -->
<!-- 							<li> -->
<!-- 								<img src="images/spacer.gif" alt=""> -->
<!-- 								<div class="caption banner"> -->
<!-- 									<h2>Make your business a booming one!</h2> -->
<!-- 								</div> -->
<!-- 							</li> -->
<!-- 						</ul> -->
<!-- 					</div> -->
<!-- 					<div class="socials"> -->
<!-- 						<a href="#"></a> -->
<!-- 						<a href="#"></a> -->
<!-- 						<a href="#"></a> -->
<!-- 						<a href="#"></a> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
		</div>
		<div id="page2" class="content">
			<div class="container_12">
				<div class="grid_12">
<!-- 					<div class="slogan"> -->
<!-- 						<h3>Only Professional <a onClick="goToByScroll('page3'); return false;" href="#"><span>Services</span></a> for Our <a onClick="goToByScroll('page4'); return false;" href="#"><em>Clients</em></a></h3> -->
<!-- 						<div class="text1"> -->
<!-- 							<a href="http://blog.templatemonster.com/free-website-templates/" rel="nofollow" class="tm_link"> Click here</a> for more info about this free website template created by TemplateMonster.com <br> Lorem ipsum dolor sit amet, consectetur adipiscing elit. In mollis erat mattis neque facilisis, sit amet ultricies -->
<!-- 						</div> -->
<!-- 					</div> -->
				</div>
				<div class="grid_3">
					<div class="box maxheight">
						<img src="images/DongGilKo.jpg" alt="" width="150px" height="150px">
						<div class="text1"><a href="#">Dr. Dong-Gil Ko</a></div>Associate Professor
<!-- 						<div class="socials1"> -->
<!-- 							<a href="#"></a> -->
<!-- 							<a href="#"></a> -->
<!-- 							<a href="#"></a> -->
<!-- 							<a href="#"></a> -->
<!-- 						</div> -->
					</div>
				</div>
				<div class="grid_3">
					<div class="box maxheight">
						<img src="images/LeeArmstrong.jpg" alt="" width="150px" height="150px">
						<div class="text1"><a href="#">Ms. Lee Armstrong</a></div>Associate Director
<!-- 						<div class="socials1"> -->
<!-- 							<a href="#"></a> -->
<!-- 							<a href="#"></a> -->
<!-- 							<a href="#"></a> -->
<!-- 							<a href="#"></a> -->
<!-- 						</div> -->
					</div>
				</div>
				<div class="grid_3">
					<div class="box maxheight">
						<img src="images/avt_female.jpg" alt="" width="150px" height="150px">
						<div class="text1"><a href="#">Ms. FName LName </a></div>Co-Ordinator 2
<!-- 						<div class="socials1"> -->
<!-- 							<a href="#"></a> -->
<!-- 							<a href="#"></a> -->
<!-- 							<a href="#"></a> -->
<!-- 							<a href="#"></a> -->
<!-- 						</div> -->
					</div>
				</div>
				<div class="grid_3">
					<div class="box maxheight">
						<img src="images/avt_male.jpg" alt="" width="150px" height="150px">
						<div class="text1"><a href="#">Mr. FName LName</a></div>Co-Ordinator 3
<!-- 						<div class="socials1"> -->
<!-- 							<a href="#"></a> -->
<!-- 							<a href="#"></a> -->
<!-- 							<a href="#"></a> -->
<!-- 							<a href="#"></a> -->
<!-- 						</div> -->
					</div>
				</div>
			</div>
		</div>
		<div id="page3" class="content">
			<div class="container_12">
			
			<!-- Sudeep - Login section -->
			
			<div style="margin: 0% 15% 0% 15%; width: 70%; height: 680px; border: 1px solid #808080;">
			<div align="center">
			<div style="margin: 10px;">
				<form name="f" action="<c:url value='j_spring_security_check'/>" method="post" autocomplete="off">
					<div>
						<table>
							<tr>
								<td width="75px" align="left" style="font-weight: bold;">User Name</td>
								<td><input type='text' id='username' style="width: 180px" size="14" name='j_username'
										value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/>
								</td>
							</tr>
							<tr>
								<td width="75px" align="left" style="font-weight: bold;">Password</td>
								<td><input type='password' id='password' style="width: 180px" size="14" name='j_password' />
								</td>
							</tr>
							<tr>
								<td align="right"><input name="Login" type="submit" value="Login" /></td>
							</tr>
						</table>
					</div>
				</form>
			</div>
			<div style="margin: 10px;">
				<c:if test="${not empty param.login_error}">
					<font color="red">
						<c:if test="${param.login_error == 1}">
	       					Your login attempt was not successful, try again.
	       					<br />
	       					Reason: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}" />.
	     					</c:if>
						<c:if test="${param.login_error == 2}">
	       					Session timed out. Please login again.
						</c:if>
						<c:if test="${param.login_error == 3}">
	       					You have either selected wrong Role or you are not authorized to view this page.
						</c:if>
						<c:if test="${param.login_error == 4}">
	       					You have already logged in another system/browser.
						</c:if>
						<c:if test="${param.login_error == 5}">
	       					Server is busy. Please try to login after sometime.
						</c:if>
					</font>
				</c:if>
			</div>
		</div>
	</div>
			
			
		
<!-- 				<div class="grid_12"> -->
<!-- 					<div class="slogan"> -->
<!-- 						<h3>Our Services</h3> -->
<!-- 						<div class="text1"> -->
<!-- 							Vivamus at magna non nunc tristique rhoncus. Aliquam nibh ante, egestas id dictum a, commodo luctus libero. Praesent faucibus malesuada faucibus. Donec laoreet metus id laoreet malesuada. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam consectetur orci sed nulla facilisis consequat. Curabitur vel lorem sit amet nulla ullamcorper fermentum.  Lorem ipsum dolor sit amet, consectetur adipiscing elit. -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="grid_3"> -->
<!-- 					<div class="box maxheight1"> -->
<!-- 						<img src="images/box1_img1.png" alt=""> -->
<!-- 						<div class="text1"><a href="#">Strategy</a></div>Vivamus at magna non nunc tristique rhoncus. Aliquam nibh ante, egestas id dictum a, commodo luctus libero. -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="grid_3"> -->
<!-- 					<div class="box maxheight1"> -->
<!-- 						<img src="images/box1_img2.png" alt=""> -->
<!-- 						<div class="text1"><a href="#">Research</a></div>Ite auctor non pellentesque vel, aliquet sit amet erat. Nullam eget dignissim nisi, aliquam feugiat nibhh sagittis ut. -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="grid_3"> -->
<!-- 					<div class="box maxheight1"> -->
<!-- 						<img src="images/box1_img3.png" alt=""> -->
<!-- 						<div class="text1"><a href="#">Development</a></div>Praesent faucibusamus ater asmagna non nunc tristique rhoncus. Aliquam nib ante, tas id dictum aluctus libero. -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 				<div class="grid_3"> -->
<!-- 					<div class="box maxheight1"> -->
<!-- 						<img src="images/box1_img4.png" alt=""> -->
<!-- 						<div class="text1"><a href="#">Consulting</a></div>Etiam dui eros na non nunc tristique rhoncus. Aliquam nibh ante, egestas id dictum a commodo luctus libero. -->
<!-- 					</div> -->
<!-- 				</div> -->
			</div>
		</div>
		<div id="page4" class="content">
			<div class="container_12">
<!-- 				<div class="grid_12"> -->
<!-- 					<h3>Our Clients</h3> -->
<!-- 				</div> -->
<!-- 				<div class="companies"> -->
<!-- 					<div class="grid_3"> -->
<!-- 						<img src="images/logo1.jpg" alt=""> -->
<!-- 						<div class="text1">Company Name</div>Aliquam nibh ante, egestas id dictum  wrecommodo luctus liberoaesent. -->
<!-- 						<br> -->
<!-- 						<a href="#">Go to Site</a> -->
<!-- 					</div> -->
<!-- 					<div class="grid_3"> -->
<!-- 						<img src="images/logo2.jpg" alt=""> -->
<!-- 						<div class="text1">Company Name</div>Fusce adipiscing quam id risus gittis, non consequat lacus interdumoin. -->
<!-- 						<br> -->
<!-- 						<a href="#">Go to Site</a> -->
<!-- 					</div> -->
<!-- 					<div class="grid_3"> -->
<!-- 						<img src="images/logo3.jpg" alt=""> -->
<!-- 						<div class="text1">Company Name</div>Quisque viverra nulla nunc, eu ultrices wertlibero ultricies egetasellus um. -->
<!-- 						<br> -->
<!-- 						<a href="#">Go to Site</a> -->
<!-- 					</div> -->
<!-- 					<div class="grid_3"> -->
<!-- 						<img src="images/logo4.jpg" alt=""> -->
<!-- 						<div class="text1">Company Name</div>Courrewerwe abitur vel lorem sit amet ulla ullamcorper fermentumn vitae. -->
<!-- 						<br> -->
<!-- 						<a href="#">Go to Site</a> -->
<!-- 					</div> -->
<!-- 					<div class="clear"></div> -->
<!-- 					<div class="grid_3"> -->
<!-- 						<img src="images/logo5.jpg" alt=""> -->
<!-- 						<div class="text1">Company Name</div>Oiliquam nibh ante, egestas id dictum  wrecommodo luctus liberoaesente. -->
<!-- 						<br> -->
<!-- 						<a href="#">Go to Site</a> -->
<!-- 					</div> -->
<!-- 					<div class="grid_3"> -->
<!-- 						<img src="images/logo6.jpg" alt=""> -->
<!-- 						<div class="text1">Company Name</div>Gusce adipiscing quam id risus gittis, non consequat lacus interdumoiju. -->
<!-- 						<br> -->
<!-- 						<a href="#">Go to Site</a> -->
<!-- 					</div> -->
<!-- 					<div class="grid_3"> -->
<!-- 						<img src="images/logo7.jpg" alt=""> -->
<!-- 						<div class="text1">Company Name</div>Niuisque viverra nulla nunc, eu ultrices wertlibero ultricies egetasellus ol. -->
<!-- 						<br> -->
<!-- 						<a href="#">Go to Site</a> -->
<!-- 					</div> -->
<!-- 					<div class="grid_3"> -->
<!-- 						<img src="images/logo8.jpg" alt=""> -->
<!-- 						<div class="text1">Company Name</div>Fouerourrewerwe abitur vel lorem sit amet ulla ullamcorper fermentum. -->
<!-- 						<br> -->
<!-- 						<a href="#">Go to Site</a> -->
<!-- 					</div> -->
<!-- 				</div> -->
			</div>
		</div>
		<div id="page5" class="content">
			<div class="container_12">
				<div class="grid_12">
					<div class="slogan">
						<h3>Get in Touch</h3>
						<div class="text1">
							Gyrto ivamus at magna non nunc tristique rhoncusu. Lliquam nibh ante, egestas id dictum a, commodo luctus mibero. Praesent faucibus malesuada faucibu. Monec laoreet metus id laoreet malesuadw.
						</div>
					</div>
				</div>
				<div class="clear"></div>
				<div class="map">
					<div class="grid_3">
						<div class="text1">Address</div>
						<address>
							<dl>
								<dt>The Company Name Inc.<br>
								8901 Marmora Road,<br>
								Glasgow, D04 89GR.
								</dt>
								<dd><span>Freephone:</span>+1 800 559 6580</dd>
								<dd><span>Telephone:</span>+1 800 603 6035</dd>
								<dd><span>FAX:</span>+1 800 889 9898</dd>
								<dd>E-mail: <a href="#" class="link-1">mail@demolink.org</a></dd>
								<dd>Skype: <a href="#" class="link-1">@skypename</a></dd>
							</dl>
						</address>
					</div>
					<div class="grid_3">
						<div class="text1">&nbsp;</div>
						<figure class="">
							<iframe src="http://maps.google.com/maps?f=q&amp;source=s_q&amp;hl=en&amp;geocode=&amp;q=Brooklyn,+New+York,+NY,+United+States&amp;aq=0&amp;sll=37.0625,-95.677068&amp;sspn=61.282355,146.513672&amp;ie=UTF8&amp;hq=&amp;hnear=Brooklyn,+Kings,+New+York&amp;ll=40.649974,-73.950005&amp;spn=0.01628,0.025663&amp;z=14&amp;iwloc=A&amp;output=embed"></iframe>
						</figure>
					</div>
					<div class="grid_5 prefix_1">
						<div class="text1">Ask a Question</div>
						<form id="form">
						<div class="success_wrapper">
						<div class="success">Contact form submitted!<br>
						<strong>We will be in touch soon.</strong> </div></div>
						<fieldset>
						<label class="name">
						<input type="text" value="Name:">
						<br class="clear">
						<span class="error error-empty">*This is not a valid name.</span><span class="empty error-empty">*This field is required.</span> </label>
						<label class="email">
						<input type="text" value="E-mail:">
						<br class="clear">
						<span class="error error-empty">*This is not a valid email address.</span><span class="empty error-empty">*This field is required.</span> </label>
						<label class="message">
						<textarea>Message:</textarea>
						<br class="clear">
						<span class="error">*The message is too short.</span> <span class="empty">*This field is required.</span> </label>
						<div class="clear"></div>
						<div class="btns"><a data-type="submit" class="link1">Send</a>
						<div class="clear"></div>
						</div></fieldset></form>
					</div>
					<div class="clear"></div>
				</div>
			</div>
		</div>
<!--==============================footer=================================-->
		<footer>
			<div class="container_12">
				<div class="grid_12">
<!-- 					<div class="copy"> -->
<!-- 						<a onClick="goToByScroll('page1'); return false;" href="#"><img src="images/footer_logo.png" alt=""></a>  -->
<!-- 						 &copy; 2013 |  -->
<!-- 						 <a href="#">Privacy Policy</a>  -->
<!-- 						 <br> Website designed by  -->
<!-- 						 <a href="http://www.templatemonster.com/" rel="nofollow">TemplateMonster.com</a> -->
<!-- 					</div> -->
				</div>
				<div class="clear"></div>
			</div>
		</footer>
	</body>
</html>




<body onload="document.f.j_username.focus();">
	
</body>


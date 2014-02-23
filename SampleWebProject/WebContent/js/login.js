function onloadFunc() {   // the code to bring up concentric circles is here -- Sudeep
			 
			$("html, body").scrollTop(0);
		    $('#radar').html('<div id="circle1"></div><div id="circle2"></div><div id="circle3"></div><div id="circle4"></div><div id="circle5"></div>');
		    $('#radar').fadeIn();
		    
		    $("#circle1")
		    .animate({height: "hide", width: "hide"}, 5000, "easeOutElastic")
		    .animate({height: "show", width: "show"}, 6000, "easeOutBounce");
		     
		     $("#circle2")
		    .animate({height: "hide", width: "hide"}, 4000, "easeOutElastic")
		    .animate({height: "show", width: "show"}, 5000, "easeOutBounce");
		     
		     $("#circle3")
		    .animate({height: "hide", width: "hide"}, 3000, "easeOutElastic")
		    .animate({height: "show", width: "show"}, 4000, "easeOutBounce");
		     
		     $("#circle4")
		    .animate({height: "hide", width: "hide"}, 2000, "easeOutElastic")
		    .animate({height: "show", width: "show"}, 3000, "easeOutBounce");
		     
		    $("#circle5")
		    .animate({height: "hide", width: "hide"}, 1000, "easeOutElastic")
		    .animate({height: "show", width: "show"}, 2000, "easeOutBounce");
		     		    
		    
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
		    		 
		    		 parent.append('<div id="person_'+i+'_'+rand+'" style="left:'+radius+'px;top:'+(radius*2)+'px; background:white url(<%=request.getContextPath()%>/images/LeeArmstrong_small.jpg) no-repeat scroll 0% 0%;" class="person"></div>');
		    		 
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
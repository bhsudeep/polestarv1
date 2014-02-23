<!DOCTYPE html >
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
	<head>
		<title>Prologue by HTML5 UP</title>
      <meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<meta name="description" content="" />
		<meta name="keywords" content="" />
		
		<link href="http://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600" rel="stylesheet" type="text/css" />
		<!--[if lte IE 8]><script src="js/html5shiv.js"></script><![endif]-->
		
		<!-- add scripts -->
		<script src="<%=request.getContextPath()%>/js/jquery.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/jquery.Jcrop.min.js"></script>
		<script src="<%=request.getContextPath()%>/libjs/jquery.validate.min.js"></script>
		<%-- <script src="<%=request.getContextPath()%>/js/scriptImgUpload.js"></script> --%>
		
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/cssImgUpload.css"  type="text/css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/jquery.Jcrop.min.css"  type="text/css" />
	
		<script src="<%=request.getContextPath()%>/js/skel.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/skel-panels.min.js"></script>
		<script src="<%=request.getContextPath()%>/js/init_registration.js"></script>
		
		
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/skel-noscript.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style-wide.css" />
		
		<script>
		
		(function($,W,D) {    
			var jqueryObj = {};     
			
			jqueryObj.UTIL =     
			{         
					setupFormValidation: function()         
					{             
						//form validation rules             
						$("#registrationForm").validate({                 
							rules: {                     
								fullName: "required",                     
								nickName: "required",                     
								email: {                         
									required: true,                         
									email: true                     
									},                     
									password: {                         
										required: true,                         
										minlength: 8                     
										},                     
										agree: "required"                 
										},                 
							messages: {                     
								fullName: "Please enter your firstname",                     
								nickName: "Please enter your lastname",                     
								password: {                         
									required: "Please provide a password",                         
									minlength: "Your password must be at least 8 characters long"                     
									},                     
									email: "Please enter a valid email address",                     
									},                 
							submitHandler: function(form) {                     
								form.submit();                 
								}             
							});         
						}     
			};     
			//when the dom has loaded setup form validation rules     
			// Make this function on ready
			$(document).on("click", "a", function() {         
				jqueryObj.UTIL.setupFormValidation();     
				}); })(jQuery, window, document);
		
		
/* 		function registration(){
			//TODO: DATA VALIDATION
			if(document.registrationForm){
				document.registrationForm.submit();				
			}				
		} */
		
		
		/**
		 *
		 * HTML5 Image uploader with Jcrop
		 *
		 * Licensed under the MIT license.
		 * http://www.opensource.org/licenses/mit-license.php
		 */

		// convert bytes into friendly format
		function bytesToSize(bytes) {
		    var sizes = ['Bytes', 'KB', 'MB'];
		    if (bytes == 0) return 'n/a';
		    var i = parseInt(Math.floor(Math.log(bytes) / Math.log(1024)));
		    return (bytes / Math.pow(1024, i)).toFixed(1) + ' ' + sizes[i];
		};

		// check for selected crop region
		function checkForm() {
		    if (parseInt($('#w').val())) return true;
		    $('.error').html('Please select a crop region and then press Upload').show();
		    return false;
		};

		// update info by cropping (onChange and onSelect events handler)
		function updateInfo(e) {
		    $('#x1').val(e.x);
		    $('#y1').val(e.y);
		    $('#x2').val(e.x2);
		    $('#y2').val(e.y2);
		    $('#w').val(e.w);
		    $('#h').val(e.h);
		};

		// clear info by cropping (onRelease event handler)
		function clearInfo() {
		    $('.info #w').val('');
		    $('.info #h').val('');
		};

		function fileSelectHandler() {

		    // get selected file
		    var oFile = $('#image_file')[0].files[0];

		    // hide all errors
		    $('.error').hide();

		    // check for image type (jpg and png are allowed)
		    var rFilter = /^(image\/jpeg|image\/png)$/i;
		    if (! rFilter.test(oFile.type)) {
		        $('.error').html('Please select a valid image file (jpg and png are allowed)').show();
		        return;
		    }

		    // check for file size
		    if (oFile.size > 1024 * 1024) {
		        $('.error').html('You have selected too big file, please select a one smaller image file').show();
		        return;
		    }

		    // preview element
		    var oImage = document.getElementById('preview');

		    // prepare HTML5 FileReader
		    var oReader = new FileReader();
		        oReader.onload = function(e) {

		        // e.target.result contains the DataURL which we can use as a source of the image
		        oImage.src = e.target.result;
		        oImage.onload = function () { // onload event handler

		            // display step 2
		            $('.step2').fadeIn(500);

		            // display some basic image info
		            var sResultFileSize = bytesToSize(oFile.size);
		            $('#filesize').val(sResultFileSize);
		            $('#filetype').val(oFile.type);
		            $('#filedim').val(oImage.naturalWidth + ' x ' + oImage.naturalHeight);

		            // Create variables (in this scope) to hold the Jcrop API and image size
		            var jcrop_api, boundx, boundy;

		            // destroy Jcrop if it is existed
		            if (typeof jcrop_api != 'undefined') 
		                jcrop_api.destroy();

		            // initialize Jcrop
		            $('#preview').Jcrop({
		                minSize: [32, 32], // min crop size
		                aspectRatio : 1, // keep aspect ratio 1:1
		                bgFade: true, // use fade effect
		                bgOpacity: .3, // fade opacity
		                onChange: updateInfo,
		                onSelect: updateInfo,
		                onRelease: clearInfo
		            }, function(){

		                // use the Jcrop API to get the real image size
		                var bounds = this.getBounds();
		                boundx = bounds[0];
		                boundy = bounds[1];

		                // Store the Jcrop API in the jcrop_api variable
		                jcrop_api = this;
		            });
		        };
		    };

		    // read selected file as DataURL
		    oReader.readAsDataURL(oFile);
		}
		
		</script>
		
		
	</head>
	<body>			
		<section id="contact" class="four">
			<div class="container">

				<header>
					<h2 align="center">Registration Form</h2>
				</header>

								
				<form:form method="POST" action="addStudent.do" name="registrationForm" id="registrationForm" commandName="registrationForm" enctype="multipart/form-data" >
					 <!-- hidden crop params -->
                    <form:input type="hidden" id="x1" name="x1" path="x1" />
                    <form:input type="hidden" id="y1" name="y1" path="y1" />
                    <form:input type="hidden" id="x2" name="x2" path="x2" />
                    <form:input type="hidden" id="y2" name="y2" path="y2" />
				
					
					<div class="row">
						<div class="3u">&nbsp;</div>
							<div class="6u" ><form:input type="text" class="text" name="email"  path="email" placeholder="Email" /></div>
						    <div class="3u"></div>									
					</div>
					
					<div class="row">
						
							<div class="6u" ><form:input type="password" class="text" name="password"  path="password" placeholder="Password" /></div>
							<div class="6u" ><input type="password" class="text" name="passwordConfirm"  placeholder="Confirm Password" /></div>
					</div>
					
					<div class="row">
						
							<div class="6u" ><form:input type="text" class="text" name="fullName" path="fullName" placeholder="Full Name" /></div>
							<div class="6u" ><form:input type="text" class="text" name="nickName" path="nickName" placeholder="Nick Name" /></div>
					</div>
					
					<div class="row">
						
							<div class="6u" >
								<input type="radio" name="gender" value="male">Male
							<input type="radio" name="gender" value="female">Female
						</div>
						    <div class="6u"></div>									
					</div>
					
					<div class="row">						
							<div class="6u" ><form:input type="text" class="text" name="major" path="major" placeholder="Major" /></div>
							<div class="6u" ><input type="text" class="text" name="expectedGraduationDate" placeholder="Expected Graduation(mm/yyyy)" /></div>					   								
					</div>
					
					<div class="row">							
							<div class="6u" ><form:input type="text" class="text" name="blogLink" path="blogLink" placeholder="Blog Link" /></div>
							<div class="6u" ><form:input type="text" class="text" name="favIcecream" path="favIcecream" placeholder="Favorite Ice Cream" /></div>					    									
					</div>
					
					<div class="row">	
							<div class="6u" ><form:input type="text" class="text" name="birthPlace" path="birthPlace" placeholder="Birth Place (City, Country)" /></div>
							<div class="6u" ><form:input type="text" class="text" name="language" path="language" placeholder="Languages(separate by comma)" /></div>
					</div> <br/>
			
					<h4>Step1: Please select image file for upload</h4>
                    <div class="6u"><form:input type="file" name="image_file" id="image_file" path="image_file" onchange="fileSelectHandler()" /></div><br/>
					
					<div class="error"></div>
					
					<div class="step2">
                        <h4>Step2: Please select a crop region</h4>
                        <img id="preview" />
						
						<div class="info">
						<div class="row">
                       
                           <div class="2u" > <label>File size</label><input type="text" id="filesize" name="filesize" /> </div>
                           <div class="2u" > <label>Type</label><form:input type="text" id="filetype" name="filetype" path="filetype" /> </div>
                           <div class="2u" > <label>Image dimension</label><input type="text" id="filedim" name="filedim" /> </div>
                           <div class="2u" > <label>Width</label> <form:input type="text" id="w" name="w" path="w" /></div>
                           <div class="2u" > <label>Height</label> <form:input type="text" id="h" name="h" path="h" /></div>
                        </div>
                        </div>
                    </div> <br/>
					
					<div class="row">
							<div class="4u">&nbsp;</div>
							<div class="4u"><a href="#" class="button submit"  onclick="javascript:registration()">Submit Form</a></div>
						    <div class="4u"></div>									
					</div>
				</form:form>
			</div>
		</section>
	</body>
</html>
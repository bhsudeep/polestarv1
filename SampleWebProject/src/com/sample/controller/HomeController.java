package com.sample.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sample.domain.TbUser;
import com.sample.service.StudentService;

@Controller
public class HomeController {

	private static final Logger LOGGER = Logger.getLogger(HomeController.class);
	private static final String ENTRYLOGGER = "Entering " + HomeController.class.getName();
	private static final String EXITLOGGER = "Exiting " + HomeController.class.getName();
	
	@Autowired
	private StudentService studentService;

	@RequestMapping("/home")
	public ModelAndView home(Map model, HttpServletRequest request) {
		if (LOGGER.isDebugEnabled()) {
			LOGGER.debug(ENTRYLOGGER + " home");
		}
		
		UserDetails principal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		/*if (principal instanceof UserDetails) {
		  String username = ((UserDetails)principal).getUsername();
		  string role = 
		} else {
		  String username = principal.toString();
		}*/
		
		ModelAndView modelAndView = null;
		
		System.out.println("Username : "+principal.getUsername());		
		System.out.println("Role : "+principal.getAuthorities().toString());
		
		String role = principal.getAuthorities().toString();
		String username = principal.getUsername();
		
		if(role.equalsIgnoreCase("[ROLE_STUDENT]")){
			
			// creating a student specific model
			modelAndView = new ModelAndView("student");	
			
			//retreiving student information based on the username
			TbUser studentUser = studentService.getStudentDetailsByUsername(username);
			
			// adding the student details to the model objects
			modelAndView.addObject("STUDENT_DATA",studentUser);
			
					
		} else if(role.equalsIgnoreCase("[ROLE_ADMINISTRATOR]")){			
			modelAndView = new ModelAndView("admin");			
		} else 
			return null;		
		
		/*request.setAttribute("BREAD_CRUMB", "<img src='images/homedef.png'> Web Services");*/		
		/*modelAndView = new ModelAndView("home");*/
		
		return modelAndView;
	}	
	
}

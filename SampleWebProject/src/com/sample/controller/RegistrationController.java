package com.sample.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.sample.form.StudentRegistrationForm;
import com.sample.service.StudentService;

@Controller
public class RegistrationController {

	private static final Logger LOGGER = Logger.getLogger(RegistrationController.class);
	private static final String ENTRYLOGGER = "Entering " + RegistrationController.class.getName();
	private static final String EXITLOGGER = "Exiting " + RegistrationController.class.getName();
	
	@Autowired
	private StudentService studentService;	
	

	 public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	   @RequestMapping(value = "/register", method = RequestMethod.GET)
	   public ModelAndView register() {
	      return new ModelAndView("register", "registrationForm", new StudentRegistrationForm());
	   }
	   
	   @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	   public void addStudent(@ModelAttribute("SpringWeb")StudentRegistrationForm studentForm, ModelMap model) {
		   studentService.addStudent(studentForm);
	   }

	
}

package com.sample.service;

import com.sample.domain.TbUser;
import com.sample.form.StudentRegistrationForm;

public interface StudentService {

	public TbUser  getStudentDetailsByUsername(String username);

	public void addStudent(StudentRegistrationForm studentForm);
	
}

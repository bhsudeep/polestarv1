package com.sample.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.dao.StudentDAO;
import com.sample.domain.TbUser;
import com.sample.form.StudentRegistrationForm;

@Component("studentService")  // to be found out
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDAO studentDAO;
	
	
	public TbUser getStudentDetailsByUsername(String username) {
		
		return studentDAO.getStudentDetailsByUsername(username);
	}


	@Override
	public void addStudent(StudentRegistrationForm studentForm) {
		//create a empty user object
		TbUser newUser = new TbUser();
		
		//set the newly created user object with the data in the registration form object
		newUser.setUsrStrFirstName(studentForm.getFullName());
		newUser.setUsrStrBlog(studentForm.getBlogLink());
		newUser.setUsrStrUserName(studentForm.getEmail());
		
		
		// Code to crop the image based on the co-ordinates selected using jCrop during the new student registration
		InputStream inputStream = null;
		BufferedImage image = null;
		ByteArrayOutputStream byteArrayOutputStream =  new ByteArrayOutputStream();
		
		if(studentForm.getImage_file().getSize() > 0) {
			try {
				inputStream = studentForm.getImage_file().getInputStream();
				image = ImageIO.read(inputStream);
				
				//Get the cropped image
			    BufferedImage croppedImage = image.getSubimage(studentForm.getX1(),studentForm.getY1(),studentForm.getW(),studentForm.getH());
				
			    // Write the cropped image into a ByteOutputStream
			    ImageIO.write(croppedImage, "jpg", byteArrayOutputStream);
			    
			    //from the ByteOutputStream obtain the byte[] typed image and store it in the newUser object
			    newUser.setImgUserImage(byteArrayOutputStream.toByteArray());
			    
			    //closing the streams as methods dont take care of them explicitly
			    inputStream.close();
			    byteArrayOutputStream.close();
			    System.out.println("Image cropped successfully");
			} catch (IOException e) {
				System.out.println("Error while cropping the image");
				e.printStackTrace();
			}
		}
		
		
		// send the user object for saving
		studentDAO.addNewUser(newUser);
		
		
	}

}

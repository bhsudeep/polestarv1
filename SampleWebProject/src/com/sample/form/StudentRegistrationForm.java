package com.sample.form;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class StudentRegistrationForm {
	
	
	private String fullName;
	private String nickName;
	private String email;
	private String gender;
	private String major;
	private String expectedGraduationDate;
	private String blogLink;
	private String password;
	private String favIcecream;
	private String birthPlace;
	private String language;
	private CommonsMultipartFile image_file;
	private String filetype;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int h;
	private int w;
	
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getExpectedGraduationDate() {
		return expectedGraduationDate;
	}
	public void setExpectedGraduationDate(String expectedGraduationDate) {
		this.expectedGraduationDate = expectedGraduationDate;
	}
	public String getBlogLink() {
		return blogLink;
	}
	public void setBlogLink(String blogLink) {
		this.blogLink = blogLink;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFavIcecream() {
		return favIcecream;
	}
	public void setFavIcecream(String favIcecream) {
		this.favIcecream = favIcecream;
	}
	public String getBirthPlace() {
		return birthPlace;
	}
	public void setBirthPlace(String birthPlace) {
		this.birthPlace = birthPlace;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public CommonsMultipartFile getImage_file() {
		return image_file;
	}
	public void setImage_file(CommonsMultipartFile image_file) {
		this.image_file = image_file;
	}
	public int getX1() {
		return x1;
	}
	public void setX1(int x1) {
		this.x1 = x1;
	}
	public int getY1() {
		return y1;
	}
	public void setY1(int y1) {
		this.y1 = y1;
	}
	public int getX2() {
		return x2;
	}
	public void setX2(int x2) {
		this.x2 = x2;
	}
	public int getY2() {
		return y2;
	}
	public void setY2(int y2) {
		this.y2 = y2;
	}
	public int getH() {
		return h;
	}
	public void setH(int h) {
		this.h = h;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	
	

}

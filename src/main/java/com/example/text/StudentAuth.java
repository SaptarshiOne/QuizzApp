package com.example.text;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class StudentAuth {
	@Id
	int studentID;
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	String username;
	String password;
	//int marksObtained;
	//boolean hasPassed;
	
	
	
}

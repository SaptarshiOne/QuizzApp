package com.example.text;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class StudentResultDataEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "INT default 0")
	private int studentID;
	
	@ManyToOne
    @JoinColumn(name = "student_id")
	private StudentAuth  Student;
	
	public StudentAuth  getStudent() {
		return Student;
	}
	public void setStudent(StudentAuth  student) {
		Student = student;
	}
	String subject;
	int marksObtained;
	byte hasPassed;
	public int getStudentID() {
		if (Student != null) {
			return Student.getStudentID();
		}
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getMarksObtained() {
		return marksObtained;
	}
	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}
	public byte getHasPassed() {
		return hasPassed;
	}
	public void setHasPassed(byte hasPassed) {
		this.hasPassed = hasPassed;
	}
	@Override
	public String toString() {
		return "StudentResultDataEntity [studentID=" + studentID + ", subject=" + subject + ", marksObtained="
				+ marksObtained + ", hasPassed=" + hasPassed + "]";
	}
	
}

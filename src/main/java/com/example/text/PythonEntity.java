package com.example.text;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class PythonEntity {
	@Id
	int id;
	String question;
	String option1;
	String option2;
	String option3;
	String option4;
	String correctOption;
	int marksWeightage;
	String examCategory;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public String getCorrectOption() {
		return correctOption;
	}
	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}
	public int getMarksWeightage() {
		return marksWeightage;
	}
	public void setMarksWeightage(int marksWeightage) {
		this.marksWeightage = marksWeightage;
	}
	public String getExamCategory() {
		return examCategory;
	}
	public void setExamCategory(String examCategory) {
		this.examCategory = examCategory;
	}
	@Override
	public String toString() {
		return "JavaEntity [id=" + id + ", question=" + question + ", option1=" + option1 + ", option2=" + option2
				+ ", option3=" + option3 + ", option4=" + option4 + ", correctOption=" + correctOption
				+ ", marksWeightage=" + marksWeightage + ", examCategory=" + examCategory + "]";
	}
	

}

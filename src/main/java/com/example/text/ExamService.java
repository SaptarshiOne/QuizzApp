package com.example.text;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExamService {
	@Autowired
	JavaQuestionRepository jrepo;
	@Autowired
	PythonQuestionRepository pyrepo;
	
	 public List<JavaEntity> getJavaQuestions() {
	        return jrepo.findAll();
	    }
	 
	 public List<PythonEntity> getPythonQuestions() {
	        return pyrepo.findAll();
	    }

}

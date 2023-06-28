package com.example.text;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
@Controller
public class ExamController {
	@Autowired
	StudentRepo repo;
	@Autowired
	JavaQuestionRepository jrepo;
	@Autowired
	StudentResultRepo studentResultRepo;
	@Autowired
	PythonQuestionRepository pyrepo;
	
	

	
	@RequestMapping("/")
	public String login() {
		return "login.jsp";
	}
	
	@RequestMapping("/home")
	public String home(@RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model) {
	    // Perform authentication logic
        boolean isAuthenticated = authenticate(username, password);

        if (isAuthenticated) {
        	model.addAttribute("username", username);
        	List<Object[]> result = studentResultRepo.findSubjectAndMarksByUsername(username);

        	for (Object[] row : result) {
        	    String subject = (String) row[0];
        	    Integer marksObtained = (Integer) row[1];
        	   model.addAttribute("subject",subject);
        	   model.addAttribute("marksObtained",marksObtained);
           
        	}
        	 return "home.jsp";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "Error.jsp";
        }
    }

    // ...

    private boolean authenticate(String username, String password) {
        // Retrieve the student by username from the repository
        StudentAuth student = repo.findByUsername(username);

        if (student != null && student.getPassword().equals(password)) {
            return true;
        }

        return false;
    }
    public List<JavaEntity> retrieveJavaQuestionsFromDatabase() {
        // Use the JavaQuestionRepository to retrieve Java questions from the database
        List<JavaEntity> javaQuestions = jrepo.findAll();
        
        return javaQuestions;
    }
    public List<PythonEntity> retrievePythonQuestionsFromDatabase() {
        // Use the JavaQuestionRepository to retrieve Java questions from the database
        List<PythonEntity> pythonQuestions = pyrepo.findAll();
        
        return pythonQuestions;
    }
  
    public boolean hasTakenExam(String username, String examTopic) {
        Long count = studentResultRepo.countByStudentAndSubject(username, examTopic);
        return count > 0;
    }
   
    
    @RequestMapping("/startExam")
    public String startExam(@RequestParam("examTopic") String examTopic,@RequestParam("username") String username, Model model) {
        // Add logic to start the exam based on the selected exam topic
    	if(hasTakenExam( username, examTopic)) {
    		model.addAttribute("error", "You have Already  Attempted the exam");
            return "Error.jsp";
    		
    	}
        if (examTopic.equals("JAVA")) {
        	
        	long examDuration = 2 * 60 * 1000; // Exam duration in milliseconds
            long remainingTime = examDuration; // Initialize the remaining time to the exam duration
            model.addAttribute("remainingTime", remainingTime);
        	 List<JavaEntity> javaQuestions = retrieveJavaQuestionsFromDatabase(); // Implement the logic to retrieve Java questions from the database
             model.addAttribute("javaQuestions", javaQuestions);
             model.addAttribute("examTopic", examTopic);
             model.addAttribute("username", username);
             
            return "javaExam.jsp"; // Replace with the actual JSP page for the Java exam
        } else if (examTopic.equals("PYTHON")) {
        	long examDuration = 2 * 60 * 1000; // Exam duration in milliseconds
            long remainingTime = examDuration; // Initialize the remaining time to the exam duration
            model.addAttribute("remainingTime", remainingTime);
        	List<PythonEntity> pythonQuestions = retrievePythonQuestionsFromDatabase();
        	model.addAttribute("pythonQuestions", pythonQuestions);
            model.addAttribute("examTopic", examTopic);
            model.addAttribute("username", username);

            return "pythonExam.jsp"; // Replace with the actual JSP page for the Python exam
        } else {
            // Handle other exam topics or provide an error message
            return "Error.jsp";
        }
    }
    private static final int PASS_PERCENTAGE = 80;
    private final ExamService examService;
    @Autowired
    public ExamController(ExamService examService) {
    	this.examService=examService;
    }
    
    


    
    @RequestMapping("/submitExamPython")
    public String submitExamPython(@RequestParam Map<String, String> answersMap,@RequestParam("examTopic")String examTopic,
    		@RequestParam("username") String username, Model model) throws Exception {
        List<PythonEntity> pythonQuestions = examService.getPythonQuestions();
        int totalQuestions = pythonQuestions.size();
        int totalMarks = 0;
        int maxMarks=0;
        String p;
        System.out.println(username);
        for (PythonEntity question1 : pythonQuestions) {
        	maxMarks=maxMarks+question1.getMarksWeightage();
        }

        //if (answersMap.size() != totalQuestions) {
         //   throw new Exception("Invalid number of answers submitted.");
       // }

        for (PythonEntity question : pythonQuestions) {
            String questionId = String.valueOf(question.getId());
            //System.out.println(questionId);
            String submittedAnswer = answersMap.get(questionId);
            String correctAnswer = question.getCorrectOption();
            if(submittedAnswer==null)
            	submittedAnswer="0";
            

            if (submittedAnswer.equals(correctAnswer)) {
                totalMarks=(totalMarks+question.getMarksWeightage());
            }
        }

        int percentage = (int) ((totalMarks / (double)maxMarks) * 100);
        boolean pass = percentage >= PASS_PERCENTAGE;
        if(pass)
        	p="Congratulations. You have successfully passed the test";
        else
        	p="Sorry. You have failed. Try again";
        	
        	

        model.addAttribute("totalMarks", totalMarks);
        model.addAttribute("totalQuestions", totalQuestions);
        model.addAttribute("percentage", percentage);
        model.addAttribute("pass", p);
        StudentResultDataEntity studentResultData = new StudentResultDataEntity();
        //StudentAuth student = new StudentAuth();
        //studentAuth.getUsername();
        StudentAuth student = repo.findByUsername(username);
        System.out.println(student);
        studentResultData.setStudent(student); // Set the appropriate student ID
        studentResultData.setSubject(examTopic); // Set the subject
        studentResultData.setMarksObtained(totalMarks); // Set the marks obtained
        studentResultData.setHasPassed(pass ? (byte) 1 : (byte) 0); // Set the pass status

        studentResultRepo.save(studentResultData);


        return "Result.jsp";
    }
		
    @RequestMapping("/submitExamJava")
    public String submitExamJava(@RequestParam Map<String, String> answersMap,@RequestParam("examTopic")String examTopic,
    		@RequestParam("username") String username, Model model) throws Exception {
        List<JavaEntity> javaQuestions = examService.getJavaQuestions();
        int totalQuestions = javaQuestions.size();
        int totalMarks = 0;
        int maxMarks=0;
        String p;
        System.out.println(username);
        for (JavaEntity question1 : javaQuestions) {
        	maxMarks=maxMarks+question1.getMarksWeightage();
        }

        //if (answersMap.size() != totalQuestions) {
         //   throw new Exception("Invalid number of answers submitted.");
       // }

        for (JavaEntity question : javaQuestions) {
            String questionId = String.valueOf(question.getId());
            //System.out.println(questionId);
            String submittedAnswer = answersMap.get(questionId);
            String correctAnswer = question.getCorrectOption();
            if(submittedAnswer==null)
            	submittedAnswer="0";
            

            if (submittedAnswer.equals(correctAnswer)) {
                totalMarks=(totalMarks+question.getMarksWeightage());
            }
        }

        int percentage = (int)((totalMarks / (double) maxMarks) * 100);
        boolean pass = percentage >= PASS_PERCENTAGE;
        if(pass)
        	p="Congratulations. You have successfully passed the test";
        else
        	p="Sorry. You have failed. Try again";
        	
        	

        model.addAttribute("totalMarks", totalMarks);
        model.addAttribute("totalQuestions", totalQuestions);
        model.addAttribute("percentage", percentage);
        model.addAttribute("pass", p);
        StudentResultDataEntity studentResultData = new StudentResultDataEntity();
        //StudentAuth student = new StudentAuth();
        //studentAuth.getUsername();
        StudentAuth student = repo.findByUsername(username);
        System.out.println(student);
        studentResultData.setStudent(student); // Set the appropriate student ID
        studentResultData.setSubject(examTopic); // Set the subject
        studentResultData.setMarksObtained(totalMarks); // Set the marks obtained
        studentResultData.setHasPassed(pass ? (byte) 1 : (byte) 0); // Set the pass status

        studentResultRepo.save(studentResultData);


        return "Result.jsp";
    }





    }





	





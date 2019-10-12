package ca.sheridancollege;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Student;
import ca.sheridancollege.database.StudentStorage;

@Controller
public class HomeController {
	
	public ArrayList<String> studentCourses = new ArrayList<String>();
	public StudentStorage w = new StudentStorage();
	
	@GetMapping("/")
	public String doGet() {
		return "studentTrack.html";
	}
	
	@GetMapping("/add")
	public String addStudent(@RequestParam String studentName,
			@RequestParam Integer studentId,
			@RequestParam(required = false, defaultValue = "No Course") String courseList1,
			@RequestParam(required = false, defaultValue = "No Course") String courseList2,
			@RequestParam(required = false, defaultValue = "No Course") String courseList3,
			@RequestParam(required = false, defaultValue = "No Course") String courseList4,
			@RequestParam(required = false, defaultValue = "No Course") String courseList5,
			@RequestParam(required = false, defaultValue = "No Course") String courseList6) {
		
		Student newStudent = new Student();
		newStudent.setStudentName(studentName);
		newStudent.setStudentId(studentId);
		studentCourses.add(courseList1);
		studentCourses.add(courseList2);
		studentCourses.add(courseList3);
		studentCourses.add(courseList4);
		studentCourses.add(courseList5);
		studentCourses.add(courseList6);
		newStudent.setStudentCourses(studentCourses);
		
		w.getStudentList().add(newStudent);

		return "studentTrack.html";
	}
	
	@GetMapping("/show")
	public String showStudentList(Model model) {
		
		model.addAttribute("STUDENTSLIST", w.getStudentList());
		
		return "showStudents.html";
	}
}

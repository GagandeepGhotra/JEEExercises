package ca.sheridancollege.beans;

import java.io.Serializable;
import java.util.List;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student implements Serializable{
	
	private static final long serialVersionUID = 3434343433242332234L;
	
	private String studentName;
	private int studentId;
	private List<String> studentCourses;
	
}

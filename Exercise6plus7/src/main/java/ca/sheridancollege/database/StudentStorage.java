package ca.sheridancollege.database;

import java.util.ArrayList;

import lombok.*;
import ca.sheridancollege.beans.Student;

@Data
@NoArgsConstructor
public class StudentStorage {

	private ArrayList<Student> studentList = new ArrayList<Student>();
}

package main;

import java.util.List;

import dao.IStudentDao;
import dao.StudentDao;
import model.Student;

public class StudentApp {
	public static void main(String args[]) {
		IStudentDao studentDao = new StudentDao();
		
		 // test saveStudent
		 Student student = new Student("Charan", "Romi", "charan35@gmail.com");
		 Student student2 = new Student("Ram", "Charan", "ram55@gmail.com");
		 Student student3 = new Student("Mary", "Kingston", "mary.k@test.com");
		 Student student4 = new Student("John", "Doe", "john.d@test2.com");
		
		 studentDao.saveStudent(student);
		 studentDao.saveStudent(student2);
		 studentDao.saveStudent(student3);
		 studentDao.saveStudent(student4);
		 System.out.println(student.toString());
		 System.out.println(student2.toString());
		 			
			
		 Student student1 = studentDao.getStudentById(1);
		 System.out.println(student1.toString());
		

		 Student student21 = studentDao.getStudentById(4);
		 if (student21 != null) {
				student21.setLastName("TEST1234");
				studentDao.updateStudent(student21);
				System.out.println(student21.toString());
			}

		 studentDao.deleteStudent(3);
		 

		 List<Student> students = studentDao.getAllStudents();
		 students.forEach(s -> System.out.println(students.toString()));
	}

}

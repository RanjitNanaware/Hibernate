package manytomany_uni_pjcm16.controller;

import java.util.Scanner;

import manytomany_uni_pjcm16.dao.CourseDao;
import manytomany_uni_pjcm16.dao.StudentDao;
import manytomany_uni_pjcm16.dto.Course;
import manytomany_uni_pjcm16.dto.Student;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Course course = new Course();
		CourseDao courseDao = new CourseDao();
		Student student = new Student();
		StudentDao studentDao = new StudentDao();
		
		
		System.out.println("Press 1.Course Interface 2.Student Interface");
		
	}
}

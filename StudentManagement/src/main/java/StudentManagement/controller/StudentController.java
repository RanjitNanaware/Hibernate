package StudentManagement.controller;

import java.util.Scanner;

import StudentManagement.dao.StudentDao;
import StudentManagement.dto.Student;

public class StudentController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Student student = new Student();

		StudentDao dao = new StudentDao();

		System.out.println("Enter The Choice \n1.Insert Student \n2.Update Student "
				+ "\n3.Delete Student \n4.Find Student By Id " + "\n5. Show All Students");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter Student Id : ");
			int id = scanner.nextInt();
			System.out.println("Enter Student Name : ");
			String name = scanner.next();
			System.out.println("Enter Student Age : ");
			int age = scanner.nextInt();
			System.out.println("Enter Student phone :");
			long phone = scanner.nextLong();
			System.out.println("Enter Student Address :");
			String address = scanner.next();
			System.out.println("Enter Student Marks :");
			int marks = scanner.nextInt();
			System.out.println("Enter Student Percentage :");
			double percentage = scanner.nextDouble();

			student.setId(id);
			student.setName(name);
			student.setAge(age);
			student.setPhone(phone);
			student.setAddress(address);
			student.setMarks(marks);
			student.setPercentage(percentage);

			dao.saveStudent(student);
			break;

		case 2:
			System.out.println("Enter Student Id To Update : ");
			int id2 = scanner.nextInt();
			System.out.println("Enter Student Name : ");
			String name2 = scanner.next();
			System.out.println("Enter Student Age : ");
			int age2 = scanner.nextInt();
			System.out.println("Enter Student phone :");
			long phone2 = scanner.nextLong();
			System.out.println("Enter Student Address :");
			String address2 = scanner.next();
			System.out.println("Enter Student Marks :");
			int marks2 = scanner.nextInt();
			System.out.println("Enter Student Percentage :");
			double percentage2 = scanner.nextDouble();

			student.setId(id2);
			student.setName(name2);
			student.setAge(age2);
			student.setPhone(phone2);
			student.setAddress(address2);
			student.setMarks(marks2);
			student.setPercentage(percentage2);

			dao.updateStudent(student);
			break;

		case 3:
			System.out.println("Enter Student Id To Delete : ");
			int id3 = scanner.nextInt();

			student.setId(id3);

			dao.deleteStudent(id3);
			break;

		case 4:
			System.out.println("Enter Student Id To Fetch Details : ");
			int id4 = scanner.nextInt();

			student.setId(id4);

			dao.fetchStudent(id4);
			break;

		case 5:
			System.out.println("Show All Students");

			dao.showAllStudent();

			break;
		default:
			break;
		}
	}
}

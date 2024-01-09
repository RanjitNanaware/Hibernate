package companyEmployeeManagement.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import companyEmployeeManagement.dao.CompanyDao;
import companyEmployeeManagement.dto.Company;
import companyEmployeeManagement.dto.Employee;

public class MainController {

	public static void main(String[] args) {

		CompanyDao companyDao = new CompanyDao();

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter A Choice \n1.Add Employee \n2.Delete Employee "
				+ "\n3.Find Employee By ID \n4.Find All \n5.Fetch Company "
				+ "\n6.Update Company Details \n7.Update All");
		int choice = scanner.nextInt();
		switch (choice) {
		case 1: {
			Employee employee1 = new Employee();
			employee1.setId(1);
			employee1.setName("Ranjit");
			employee1.setPhone(9595089559l);
			employee1.setAddress("KarveNagar");

			Employee employee2 = new Employee();
			employee2.setId(2);
			employee2.setName("Swapnil");
			employee2.setPhone(6464646333l);
			employee2.setAddress("Warje");

			Employee employee3 = new Employee();
			employee3.setId(3);
			employee3.setName("Nirbhay");
			employee3.setPhone(95955553213l);
			employee3.setAddress("Nigdi");

			Company company = new Company();
			company.setId(1);
			company.setName("BlackRock");
			company.setLocation("Washington");
			company.setGST("25");

			List<Employee> employees = new ArrayList<Employee>();
			employees.add(employee1);
			employees.add(employee2);
			employees.add(employee3);

			company.setEmployees(employees);

			companyDao.saveCompany(company);
		}
			break;
		case 2: {
			System.out.println("Enter Company Id To Delete :- ");
			int id = scanner.nextInt();

			companyDao.deleteCompany(id);
		}
			break;
		case 3: {
			System.out.println("Enter Employee Id To Get Employee Details");
			int id = scanner.nextInt();

			companyDao.findEmployeeById(id);
		}
			break;
		case 4 :{
			companyDao.findAllEmployee();
		}
			break;
		case 5 :{
			System.out.println("Enter Company Id To Fetch All Details :- ");
			int id = scanner.nextInt();
			
			companyDao.fetchCompany(id);
		}
			break;
		case 6:{
			Company company = new Company();
			company.setName("BlackRock");
			company.setLocation("Los Angeles");
			company.setGST("12");
			
			companyDao.updateCompanyDeatails(1, company);
		}
			break;
		case 7:{
			Employee employee1 = new Employee();
			employee1.setId(4);
			employee1.setName("Ranjit");
			employee1.setPhone(9823300213l);
			employee1.setAddress("Pune");

			Employee employee2 = new Employee();
			employee2.setId(5);
			employee2.setName("Amol");
			employee2.setPhone(9637076337l);
			employee2.setAddress("Akluj");

			Employee employee3 = new Employee();
			employee3.setId(6);
			employee3.setName("Amit");
			employee3.setPhone(7773972655l);
			employee3.setAddress("Akurdi");

			Company company = new Company();
			company.setId(2);
			company.setName("Google");
			company.setLocation("AmsterDam");
			company.setGST("12");

			List<Employee> employees = new ArrayList<Employee>();
			employees.add(employee1);
			employees.add(employee2);
			employees.add(employee3);

			company.setEmployees(employees);

			companyDao.updateAllDetails(2, company);
		}
			break;
		default:
			break;
		}

	}
}

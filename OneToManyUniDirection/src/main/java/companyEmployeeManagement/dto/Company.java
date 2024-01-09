package companyEmployeeManagement.dto;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
@Cacheable
public class Company {
	@Id
	private int id;
	private String name;
	private String location;
	private String GST ;
	@OneToMany //(fetch = FetchType.EAGER)
	private List<Employee> employees;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGST() {
		return GST;
	}
	public void setGST(String gST) {
		GST = gST;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", location=" + location + ", GST=" + GST + ", employees="
				+ employees + "]";
	}
}

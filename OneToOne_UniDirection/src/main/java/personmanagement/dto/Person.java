package personmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	private int id ;
	private String name ;
	@Column(unique = true)
	private long phone ;
	private int age ;
	private String address ;
	@OneToOne
	private AdharCard adharcard ;
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
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public AdharCard getAdharcard() {
		return adharcard;
	}
	public void setAdharcard(AdharCard adharcard) {
		this.adharcard = adharcard;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone + ", age=" + age + ", address=" + address
				+ ", adharcard=" + adharcard + "]";
	}
}

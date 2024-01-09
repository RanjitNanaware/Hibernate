package personmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdharCard {
	@Id
	private int id ;
	private String name ;
	@Column(unique = true)
	private String address ;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "AdharCard [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
}

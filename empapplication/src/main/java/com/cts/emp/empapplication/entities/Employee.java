package com.cts.emp.empapplication.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@Column(name="name")
	private String name;
	
	@Column(name="email")
	private String email;
	
	@Column(name="id")
	private int id;
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", email=" + email + ", id=" + id + ", ph=" + ph + ", address=" + address
				+ "]";
	}
	@Column(name="ph")
	private String ph;
	
	@Column(name="address")
	private String address;
	
	
	
	public Employee(String name, String email, int id, String ph, String address) {
		super();
		this.name = name;
		this.email = email;
		this.id = id;
		this.ph = ph;
		this.address = address;
	}
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPh() {
		return ph;
	}
	public void setPh(String ph) {
		this.ph = ph;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}

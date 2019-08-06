package com.example.springregister;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "Seller")
public class Seller {
	
	@Id
	private String username;
	@NotEmpty(message = "Please provide a name")
	private String name;
	@NotEmpty(message = "Please provide a password")
	private String password;
	@NotEmpty(message = "Please provide a address")
	private String address;
	private int age;
	private char gender;
	@NotEmpty(message = "Please provide a companyname")
	private String company;
	@NotEmpty(message = "Please provide a type of product")
	private String typeofproduct;
	
	
	
	private Seller() {
		
	}
	
	
	public Seller(String username, String name, String password, String address, int age, char gender,
			String company, String typeofproduct) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
		this.address = address;
		this.age = age;
		this.gender = gender;
		this.company = company;
		this.typeofproduct = typeofproduct;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getTypeofproduct() {
		return typeofproduct;
	}
	public void setTypeofproduct(String typeofproduct) {
		this.typeofproduct = typeofproduct;
	}
	
	
	
	
	
	
	
}

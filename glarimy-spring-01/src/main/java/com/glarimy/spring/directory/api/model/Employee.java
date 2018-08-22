package com.glarimy.spring.directory.api.model;

import java.util.Set;

public class Employee {
	private int id;
	private String name;
	private double salary;
	private boolean regular;
	private Address address;
	private Set<Qualification> qualifications;

	public Employee() {
	}

	public Employee(String name, double salary, boolean regular) {
		super();
		this.name = name;
		this.salary = salary;
		this.regular = regular;
	}

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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isRegular() {
		return regular;
	}

	public void setRegular(boolean regular) {
		this.regular = regular;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Set<Qualification> getQualifications() {
		return qualifications;
	}

	public void setQualifications(Set<Qualification> qualifications) {
		this.qualifications = qualifications;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + ", regular=" + regular + ", address="
				+ address + ", qualifications=" + qualifications + "]";
	}

}

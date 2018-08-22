package com.glarimy.spring.directory.api.model;

public class Qualification {
	private String degree;
	private String university;
	private int year;

	public Qualification() {
	}

	public Qualification(String degree, String university, int year) {
		super();
		this.degree = degree;
		this.university = university;
		this.year = year;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}

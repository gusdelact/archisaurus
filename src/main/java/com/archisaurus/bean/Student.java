package com.archisaurus.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;


/**
 * The persistent class for the student database table.
 * 
 */
@Entity
@NamedQuery(name="Student.findAll", query="SELECT s FROM Student s")
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Lob
	@Column(name="enrolled_since")
	private String enrolledSince;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	//bi-directional many-to-many association to Course
	@ManyToMany(mappedBy="students",cascade = CascadeType.PERSIST)
	private List<Course> courses;

	public Student() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnrolledSince() {
		return this.enrolledSince;
	}

	public void setEnrolledSince(String enrolledSince) {
		this.enrolledSince = enrolledSince;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.getEnrolledSince();
	}
}
package com.archisaurus.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.FetchType.EAGER;


/**
 * The persistent class for the course database table.
 * 
 */
@ManagedBean (name="course")
@RequestScoped
@Entity
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int credits;

	
	private String name;

	//bi-directional many-to-many association to Student
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = EAGER)
	@JoinTable(
		name="course_student"
		, joinColumns={
			@JoinColumn(name="course_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="student_id")
			}
		)
	private List<Student> students;

	//bi-directional many-to-one association to Teacher
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Teacher teacher;

	public Course() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCredits() {
		return this.credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return this.students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public Teacher getTeacher() {
		return this.teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

}
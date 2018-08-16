package com.archisaurus.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.archisaurus.bean.Course;
import com.archisaurus.controller.EntityManagerFactoryBean;

public class CourseService {
	private EntityManagerFactory factory;
	public CourseService(EntityManagerFactoryBean factoryBean) {
		factory = factoryBean.getEntityManagerFactory();
	}
	/*public void addCourse(Course course) {
		System.out.println("addcourse");
		
	}
	public List<Course> getCourses() {
		System.out.println("getCourses");
		ArrayList<Course> courses = new ArrayList<Course>();
		Course courseSO = new Course();
		courseSO.setName("Sistemas Operativos");
		courseSO.setCredits(10);
		
		Course coursePW = new Course();
		coursePW.setName("Programacion Web");
		coursePW.setCredits(15);
	
		courses.add(courseSO);
		courses.add(coursePW);
		return courses;
	}*/
	

	public List<Course> getCourses() {
		EntityManager em = factory.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		TypedQuery<Course> tq = em.createQuery(cq);
		List<Course> courses = tq.getResultList();
		em.close();
		return courses;
	}

	public void addCourse (Course course) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.persist(course);
		txn.commit();
	}
	
	public void updateCourse (Course course) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		em.merge(course);
		txn.commit();
	}
	
	public Course getCourse (int id) {
		EntityManager em = factory.createEntityManager();
		return em.find(Course.class, id);
	}
	
	public void deleteCourse (Course course) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction txn = em.getTransaction();
		txn.begin();
		Course mergedCourse = em.find(Course.class, course.getId());
		em.remove(mergedCourse);
		txn.commit();
	}

}

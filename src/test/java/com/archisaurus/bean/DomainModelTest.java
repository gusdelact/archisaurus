package com.archisaurus.bean;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import junit.framework.TestCase;


public class DomainModelTest extends TestCase {
	

	private EntityManager em,em2;

	protected void setUp() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("peeaJPA");
		EntityManagerFactory factory2 = Persistence.createEntityManagerFactory("peeaJPA");
		em = factory.createEntityManager();
		em2= factory2.createEntityManager();
		
	}
	public void testDomainModel() {
		
		Teacher teacher= new Teacher();
		teacher.setFirstName("Gustavo");
		teacher.setLastName("De la Cruz Tovar");
		teacher.setDesignation("profesor");
		
		ArrayList<Course> courses = new ArrayList<Course>();
		Course courseSO = new Course();
		courseSO.setName("Sistemas Operativos");
		courseSO.setCredits(10);
		courseSO.setTeacher(teacher);
		Course coursePW = new Course();
		coursePW.setName("Programacion Web");
		coursePW.setCredits(15);
		coursePW.setTeacher(teacher);
		courses.add(courseSO);
		courses.add(coursePW);
		
		ArrayList<Student> students = new ArrayList<Student>();
		Student studentPP = new Student();
		studentPP.setFirstName("Pepito");
		studentPP.setLastName("De los Cuentos");
		studentPP.setEnrolledSince("Enero 2016");
		studentPP.setCourses(courses);
		Student studentJJ = new Student();
		studentJJ.setFirstName("Juanito");
		studentJJ.setLastName("Juanetes");
		studentJJ.setEnrolledSince("Enero 2016");
		studentJJ.setCourses(courses);
		
		students.add(studentPP);
		students.add(studentJJ);
		courseSO.setStudents(students);
		coursePW.setStudents(students);
		
		EntityTransaction txn = em.getTransaction();
		//creacion
		txn.begin();
		em.persist(studentPP);
		txn.commit();
		em.close();
		
		//consulta
		
		CriteriaBuilder cb = em2.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		TypedQuery<Course> tq = em2.createQuery(cq);
		List<Course> theCourses = tq.getResultList();
		for (Course theCourse : theCourses) {
			List<Student> stds = theCourse.getStudents();
			assertTrue(stds.size()==students.size());
			for (Student s: stds) {
				assertTrue(s.getId()>0);
				System.out.println(s);
			}
		}
		assertTrue(theCourses.size()==courses.size());
		
//actualizacion		
		txn = em2.getTransaction();
		txn.begin();
		Teacher theTeacher = theCourses.get(0).getTeacher();
		for (Course theCourse : theCourses) {
			theCourse.setTeacher(null);
	
		}
		txn.commit();
//borrado
		
		
		
		
		txn.begin();
		em2.remove(theTeacher);
		for (Student theStudent : theCourses.get(0).getStudents()) {
			em2.remove(theStudent);
		}
		for (Course theCourse : theCourses) {
			em2.remove(theCourse);
			
		}
		
		txn.commit();
		em2.close();
	}
	

}

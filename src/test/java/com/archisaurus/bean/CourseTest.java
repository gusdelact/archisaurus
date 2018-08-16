package com.archisaurus.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



import junit.framework.TestCase;

public class CourseTest extends TestCase {
	

	private EntityManager em;

	protected void setUp() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("peeaJPA");
		em = factory.createEntityManager();
	}
	public void testTeacherCRUD() {
		
		EntityTransaction txn = em.getTransaction();
		//creacion
		txn.begin();
		Course course = new Course();
		course.setName("Sistemas Operativos");
		course.setCredits(10);
		em.persist(course);
		txn.commit();
		int id = course.getId();
		assertTrue("id asignado" , id > 0);
	
		//consulta
		
		Course theCourse = em.find(Course.class, id);
		assertNotNull(theCourse);
		assertEquals(id,theCourse.getId());
		
		//actualizacion
		txn.begin();
		theCourse.setCredits(15);
		txn.commit();
		
		//borrado
		txn.begin();
		em.remove(theCourse);
		txn.commit();
		
	}
	

}

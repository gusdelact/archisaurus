package com.archisaurus.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



import junit.framework.TestCase;

public class StudentTest extends TestCase {
	

	private EntityManager em;

	protected void setUp() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("peeaJPA");
		em = factory.createEntityManager();
	}
	public void testTeacherCRUD() {
		
		EntityTransaction txn = em.getTransaction();
		//creacion
		txn.begin();
		Student student = new Student();
		student.setFirstName("Pepito");
		student.setLastName("De los Cuentos");
		student.setEnrolledSince("Enero 2016");
		em.persist(student);
		txn.commit();
		int id = student.getId();
		assertTrue("id asignado" , id > 0);
	
		//consulta
		
		Student theStudent = em.find(Student.class, id);
		assertNotNull(theStudent);
		assertEquals(id,theStudent.getId());
		
		//actualizacion
		txn.begin();
		theStudent.setEnrolledSince("Junio 2016");
		txn.commit();
		
		//borrado
		txn.begin();
		em.remove(theStudent);
		txn.commit();
		
	}
	

}

package com.archisaurus.bean;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



import junit.framework.TestCase;

public class TeacherTest extends TestCase {
	

	private EntityManager em;

	protected void setUp() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("peeaJPA");
		em = factory.createEntityManager();
	}
	public void testTeacherCRUD() {
		
		EntityTransaction txn = em.getTransaction();
		//creacion
		txn.begin();
		Teacher teacher= new Teacher();
		teacher.setFirstName("Gustavo");
		teacher.setLastName("De la Cruz Tovar");
		teacher.setDesignation("profesor");
		em.persist(teacher);
		txn.commit();
		int id = teacher.getId();
		assertTrue("id asignado" , id > 0);
		
		//lectura
		Teacher theTeacher = em.find(com.archisaurus.bean.Teacher.class,id);
		assertNotNull(theTeacher);
		assertEquals(id,theTeacher.getId());
		
		//actualizacion
		txn.begin();
		theTeacher.setDesignation("profesor tiempo parcial");
		txn.commit();
		
		//borrar
		txn.begin();
		em.remove(theTeacher);
		txn.commit();
		
	}
	

}

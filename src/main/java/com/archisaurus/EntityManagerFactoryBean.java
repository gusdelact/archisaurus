package com.archisaurus;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class EntityManagerFactoryBean {

	private EntityManagerFactory entityManagerFactory;
	
	public EntityManagerFactoryBean() {
		entityManagerFactory = Persistence.createEntityManagerFactory("peeaJPA");
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

}

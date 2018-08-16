package com.archisaurus.controller;


import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean(name="emFactoryBean", eager=true)
@ApplicationScoped

public class EntityManagerFactoryBean {

	private EntityManagerFactory entityManagerFactory;
	
	public EntityManagerFactoryBean() {
		entityManagerFactory = Persistence.createEntityManagerFactory("peeaJPA");
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

}

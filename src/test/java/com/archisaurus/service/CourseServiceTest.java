package com.archisaurus.service;

import com.archisaurus.bean.Course;
import com.archisaurus.controller.EntityManagerFactoryBean;

import junit.framework.TestCase;

public class CourseServiceTest extends TestCase {
	
	public void testCourseService() {
		Course course = new Course();
		course.setName("Sistemas Distribuidos");
		course.setCredits(10);
		EntityManagerFactoryBean factoryBean = new EntityManagerFactoryBean();
		CourseService service = new CourseService(factoryBean ) ;
		
		service.addCourse(course);
		assertTrue(course.getId()>0);
		course.setCredits(21);
		service.updateCourse(course);
		service.deleteCourse(course);
		
	}

}

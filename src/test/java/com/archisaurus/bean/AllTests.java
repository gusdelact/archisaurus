package com.archisaurus.bean;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(CourseTest.class);
		suite.addTestSuite(TeacherTest.class);
		suite.addTestSuite(Student.class);
		//$JUnit-END$
		return suite;
	}

}

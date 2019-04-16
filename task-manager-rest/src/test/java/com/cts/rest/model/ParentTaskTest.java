package com.cts.rest.model;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParentTaskTest {
	
	static ParentTask parentTask;

	@BeforeClass
	public static void setUp() throws Exception {
		parentTask= new ParentTask();
	}


	@Test
	public void testGetParentId() {
		parentTask.setParentId(1);
		parentTask.getParentId();
		parentTask.setParentTask("");
		parentTask.getParentTask();
	}
	@AfterClass
	public static void tearDown() {
		parentTask = null;
	}

	
}

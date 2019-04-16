package com.cts.rest.model;


import java.time.LocalDate;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class TaskTest {
	
	static Task task = new Task();
	
	@BeforeClass
	public static void setUp() throws Exception {
		task = new Task();
	}


	@Test
	public void testGetTaskId() {
		task.setEndDate(LocalDate.now());
		task.getEndDate();
		task.setTaskId(1);
		task.getTaskId();
		task.setParentTask(null);
		task.getParentTask();
		task.setTaskName("t1");
		task.getTaskName();
	}
	
	@AfterClass
	public static void tearDown() {
		task = null;
	}

	
}

package com.cts.rest.controller;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cts.rest.model.Task;
import com.cts.rest.service.TaskManagerService;

@RunWith(SpringRunner.class)
@SpringBootTest
//@RunWith()

public class TaskManagerControllerTest {

	@MockBean
	TaskManagerService taskManagerService;
	
	@Autowired
	TaskManagerController taskManagerController;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPing() {
		assertEquals("Test Ping Service","Success",taskManagerController.ping().getStatus());
	}

	@Test
	public void testSaveTask() throws Exception {
		Task task =mockTask();
		Mockito.when(taskManagerService.saveTask(task)).thenReturn(task);
		assertEquals("Save Task test","1", taskManagerController.saveTask(task).getOutData());
	}

	@Test
	public void testGetTasks() throws Exception {
		Task task =mockTask();
		List<Task> lst =new ArrayList<>();
		lst.add(task);
		Mockito.when(taskManagerService.getTasks()).thenReturn(lst);
		assertEquals("Save Task test",task, taskManagerController.getTasks().getOutData().get(0));

	}

	@Test
	public void testGetTask() throws Exception {
		Task task =mockTask();
		Mockito.when(taskManagerService.getTask(Mockito.anyInt())).thenReturn(task);
		assertEquals("get Task ",task, taskManagerController.getTask(task).getOutData());

	}

	@Test
	public void testUpdateTaskEditEnabled() throws Exception {
		Task task =mockTask();
		Mockito.doNothing().when(taskManagerService).updateTaskEditEnabled(task);
		assertEquals("update edit enabled ","Success", taskManagerController.updateTaskEditEnabled(task).getStatus());
	}

	
	public static Task mockTask(){
		Task task = new Task();
		task.setTaskId(1);
		task.setTaskName("Sample Task");
		return task;
	}
}

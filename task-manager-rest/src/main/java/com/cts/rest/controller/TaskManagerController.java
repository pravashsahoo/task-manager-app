package com.cts.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.rest.constants.TaskManagerConstants;
import com.cts.rest.model.Responce;
import com.cts.rest.model.Task;
import com.cts.rest.service.TaskManagerService;

@RestController
@RequestMapping(path="/api/taskmanager")
public class TaskManagerController {
	public static final Logger LOGGER = LoggerFactory.getLogger(TaskManagerController.class);
	@Autowired
	private TaskManagerService taskManagerService;

	@GetMapping(path = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
	public Responce<String> ping() {
		LOGGER.info("from inside ping method");
		return new Responce<String>("Success","Success","0");
	}
	
	@RequestMapping(path="/saveTask",method =RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Responce<String> saveTask(@RequestBody Task task) throws Exception{
		LOGGER.debug("saveTask Entry ", task.getTaskName());
		Responce<String> response;
		try {
			task=taskManagerService.saveTask(task);
			response= new Responce<String>(task.getTaskId().toString(),TaskManagerConstants.SUCCESS, "0");
		}catch(Exception e) {
			LOGGER.error("Error while persisting task data", e);
			response= new Responce<String>(null,TaskManagerConstants.FAILURE, "1");
		}
		return response;
	}
	
	@RequestMapping(path="/getTasks",method =RequestMethod.POST,produces=MediaType.APPLICATION_JSON_VALUE)
	public Responce<List<Task>> getTasks() throws Exception{
		
		Responce<List<Task>> response;
		List<Task> list;
		try {
			list=taskManagerService.getTasks();
			LOGGER.debug("saveTask Entry ", list);
			response= new Responce<List<Task>>(list,TaskManagerConstants.SUCCESS, "0");
		}catch(Exception e) {
			LOGGER.error("Error while persisting task data", e);
			response= new Responce<List<Task>>(null,TaskManagerConstants.FAILURE, "2");
		}
		return response;
	}
	
	@RequestMapping(path="/getTask",method =RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Responce<Task> getTask(@RequestBody Task task) throws Exception{
		Responce<Task> response;
		try {
			task=taskManagerService.getTask(task.getTaskId());
			LOGGER.error(" getTask ==----------------------->", task);
			response= new Responce<Task>(task,TaskManagerConstants.SUCCESS, "0");
		}catch(Exception e) {
			LOGGER.error("Error while persisting task data", e.toString());
			e.printStackTrace();
			response= new Responce<Task>(null,TaskManagerConstants.FAILURE, "2");
		}
		return response;
	}
	@RequestMapping(path="/updateTaskEditEnabled",method =RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public Responce<String> updateTaskEditEnabled(@RequestBody Task task)throws Exception{
		LOGGER.debug("saveTask Entry ", task.getTaskName());
		Responce<String> response;
		try {
			taskManagerService.updateTaskEditEnabled(task);;
			response= new Responce<String>(task.getTaskId().toString(),TaskManagerConstants.SUCCESS, "0");
		}catch(Exception e) {
			LOGGER.error("Error while persisting task data", e);
			response= new Responce<String>(null,TaskManagerConstants.FAILURE, "1");
		}
		return response;
	}


}

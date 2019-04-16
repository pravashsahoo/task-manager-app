package com.cts.rest.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;

//import com.cts.rest.model.ParentTask;
import com.cts.rest.model.Task;
//import com.cts.rest.repositories.ParentTaskRepository;
import com.cts.rest.repositories.TaskRepository;

public class TaskManagerServiceImpl implements TaskManagerService{
	public static final Logger LOGGER = LoggerFactory.getLogger(TaskManagerService.class);
	
	@Autowired
	private TaskRepository taskRepository;
	
//	@Autowired
//	private ParentTaskRepository parentTaskRepository;
	
	@Override
	@Transactional
	public Task saveTask(Task task) throws DataAccessException {
//		ParentTask perentTask = parentTaskRepository.save(task.getParentTask());
		task = taskRepository.save(task); 
		return task;
	}

	@Override
	@Transactional
	public List<Task> getTasks() throws DataAccessException {
		return taskRepository.findAll();
	}

	@Override
	@Transactional
	public Task getTask(Integer taskId) throws DataAccessException {
		Optional<Task> task = taskRepository.findById(taskId);
		return task.isPresent()?task.get():null;
	}
	

	@Override
	@Transactional
	public void updateTaskEditEnabled(Task task) throws DataAccessException{
		taskRepository.updateTaskEditEnabled(task.getEditEnabled(), task.getTaskId());
	}


}

package com.cts.rest.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.cts.rest.model.Task;

public interface TaskManagerService {
	Task saveTask(Task task) throws DataAccessException;
	List<Task> getTasks() throws DataAccessException;
	Task getTask(Integer taskId) throws DataAccessException;
	void updateTaskEditEnabled(Task task) throws DataAccessException;
}

package com.cts.rest.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PARENT_TASK")
public class ParentTask implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "parent_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer parentId;

	@Column(name = "parent_task")
	private String parentTask;

//	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "parentTask")
//	@JsonManagedReference
//	@JsonIgnore
//	private Task task;

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getParentTask() {
		return parentTask;
	}

	public void setParentTask(String parentTask) {
		this.parentTask = parentTask;
	}

//	public Task getTask() {
//		return task;
//	}
//
//	public void setTask(Task task) {
//		this.task = task;
//	}

}

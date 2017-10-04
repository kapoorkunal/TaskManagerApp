package com.craft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.craft.objects.Task;
import com.craft.service.TaskManagerService;

@RestController
@RequestMapping("/api/task")
public class TaskManagerController {

	@Autowired
	TaskManagerService taskManagerService;

	@RequestMapping(value = "/{userId}", method = RequestMethod.GET)
	public List<Task> getAllTask(@PathVariable("userId") String userId) {
		return taskManagerService.listTasks(userId);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> addTask(@RequestBody Task task) {
		taskManagerService.addTask(task);

		HttpHeaders httpHeaders = new HttpHeaders();

		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/search/{taskDetails}", method = RequestMethod.GET)
	public List<Task> findTask(@PathVariable("taskDetails") String taskDetails) {
		return taskManagerService.searchTask(taskDetails);
	}

	@RequestMapping(value = "/{taskId}", method = RequestMethod.PUT)
	public ResponseEntity<?> put(@PathVariable("taskId") String taskId, @RequestBody Task task) {
		HttpHeaders httpHeaders = new HttpHeaders();

		try {
			taskManagerService.updateTask(taskId, task);
		} catch (Exception e) {
			return new ResponseEntity<>(null, httpHeaders, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{taskId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteTask(@PathVariable("taskId") String taskId) {
		taskManagerService.deleteTask(taskId);
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(null, httpHeaders, HttpStatus.OK);
	}

}
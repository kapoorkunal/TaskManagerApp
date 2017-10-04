package com.craft.service.impl;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.stereotype.Service;

import com.craft.mongoConfig.UpdateMongoDocument;
import com.craft.objects.Task;
import com.craft.repository.TaskManagerRepository;
import com.craft.service.TaskManagerService;

@Service
public class TaskManagerServiceImpl implements TaskManagerService {

	@Autowired
	TaskManagerRepository taskRepository;

	@Autowired
	UpdateMongoDocument updateMongo;

	@Autowired
	MongoTemplate mongoTemplate;

	@Value("${taskmanager.collectionName}")
	String collectionName;

	@Override
	public void addTask(Task task) {
		taskRepository.save(task);
	}

	@Override
	public void updateTask(String taskId, Task task) throws IOException {
		Task existingTask = taskRepository.findByTaskId(taskId);
		task.setCreatedDate(existingTask.getCreatedDate());
		task.setUpdatedDate(new Date());
		task.setVersion(existingTask.getVersion() + 1);
		updateMongo.performUpsert(task, collectionName);
	}

	@Override
	public void deleteTask(String taskId) {
		taskRepository.delete(taskId);
	}

	@Override
	public List<Task> searchTask(String taskDetails) {
		TextCriteria criteria = TextCriteria.forDefaultLanguage().matchingAny(taskDetails);
		return taskRepository.findAllBy(criteria);
	}

	@Override
	public List<Task> listTasks(String userId) {
		return taskRepository.findAllByUserId(userId);
	}

}

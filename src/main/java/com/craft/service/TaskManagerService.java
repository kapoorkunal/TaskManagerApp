package com.craft.service;

import java.io.IOException;
import java.util.List;

import com.craft.objects.Task;

public interface TaskManagerService {

	void addTask(Task task);

	void deleteTask(String taskId);

	List<Task> searchTask(String task);

	List<Task> listTasks(String userId);

	void updateTask(String Id, Task task) throws IOException;
}

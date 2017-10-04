package com.craft.repository;

import java.util.List;

import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.craft.objects.Task;

@Repository
public interface TaskManagerRepository extends MongoRepository<Task, String> {
	List<Task> findAllBy(TextCriteria criteria);

	List<Task> findAllByUserId(String userId);

	Task findByTaskId(String taskId);
}

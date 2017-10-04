package com.craft.mongoConfig;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.craft.objects.Task;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

@Component
public class UpdateMongoDocument {

	@Autowired
	MongoConfiguration mongoConfig;

	@Autowired
	MongoTemplate mongoTemp;

	public void performUpsert(Task obj, String collectionName) throws IOException {
		Query query = new Query(Criteria.where("taskId").is(obj.getTaskId()));
		DBObject dbDoc = new BasicDBObject();
		mongoTemp.getConverter().write(obj, dbDoc);
		Update update = Update.fromDBObject(dbDoc, "_id");
		mongoTemp.upsert(query, update, collectionName);
	}
}

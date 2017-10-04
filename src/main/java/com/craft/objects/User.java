package com.craft.objects;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "taskManagerCollection")
public class User {

	@Indexed(unique = true)
	@Id
	private String id;
	private String userName;
	private List<Task> task;
}

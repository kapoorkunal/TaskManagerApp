package com.craft.objects;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.index.TextIndexed;
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
public class Task {

	@Indexed(unique = true)
	private String taskId;

	@Indexed
	private String userId;

	@TextIndexed
	private String taskDetails;
	private boolean completed;
	private boolean archive;

	@CreatedDate
	private Date createdDate;

	@LastModifiedDate
	private Date updatedDate;

	@Version
	private Long version;
}

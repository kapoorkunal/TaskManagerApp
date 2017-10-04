# Task Manager Application

Spring Boot application which will create, update, list, search and delete task.  There are 5 API's exposed through this service as listed below.

Current API's<br/>
Create Task:  POST /api/task <br/>
List all Task for a user:  GET /api/task/{userId} <br/>
Search Task with keywords: GET /api/task/search/{taskDetails} <br/>
Update Task: PUT /api/task/{taskId}
Delete Task: DELETE /api/task/{taskId}

Sample Request Body:
```javascript
{
  "taskId":"1",
  "userId":"112256",
  "taskDetails":"Take Doctor's Appointment",
  "completed":false,
  "archive":false
}
```

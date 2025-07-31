package com.example.mailbox.model;

public class TaskRequest {
    private String taskId;
    private String payload;

    public TaskRequest() {}

    public TaskRequest(String taskId, String payload) {
        this.taskId = taskId;
        this.payload = payload;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}

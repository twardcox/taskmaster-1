package com.marishaoza.taskmaster.Models;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.util.*;

@DynamoDBTable(tableName = "taskmaster-backend")
public class Task {

    private String id;
    private String title;
    private String description;
    private String status;
    private String assignee;

    private ArrayList<HistoryObj> history;

    public Task() {}

    public Task(String id, String title, String description, String status, String assignee) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.assignee = assignee;
        this.history = new ArrayList<>();
    }

    // ---------------- Getters & Setters ----------------

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @DynamoDBAttribute
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    @DynamoDBAttribute
    public String getDescription() {
        return this.description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    @DynamoDBAttribute
    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    @DynamoDBAttribute
    public String getAssignee() {
        return this.assignee;
    }
    public void setAssignee(String assignee) {
            this.assignee = assignee;
    }

    @DynamoDBAttribute
    public ArrayList<HistoryObj> getHistory() {
        return this.history;
    }
    public void setHistory(ArrayList<HistoryObj> history) {
        this.history = history;
    }


    // ---------------- Methods ----------------

    public void addHistory(HistoryObj historyObj) {
        this.history.add(historyObj);
    }

}

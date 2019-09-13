package com.twardcox.taskmaster.Models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.util.Date;

@DynamoDBDocument
public class HistoryObj {
    private String time;
    private String action;
    private String assignee;

    public HistoryObj(String action){
        this.action = action;
        this.time = new Date(System.currentTimeMillis()).toString();
        this.assignee = "none";
    }

    public HistoryObj(){};

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String toString() {
        return String.format("%s @ %s", this.getAction(), this.getTime());
    }
}

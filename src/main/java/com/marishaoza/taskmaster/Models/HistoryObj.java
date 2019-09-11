package com.marishaoza.taskmaster.Models;

import java.sql.Timestamp;
import java.util.Date;

public class HistoryObj {
    Timestamp time;
    String action;

    public HistoryObj(String action){
        this.action = action;
        Date date = new Date();
        this.time = new Timestamp(date.getTime());
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }


    public String toString() {
        return String.format("%s @ %s", this.getAction(), this.getTime());
    }
}

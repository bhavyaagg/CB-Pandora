package me.bhavyaaggarwal.assignment_listviews.models;

/**
 * Created by bhavyaaggarwal on 22/12/17.
 */

public class Todo {
    String task;
    Boolean done;

    public Todo(String task, Boolean done) {
        this.task = task;
        this.done = done;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}

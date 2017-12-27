package me.bhavyaaggarwal.todolistrecyclerview.models;

/**
 * Created by bhavyaaggarwal on 27/12/17.
 */

public class Todo {
    private String task;
    private boolean done;

    public Todo(String task, boolean done) {
        this.task = task;
        this.done = done;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}

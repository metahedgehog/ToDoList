package com.app.todo;

/**
 * Created by Danil-MAC on 10/23/16.
 */
public class ToDoTask {

    private String taskName;
    private String taskCategory;
    private boolean isCompleted;

    public ToDoTask() {
    }

    public ToDoTask(String taskName, String taskCategory) {
        this.taskName = taskName;
        this.taskCategory = taskCategory;
        isCompleted = false;
    }


    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskCategory() {
        return taskCategory;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
}

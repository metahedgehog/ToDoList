package com.app.todo;

import org.apache.commons.lang3.StringUtils;

public class TaskValidator {

    public static  boolean isValid(ToDoTask task){
        return StringUtils.isNotBlank(task.getTaskName()) && StringUtils.isNotBlank(task.getTaskCategory());
    }
}

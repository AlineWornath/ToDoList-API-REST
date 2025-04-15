package tech.ada.ToDoList_API_REST.service.validation;

import tech.ada.ToDoList_API_REST.model.Task;

public interface TaskValidation {
    void validate(Task task);
}

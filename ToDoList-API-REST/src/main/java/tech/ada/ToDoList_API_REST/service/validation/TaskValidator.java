package tech.ada.ToDoList_API_REST.service.validation;

import tech.ada.ToDoList_API_REST.model.Task;

import java.util.List;

public class TaskValidator {

    private final List<TaskValidation> validations;

    public TaskValidator(List<TaskValidation> validations) {
        this.validations = validations;
    }

    public void validate(Task task) {
        for (TaskValidation validation : validations) {
            validation.validate(task);
        }
    }
}

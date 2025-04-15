package tech.ada.ToDoList_API_REST.service.validation;

import tech.ada.ToDoList_API_REST.model.Task;

public class StatusValidation implements TaskValidation {

    @Override
    public void validate(Task task) {
        if (task.getStatus() == null) {
            throw new IllegalArgumentException("Status inválido: não pode ser nulo.");
        }
    }
}

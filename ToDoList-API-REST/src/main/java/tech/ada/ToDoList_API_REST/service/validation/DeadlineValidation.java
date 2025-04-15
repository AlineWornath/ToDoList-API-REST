package tech.ada.ToDoList_API_REST.service.validation;

import tech.ada.ToDoList_API_REST.model.Task;

import java.time.LocalDate;

public class DeadlineValidation implements TaskValidation {

    @Override
    public void validate(Task task) {
        LocalDate deadline = task.getDeadline();
        if (deadline == null || deadline.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Data inválida: '" + deadline + "'. Deve ser maior ou igual à data atual.");
        }
    }
}

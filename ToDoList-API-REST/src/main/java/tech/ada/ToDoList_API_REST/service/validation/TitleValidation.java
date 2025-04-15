package tech.ada.ToDoList_API_REST.service.validation;

import tech.ada.ToDoList_API_REST.model.Task;

public class TitleValidation implements TaskValidation {

    private static final int MIN_TITLE_LENGTH = 3;

    @Override
    public void validate(Task task) {
        String title = task.getTitle();
        if (title == null || title.isBlank() || title.length() < MIN_TITLE_LENGTH) {
            throw new IllegalArgumentException("Título inválido: '" + title + "'. Deve ter pelo menos " + MIN_TITLE_LENGTH + " caracteres.");
        }
    }
}

package tech.ada.ToDoList_API_REST.view;

public interface View extends AutoCloseable {
    void showMessage(String message);
    String getInput(String prompt);
    Integer getIntInput(String prompt);
}
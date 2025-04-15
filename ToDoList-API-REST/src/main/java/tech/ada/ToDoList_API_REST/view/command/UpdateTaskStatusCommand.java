package tech.ada.ToDoList_API_REST.view.command;

import tech.ada.ToDoList_API_REST.controller.TaskController;
import tech.ada.ToDoList_API_REST.model.Task;
import tech.ada.ToDoList_API_REST.view.View;

public class UpdateTaskStatusCommand implements Command {

    private final View view;
    private final TaskController taskController;

    public UpdateTaskStatusCommand(View view, TaskController taskController) {
        this.view = view;
        this.taskController = taskController;
    }

    @Override
    public void execute() {
        Long id = view.getIntInput("📌 Informe o ID da tarefa para atualizar o status").longValue();
        String status = view.getInput("🔄 Novo status (Pendente, Em andamento, Concluído)");

        try {
            Task updatedTask = taskController.updateTaskStatus(id, Task.Status.fromString(status));
            view.showMessage("✅ Status atualizado com sucesso!");
            view.showMessage(updatedTask.toString());
        } catch (IllegalArgumentException e) {
            view.showMessage("❌ Erro: " + e.getMessage());
        }
    }
}

package tech.ada.ToDoList_API_REST.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Entity
public class Task {

    public Task() {}

    public Task(String title, String description, LocalDate deadline, Status status) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório.")
    @Size(max = 100, message = "O título não pode ter mais de 100 caracteres.")
    private String title;

    @NotBlank(message = "A descrição é obrigatória.")
    @Size(max = 500, message = "A descrição não pode ter mais de 500 caracteres.")
    private String description;

    @NotNull
    @FutureOrPresent(message = "A data de entrega deve ser no futuro ou no presente.")
    private LocalDate deadline;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Status status;

    public enum Status {
        PENDENTE("Pendente"),
        EM_ANDAMENTO("Em andamento"),
        CONCLUIDO("Concluído");

        private final String descricao;

        Status(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }

        public static Status fromString(String status) {
            for (Status s : values()) {
                if (s.descricao.equalsIgnoreCase(status)) {
                    return s;
                }
            }
            throw new IllegalArgumentException("Status inválido: " + status);
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

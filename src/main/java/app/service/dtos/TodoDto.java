package app.service.dtos;

import java.io.Serializable;

public class TodoDto implements Serializable {
    private Long id;
    private String content;
    private boolean completed;

    public TodoDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

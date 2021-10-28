package com.app.service;

import java.io.Serializable;

public class TodoDto implements Serializable {
    private String content;
    private boolean completed;

    public TodoDto() {
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

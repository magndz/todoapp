package com.app.service;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDto implements Serializable {
    private Long userId;
    private String name;
    private String email;
    private List<TodoDto> todoList;

    public UserDto() {
        todoList = new ArrayList<>();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<TodoDto> getTodoList() {
        return todoList;
    }


}

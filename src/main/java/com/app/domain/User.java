package com.app.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String email;
    private String pass;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Todo> todo;

    public User() {
        todo = new ArrayList<>();
    }

    public User(String name, String email, String pass, List<Todo> todo) {
        this.name = name;
        this.email = email;
        this.pass = pass;
        this.todo = todo;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public List<Todo> getTodoList() {
        return todo;
    }

    public void setTodoList(List<Todo> todo) {
        this.todo = todo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", pass='" + pass + '\'' +
                ", todoList=" + todo +
                '}';
    }
}

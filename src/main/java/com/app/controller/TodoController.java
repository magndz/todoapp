package com.app.controller;

import com.app.service.TodoDto;
import com.app.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "todo")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<TodoDto> getTodo() {
        return todoService.getTodos();
    }

    @PostMapping
    public void setTodo(@RequestBody TodoDto dto){
        todoService.setTodo(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
    }

    @PutMapping("/{id}")
    public void updateTodo(@PathVariable Long id, @RequestBody TodoDto todoDto){
        todoService.updateTodo(id, todoDto);
    }
}

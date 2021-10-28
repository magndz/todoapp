package com.app.service;

import com.app.domain.Todo;
import com.app.domain.TodoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    public List<TodoDto> getTodos() {
        return todoRepository.findAll().stream().map(this::mapper).collect(Collectors.toList());
    }

    public Todo setTodo(TodoDto todo){
        return todoRepository.save(modelMapper.map(todo, Todo.class));
    }

    public void deleteTodo(Long id){
        todoRepository.deleteById(id);
    }

    public void updateTodo(Long id, TodoDto todoDto){
        Todo todoTemp = todoRepository.getById(id);
        todoTemp.setContent(todoDto.getContent());
        todoTemp.setCompleted(todoDto.isCompleted());
        todoRepository.save(todoTemp);
    }

    private TodoDto mapper(Todo todo){
        return (modelMapper.map(todo, TodoDto.class));
    }
}

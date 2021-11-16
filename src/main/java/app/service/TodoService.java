package app.service;

import app.domain.Todo;
import app.repository.TodoRepository;
import app.service.Iface.ITodoService;
import app.service.dtos.TodoDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TodoService implements ITodoService {
    private final TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Autowired
    private ModelMapper modelMapper;

    private TodoDto mapper(Todo todo){
        return (modelMapper.map(todo, TodoDto.class));
    }

    @Override
    public void add(TodoDto todoDto) {
        todoRepository.save(modelMapper.map(todoDto, Todo.class));
    }

    @Override
    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    public void update(Long id, TodoDto todoDto) {
        Todo todoTemp = todoRepository.getById(id);
        todoTemp.setContent(todoDto.getContent());
        todoTemp.setCompleted(todoDto.isCompleted());
        todoRepository.save(todoTemp);
    }

    @Override
    public List<TodoDto> getAll() {
        return todoRepository.findAll().stream().map(this::mapper).collect(Collectors.toList());
    }
}

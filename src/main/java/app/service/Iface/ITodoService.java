package app.service.Iface;

import app.service.dtos.TodoDto;

import java.util.List;

public interface ITodoService {
    public void add(TodoDto todoDto);
    public void delete(Long id);
    public void update(Long id, TodoDto todoDto);
    public List<TodoDto> getAll();
}

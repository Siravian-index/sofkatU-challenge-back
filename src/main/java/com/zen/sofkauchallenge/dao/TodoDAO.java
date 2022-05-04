package com.zen.sofkauchallenge.dao;

import com.zen.sofkauchallenge.entity.Todo;
import com.zen.sofkauchallenge.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoDAO implements ITodoDAO{

    private final TodoRepository todoRepository;

    @Autowired
    public TodoDAO(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo addTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Todo todo) {
        todoRepository.deleteById(todo.getId());
    }
}

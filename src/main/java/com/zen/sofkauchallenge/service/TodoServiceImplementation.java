package com.zen.sofkauchallenge.service;

import com.zen.sofkauchallenge.dao.TodoDAO;
import com.zen.sofkauchallenge.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoServiceImplementation implements ITodoService {
    private final TodoDAO todoDAO;

    @Autowired
    public TodoServiceImplementation(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    @Override
    public Todo addTodo(Todo todo) {
//        Add business logic
        return todoDAO.addTodo(todo);
    }

    @Override
    public Todo updateTodo(Todo todo) {
//        Add business logic
        return todoDAO.updateTodo(todo);
    }

    @Override
    public Boolean deleteTodo(Long id) {
        Optional<Todo> optionalTodo = todoDAO.findById(id);
        Todo todo = optionalTodo.orElseThrow();
        todoDAO.deleteTodo(todo.getId());
        return true;
    }
}

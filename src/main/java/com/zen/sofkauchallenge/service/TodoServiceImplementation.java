package com.zen.sofkauchallenge.service;

import com.zen.sofkauchallenge.dao.TodoDAO;
import com.zen.sofkauchallenge.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImplementation implements ITodoService {
    private final TodoDAO todoDAO;

    @Autowired
    public TodoServiceImplementation(TodoDAO todoDAO) {
        this.todoDAO = todoDAO;
    }

    @Override
    public Todo addTodo(Todo todo) {
        return null;
    }

    @Override
    public Todo updateTodo(Todo todo) {
        return null;
    }

    @Override
    public Boolean deleteTodo(Long id) {
        return null;
    }
}

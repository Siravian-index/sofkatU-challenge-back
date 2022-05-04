package com.zen.sofkauchallenge.service;

import com.zen.sofkauchallenge.entity.Todo;

public interface ITodoService {
    Todo addTodo(Todo todo);
    Todo updateTodo(Todo todo);
    Boolean deleteTodo(Long id);
}

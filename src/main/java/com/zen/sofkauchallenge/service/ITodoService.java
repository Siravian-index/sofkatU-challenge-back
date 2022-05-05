package com.zen.sofkauchallenge.service;

import com.zen.sofkauchallenge.entity.Category;
import com.zen.sofkauchallenge.entity.Todo;

public interface ITodoService {
    Category addTodo(Todo todo);
    Todo updateTodo(Todo todo);
    boolean deleteTodo(Long id);
}

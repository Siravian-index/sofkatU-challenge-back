package com.zen.sofkauchallenge.dao;

import com.zen.sofkauchallenge.entity.Todo;

import java.util.Optional;

public interface ITodoDAO {
    Todo addTodo(Todo todo);
    Todo updateTodo(Todo todo);
    void deleteTodo(Long id);
    Optional<Todo> findById(Long id);

    Todo saveTodo(Todo todo);
}

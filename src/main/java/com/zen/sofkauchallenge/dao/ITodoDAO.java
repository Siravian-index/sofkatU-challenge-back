package com.zen.sofkauchallenge.dao;

import com.zen.sofkauchallenge.entity.Todo;

public interface ITodoDAO {
    Todo addTodo(Todo todo);
    Todo updateTodo(Todo todo);
    Boolean deleteTodo(Todo todo);
}

package com.zen.sofkauchallenge.service;

import com.zen.sofkauchallenge.dao.CategoryDAO;
import com.zen.sofkauchallenge.dao.TodoDAO;
import com.zen.sofkauchallenge.entity.Category;
import com.zen.sofkauchallenge.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TodoServiceImplementation implements ITodoService {
    private final TodoDAO todoDAO;
    private final CategoryDAO categoryDAO;

    @Autowired
    public TodoServiceImplementation(TodoDAO todoDAO, CategoryDAO categoryDAO) {
        this.todoDAO = todoDAO;
        this.categoryDAO = categoryDAO;
    }

    @Override
    public Category addTodo(Todo todo) {
        Optional<Category> categoryOptional = categoryDAO.findById(todo.getCategoryFK());
        if (categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.addTodo(todo);
            todoDAO.saveTodo(todo);
            return categoryDAO.saveCategory(category);
        }
        return null;
    }


    @Override
    public Todo updateTodo(Todo todo) {
        return todoDAO.updateTodo(todo);
    }

    @Override
    public boolean deleteTodo(Long id) {
        Optional<Todo> optionalTodo = todoDAO.findById(id);
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todoDAO.deleteTodo(todo.getId());
            return true;
        }
        return false;
    }

}

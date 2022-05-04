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
    public Todo addTodo(Todo todo) {
//        Validate to-do!!
        Optional<Category> categoryOptional = categoryDAO.findById(todo.getCategoryFK());
        Category category = categoryOptional.orElseThrow();
        category.addTodo(todo);
        categoryDAO.saveCategory(category);
        return todoDAO.saveTodo(todo);
    }


    @Override
    public Todo updateTodo(Todo todo) {
//        Add business logic
//        Validate to-do!!
        return todoDAO.updateTodo(todo);
    }

    @Override
    public Boolean deleteTodo(Long id) {
//        remove this to-do from the category list
        Optional<Todo> optionalTodo = todoDAO.findById(id);
        Todo todo = optionalTodo.orElseThrow();
        todoDAO.deleteTodo(todo.getId());
        return true;
    }
}

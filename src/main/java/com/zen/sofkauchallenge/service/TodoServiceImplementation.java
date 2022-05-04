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
        boolean todoIntegrity = validateTodoIntegrity(todo);
        System.out.println("todo i " + todoIntegrity);
        Optional<Category> categoryOptional = categoryDAO.findById(todo.getCategoryFK());
        System.out.println("optional: " + categoryOptional);
        if (todoIntegrity && categoryOptional.isPresent()) {
            Category category = categoryOptional.get();
            category.addTodo(todo);
            categoryDAO.saveCategory(category);
            return todoDAO.saveTodo(todo);
        }
        return null;
    }


    @Override
    public Todo updateTodo(Todo todo) {
        boolean todoIntegrity = validateTodoIntegrity(todo);
        if (todoIntegrity) {
            return todoDAO.updateTodo(todo);
        }
        return null;
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

    private boolean validateTodoIntegrity(Todo todo) {
        return todo != null && todo.getTitle() != null && todo.getTitle().length() > 0;
    }
}

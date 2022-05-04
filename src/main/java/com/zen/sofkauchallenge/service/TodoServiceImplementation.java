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
        Boolean todoIntegrity = validateTodoIntegrity(todo);
        if (todoIntegrity) {
            Optional<Category> categoryOptional = categoryDAO.findById(todo.getCategoryFK());
            Category category = categoryOptional.orElseThrow();
            category.addTodo(todo);
            categoryDAO.saveCategory(category);
            return todoDAO.saveTodo(todo);
        }
        return null;
    }


    @Override
    public Todo updateTodo(Todo todo) {
        Boolean todoIntegrity = validateTodoIntegrity(todo);
        if (todoIntegrity) {
            return todoDAO.updateTodo(todo);
        }
        return null;
    }

    @Override
    public Boolean deleteTodo(Long id) {
        Optional<Todo> optionalTodo = todoDAO.findById(id);
        Todo todo = optionalTodo.orElseThrow();
        todoDAO.deleteTodo(todo.getId());
        return true;
    }

    private Boolean validateTodoIntegrity(Todo todo) {
       Boolean correctTitle =  todo != null && todo.getTitle() != null && todo.getTitle().length() > 0;
       Boolean validIsDone = todo != null && todo.getIsDone() != null;
       return correctTitle && validIsDone;
    }
}

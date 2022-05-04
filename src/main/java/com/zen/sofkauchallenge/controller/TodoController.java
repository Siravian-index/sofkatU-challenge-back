package com.zen.sofkauchallenge.controller;

import com.zen.sofkauchallenge.entity.Todo;
import com.zen.sofkauchallenge.service.TodoServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/todos")
public class TodoController {

    private final TodoServiceImplementation todoService;

    @Autowired
    public TodoController(TodoServiceImplementation todoService) {
        this.todoService = todoService;
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @PutMapping
    public Todo updateTodo(@RequestBody Todo todo) {
        return todoService.updateTodo(todo);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteTodo(@PathVariable Long id) {
        return todoService.deleteTodo(id);
    }

}

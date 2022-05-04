package com.zen.sofkauchallenge.controller;

import com.zen.sofkauchallenge.entity.Todo;
import com.zen.sofkauchallenge.service.TodoServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo todoCreated = todoService.addTodo(todo);
        if (todoCreated != null) {
//            201
            return new ResponseEntity<>(todoCreated, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
        Todo todoUpdated = todoService.updateTodo(todo);
        if (todoUpdated != null) {
            return new ResponseEntity<>(todoUpdated, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTodo(@PathVariable Long id) {
        Boolean wasDeleted = todoService.deleteTodo(id);
        if (wasDeleted) {
            return new ResponseEntity<>(wasDeleted, HttpStatus.OK);
        }
        return new ResponseEntity<>(wasDeleted, HttpStatus.NOT_FOUND);
    }

}

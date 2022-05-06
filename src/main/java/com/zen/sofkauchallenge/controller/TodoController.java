package com.zen.sofkauchallenge.controller;

import com.zen.sofkauchallenge.dto.CategoryDTO;
import com.zen.sofkauchallenge.dto.TodoDTO;
import com.zen.sofkauchallenge.entity.Category;
import com.zen.sofkauchallenge.entity.Todo;
import com.zen.sofkauchallenge.service.TodoServiceImplementation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static com.zen.sofkauchallenge.controller.CategoryController.getStringStringMap;

@RestController
@RequestMapping("api/v1/todos")
@CrossOrigin(origins = "http://localhost:3000/")
public class TodoController {

    private final TodoServiceImplementation todoService;
    private final ModelMapper modelMapper;

    @Autowired
    public TodoController(TodoServiceImplementation todoService, ModelMapper modelMapper) {
        this.todoService = todoService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createTodo(@Valid @RequestBody TodoDTO todoDTO) {
        Todo postTodo = modelMapper.map(todoDTO, Todo.class);
        Category todoCreated = todoService.addTodo(postTodo);
        if (todoCreated != null) {
            CategoryDTO postResponse = modelMapper.map(todoCreated, CategoryDTO.class);
            return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
        }
        System.out.println("custom validation");
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    public ResponseEntity<TodoDTO> updateTodo(@Valid @RequestBody TodoDTO todoDTO) {
        Todo putTodo = modelMapper.map(todoDTO, Todo.class);
        Todo todoUpdated = todoService.updateTodo(putTodo);
        if (todoUpdated != null) {
            TodoDTO putResponse = modelMapper.map(todoUpdated, TodoDTO.class);
            return new ResponseEntity<>(putResponse, HttpStatus.OK);
        }
        System.out.println("custom validation");

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTodo(@PathVariable Long id) {
        boolean wasDeleted = todoService.deleteTodo(id);
        if (wasDeleted) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        return getStringStringMap(ex);
    }

}

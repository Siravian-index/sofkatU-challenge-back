package com.zen.sofkauchallenge.controller;

import com.zen.sofkauchallenge.dto.CategoryDTO;
import com.zen.sofkauchallenge.entity.Category;
import com.zen.sofkauchallenge.service.CategoryServiceImplementation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/categories")
@CrossOrigin(origins = "http://localhost:3000/")
public class CategoryController {

    private final CategoryServiceImplementation categoryService;
    private final ModelMapper modelMapper;

    @Autowired
    public CategoryController(CategoryServiceImplementation categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() {
        return categoryService.getAllCategories().stream().map(category -> modelMapper.map(category, CategoryDTO.class)).collect(Collectors.toList());
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        Category postCategory = modelMapper.map(categoryDTO, Category.class);
        Category categoryCreated = categoryService.createCategory(postCategory);
        if (categoryCreated != null) {
            CategoryDTO postResponse = modelMapper.map(categoryCreated, CategoryDTO.class);
            return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCategory(@PathVariable Long id) {
        boolean wasDeleted = categoryService.deleteCategory(id);
        if (wasDeleted) {
            return new ResponseEntity<>(wasDeleted, HttpStatus.OK);
        }
        return new ResponseEntity<>(wasDeleted, HttpStatus.NOT_FOUND);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        return getStringStringMap(ex);
    }

    static Map<String, String> getStringStringMap(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

}

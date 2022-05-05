package com.zen.sofkauchallenge.controller;

import com.zen.sofkauchallenge.entity.Category;
import com.zen.sofkauchallenge.service.CategoryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
@CrossOrigin(origins = "http://localhost:3000/")
public class CategoryController {

    private final CategoryServiceImplementation categoryService;

    @Autowired
    public CategoryController(CategoryServiceImplementation categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody Category category) {
        Category categoryCreated = categoryService.createCategory(category);
        if (categoryCreated != null) {
//           return status 201
            return new ResponseEntity<>(categoryCreated, HttpStatus.CREATED);
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

}

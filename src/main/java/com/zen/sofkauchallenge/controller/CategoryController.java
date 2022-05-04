package com.zen.sofkauchallenge.controller;

import com.zen.sofkauchallenge.entity.Category;
import com.zen.sofkauchallenge.service.CategoryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/categories")
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
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCategory(@PathVariable Long id) {
        return categoryService.deleteCategory(id);
    }

}

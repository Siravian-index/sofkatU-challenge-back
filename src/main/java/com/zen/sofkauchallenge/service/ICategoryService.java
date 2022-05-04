package com.zen.sofkauchallenge.service;

import com.zen.sofkauchallenge.entity.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> getAllCategories();
    Category createCategory(Category category);
    Boolean deleteCategory(Long id);
}

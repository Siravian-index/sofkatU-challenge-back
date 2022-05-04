package com.zen.sofkauchallenge.dao;

import com.zen.sofkauchallenge.entity.Category;

import java.util.List;

public interface ICategoryDAO {
    List<Category> getAllCategories();
    Category createCategory(Category category);
    void deleteCategory(Long id);
}
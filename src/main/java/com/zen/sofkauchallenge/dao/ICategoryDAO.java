package com.zen.sofkauchallenge.dao;

import com.zen.sofkauchallenge.entity.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryDAO {
    List<Category> getAllCategories();
    Category createCategory(Category category);
    void deleteCategory(Long id);
    Optional<Category> findById(Long id);

    Category saveCategory(Category category);
}
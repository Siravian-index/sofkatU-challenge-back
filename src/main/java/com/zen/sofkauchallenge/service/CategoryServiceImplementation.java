package com.zen.sofkauchallenge.service;

import com.zen.sofkauchallenge.dao.CategoryDAO;
import com.zen.sofkauchallenge.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImplementation implements ICategoryService {

    private final CategoryDAO categoryDAO;

    @Autowired
    public CategoryServiceImplementation(CategoryDAO categoryDAO) {
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDAO.getAllCategories();
    }

    @Override
    public Category createCategory(Category category) {
        return categoryDAO.createCategory(category);
    }

    @Override
    public Boolean deleteCategory(Long id) {
        Optional<Category> optionalCategory = categoryDAO.findById(id);
        Category category = optionalCategory.orElseThrow();
        categoryDAO.deleteCategory(category.getId());
        return true;
    }
}

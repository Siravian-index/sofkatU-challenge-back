package com.zen.sofkauchallenge.service;

import com.zen.sofkauchallenge.dao.CategoryDAO;
import com.zen.sofkauchallenge.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
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
        if (category.getTitle() != null && !Objects.equals(category.getTitle(), "")) {
            return categoryDAO.createCategory(category);
        }
        return null;
    }

    @Override
    public boolean deleteCategory(Long id) {
        Optional<Category> optionalCategory = categoryDAO.findById(id);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            categoryDAO.deleteCategory(category.getId());
            return true;
        }
        return false;
    }
}

package com.zen.sofkauchallenge.repository;

import com.zen.sofkauchallenge.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

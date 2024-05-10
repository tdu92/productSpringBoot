package com.codegym.productspringboot.repository;

import com.codegym.productspringboot.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}

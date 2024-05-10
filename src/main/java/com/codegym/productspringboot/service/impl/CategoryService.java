package com.codegym.productspringboot.service.impl;

import com.codegym.productspringboot.model.Category;
import com.codegym.productspringboot.repository.CategoryRepository;
import com.codegym.productspringboot.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRep;

    @Override
    public List<Category> findAll() {
        return categoryRep.findAll();
    }

    @Override
    public Category findById(Long id) {
        Optional<Category> category = categoryRep.findById(id);
        return category.get();
    }

    @Override
    public void save(Category category) {
        categoryRep.save(category);
    }

    @Override
    public void remove(Long id) {
        categoryRep.deleteById(id);
    }
}

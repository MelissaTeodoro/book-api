package com.read.book.api.service;

import com.read.book.api.domain.Category;
import com.read.book.api.repository.CategoryRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public Category findById(Integer id) {
    Optional<Category> categoryOptional = categoryRepository.findById(id);
    return categoryOptional.orElse(null);
  }

}

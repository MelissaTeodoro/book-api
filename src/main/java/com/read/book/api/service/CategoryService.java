package com.read.book.api.service;

import com.read.book.api.domain.Category;
import com.read.book.api.dto.CategoryDTO;
import com.read.book.api.exception.NotFoundException;
import com.read.book.api.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  public Category findById(Integer id) {
    Optional<Category> categoryOptional = categoryRepository.findById(id);

    return categoryOptional.orElseThrow(() -> new NotFoundException(
            String.format("Category not found for id:%s and type:%s", id, Category.class.getName())
        )
    );
  }

  public List<Category> findAll() {
    return categoryRepository.findAll();
  }

  public Category create(Category category) {
    category.setId(null);

    return categoryRepository.save(category);
  }

  public Category update(Integer id, CategoryDTO categoryDTO) {
    final Category category = findById(id);
    category.setName(category.getName());
    category.setDescription(categoryDTO.getDescription());

    return categoryRepository.save(category);
  }

  public void delete(Integer id) {
    findById(id);

    try {
      categoryRepository.deleteById(id);
    } catch (DataIntegrityViolationException e) {
      throw new com.read.book.api.exception.DataIntegrityViolationException(
          "Category cannot be deleted because it has associated books"
      );
    }
  }
}

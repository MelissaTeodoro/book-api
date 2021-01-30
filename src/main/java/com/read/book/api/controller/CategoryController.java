package com.read.book.api.controller;

import com.read.book.api.domain.Category;
import com.read.book.api.dto.CategoryDTO;
import com.read.book.api.service.CategoryService;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Category> findById(@PathVariable Integer id) {
    final Category category = categoryService.findById(id);
    return ResponseEntity.ok().body(category);
  }

  @GetMapping
  public ResponseEntity<List<CategoryDTO>> findAll() {
    final List<Category> categories = categoryService.findAll();
    final List<CategoryDTO> categoryDTOS = categories
        .stream().map(CategoryDTO::new)
        .collect(Collectors.toList());

    return ResponseEntity.ok().body(categoryDTOS);
  }

  @PostMapping
  public ResponseEntity<Category> create(@RequestBody Category category) {
    category = categoryService.create(category);
    URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
        .buildAndExpand(category.getId()).toUri();

    return ResponseEntity.created(uri).body(category);
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<CategoryDTO> update(@PathVariable Integer id, @RequestBody CategoryDTO categoryDTO) {
    Category newCategory = categoryService.update(id, categoryDTO);
    return ResponseEntity.ok().body(new CategoryDTO(newCategory));
  }

}

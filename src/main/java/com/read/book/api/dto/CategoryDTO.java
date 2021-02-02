package com.read.book.api.dto;

import com.read.book.api.domain.Category;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

public class CategoryDTO {

  private Integer id;

  @NotEmpty(message = "Field NAME is required")
  @Length(min = 3, max = 100, message = "Field NAME must have at least 3 maximum 100 characters")
  private String name;

  @NotEmpty(message = "Field DESCRIPTION is required")
  @Length(min = 3, max = 200, message = "Field DESCRIPTION must have at least 3 maximum 200 characters")
  private String description;

  public CategoryDTO() {
  }

  public CategoryDTO(Category category) {
    this.id = category.getId();
    this.name = category.getName();
    this.description = category.getDescription();
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}

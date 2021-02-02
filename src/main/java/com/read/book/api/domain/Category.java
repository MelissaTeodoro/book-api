package com.read.book.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

@Entity
public class Category implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotEmpty(message = "Field NAME is required")
  @Length(min = 3, max = 100, message = "Field NAME must have at least 3 maximum 100 characters")
  private String name;

  @NotEmpty(message = "Field DESCRIPTION is required")
  @Length(min = 3, max = 200, message = "Field DESCRIPTION must have at least 3 maximum 200 characters")
  private String description;

  @OneToMany(mappedBy = "category")
  private List<Book> books = new ArrayList<>();

  public Category() {
    super();
  }

  public Category(Integer id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
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

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Category category = (Category) o;
    return id.equals(category.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

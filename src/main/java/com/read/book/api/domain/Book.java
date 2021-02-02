package com.read.book.api.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import org.hibernate.validator.constraints.Length;

@Entity
public class Book implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @NotEmpty(message = "Field TITLE is required")
  @Length(min = 3, max = 50, message = "Field TITLE must have at least 3 maximum 50 characters")
  private String title;

  @NotEmpty(message = "Field AUTHOR NAME is required")
  @Length(min = 3, max = 50, message = "Field AUTHOR NAME must have at least 3 maximum 50 characters")
  private String authorName;

  @NotEmpty(message = "Field TEXT is required")
  @Length(min = 3, max = 2000000, message = "Field TEXT must have at least 3 maximum 2.000.000 characters")
  private String text;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;

  public Book() {
    super();
  }

  public Book(Integer id, String title, String authorName, String text, Category category) {
    this.id = id;
    this.title = title;
    this.authorName = authorName;
    this.text = text;
    this.category = category;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setAuthorName(String authorName) {
    this.authorName = authorName;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Category getCategory() {
    return category;
  }

  public void setCategory(Category category) {
    this.category = category;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Book book = (Book) o;
    return id.equals(book.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }
}

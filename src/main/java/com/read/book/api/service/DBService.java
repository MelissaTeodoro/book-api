package com.read.book.api.service;

import com.read.book.api.domain.Book;
import com.read.book.api.domain.Category;
import com.read.book.api.repository.BookRepository;
import com.read.book.api.repository.CategoryRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DBService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private BookRepository bookRepository;

  public void instantiateDataBase() {
    Category cat1 = new Category(null, "Computing", "TI Books");
    Category cat2 = new Category(null, "Science Fiction", "Science Fiction Books");
    Category cat3 = new Category(null, "Self Help", "Self Help Books");
    Category cat4 = new Category(null, "Adventure", "Adventure Books");

    Book book1 = new Book(null, "Clean Architecture", "Robert Martin", "Test", cat1);
    Book book2 = new Book(null, "Clean Code", "Robert Martin", "Test", cat1);
    Book book3 = new Book(null, "Harry Potter", "J. K. Rowling", "Test", cat4);
    Book book4 = new Book(null, "Narnia", "C. S. Lewis", "Test", cat4);

    cat1.getBooks().addAll(Arrays.asList(book1, book2));
    cat4.getBooks().addAll(Arrays.asList(book3, book4));

    this.categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
    this.bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4));
  }
}

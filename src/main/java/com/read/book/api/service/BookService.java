package com.read.book.api.service;

import com.read.book.api.domain.Book;
import com.read.book.api.exception.NotFoundException;
import com.read.book.api.repository.BookRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  public Book findById(Integer id) {
    final Optional<Book> bookOptional = bookRepository.findById(id);

    return bookOptional.orElseThrow(() -> new NotFoundException(
            String.format("Book not found for id:%s and type:%s", id, Book.class.getName())
        )
    );
  }

  public List<Book> findAll(Integer idCategory) {
    findById(idCategory);

    return bookRepository.findAllByCategory(idCategory);
  }

  public Book update(Integer id, Book book) {
    final Book newBook = findById(id);
    updateData(newBook, book);

    return bookRepository.save(newBook);
  }

  private void updateData(Book newBook, Book book) {
    newBook.setTitle(book.getTitle());
    newBook.setAuthorName(book.getAuthorName());
    newBook.setText(book.getText());
  }
}

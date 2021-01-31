package com.read.book.api.controller;

import com.read.book.api.domain.Book;
import com.read.book.api.dto.BookDTO;
import com.read.book.api.service.BookService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Book> findById(@PathVariable Integer id) {
    final Book book = bookService.findById(id);

    return ResponseEntity.ok().body(book);
  }

  @GetMapping
  public ResponseEntity<List<BookDTO>> findAll(@RequestParam(value = "category", defaultValue = "0") Integer idCategory) {
    final List<Book> books = bookService.findAll(idCategory);
    final List<BookDTO> bookDTOS = books
        .stream()
        .map(BookDTO::new)
        .collect(Collectors.toList());

    return ResponseEntity.ok().body(bookDTOS);
  }

  @PutMapping(value = "{id}")
  public ResponseEntity<Book> update(@PathVariable Integer id, @RequestBody Book book) {
    final Book newBook = bookService.update(id, book);

    return ResponseEntity.ok().body(newBook);
  }

}
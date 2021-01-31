package com.read.book.api.repository;

import com.read.book.api.domain.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

  @Query("SELECT obj FROM Book obj WHERE obj.category.id = :category_id ORDER BY title")
  List<Book> findAllByCategory(@Param(value = "category_id") Integer category_id);
}

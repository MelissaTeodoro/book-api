package com.read.book.api;

import com.read.book.api.domain.Book;
import com.read.book.api.domain.Category;
import com.read.book.api.repositories.BookRepository;
import com.read.book.api.repositories.CategoryRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookApiApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category cat1 = new Category(null, "Computing", "TI Books");
		Book book1 = new Book(null, "Clean Architecture", "Robert Martin", "-", cat1);

		cat1.getBooks().addAll(Arrays.asList(book1));
		this.categoryRepository.saveAll(Arrays.asList(cat1));
		this.bookRepository.saveAll(Arrays.asList(book1));

	}
}

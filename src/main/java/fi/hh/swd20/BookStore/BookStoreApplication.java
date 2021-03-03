package fi.hh.swd20.BookStore;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import fi.hh.swd20.BookStore.Domain.BookRepository;
import fi.hh.swd20.BookStore.Domain.Book;
import fi.hh.swd20.BookStore.Domain.Category;
import fi.hh.swd20.BookStore.Domain.CategoryRepository;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner test(CategoryRepository crepository, BookRepository brepository) {
		return (args) -> {

			Category c1 = new Category("Horror");
			Category c2 = new Category("Sci-fi");

			crepository.save(c1);
			crepository.save(c2);

			brepository.save(new Book("Hohto", "Stephen King", 1977, "951-0-12904-6", 20.50, c1));
			brepository.save(new Book("Tohtori Uni", "Stephen King", 2013, "978-951-31-7332-6", 14.99, c2));
			
			
		};
	}
}

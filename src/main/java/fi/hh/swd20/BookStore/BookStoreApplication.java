package fi.hh.swd20.BookStore;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import fi.hh.swd20.BookStore.Domain.BookRepository;
import fi.hh.swd20.BookStore.Domain.Book;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	//title, author, year, isbn, price
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
     
	 Book b1 = new Book ("Hohto", "Stephen King", 1977, "951-0-12904-6", 20.50);
	 Book b2 = new Book ("Tohtori Uni", "Stephen King", 2013, "978-951-31-7332-6", 14.99);
	 
	 repository.save(b1);
	 repository.save(b2);
	};
	}
	
}

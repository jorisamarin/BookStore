package fi.hh.swd20.BookStore.Domain;


import org.springframework.data.repository.CrudRepository;


public interface BookRepository extends CrudRepository<Book, Long> {
	
	

}
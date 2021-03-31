package fi.hh.swd20.BookStore.Web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.swd20.BookStore.Domain.BookRepository;
import fi.hh.swd20.BookStore.Domain.Category;
import fi.hh.swd20.BookStore.Domain.CategoryRepository;
import fi.hh.swd20.BookStore.Domain.Book;

@CrossOrigin
@Controller
public class BookController {
	

	@RequestMapping("/index")
	public String index() {
		
		return "index";
		
	}
	
	@Autowired
	BookRepository bookRepository; 
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	public String getBooks(Model model) {
			List<Book> books =  (List<Book>) bookRepository.findAll();
			model.addAttribute("books", books); 
			return "booklist"; 
								
	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addbook";
	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
		bookRepository.save(book);
		return "redirect:/booklist";
	}
	
	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value = "/editbook/{id}", method = RequestMethod.GET)
	public String editBook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", bookRepository.findById(bookId));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editbook";
	}
	
	@RequestMapping(value = "/editbook/{id}", method = RequestMethod.POST)
	public String saveEdited(@ModelAttribute Book book) {
		bookRepository.save(book);
		return "redirect:../booklist";
	}
	
	@RequestMapping(value="/books", method = RequestMethod.GET)
    public @ResponseBody List<Book> bookListRest() {	
        return (List<Book>) bookRepository.findAll();
    }    
	
	@RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {	
    	return bookRepository.findById(bookId);
    }   
	
	@RequestMapping(value="/books", method = RequestMethod.POST)
    public @ResponseBody Book saveBookRest(@RequestBody Book book) {	
    	return bookRepository.save(book);
    }

	
}

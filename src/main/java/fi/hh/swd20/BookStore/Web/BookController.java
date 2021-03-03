package fi.hh.swd20.BookStore.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.swd20.BookStore.Domain.BookRepository;
import fi.hh.swd20.BookStore.Domain.Book;

@Controller
public class BookController {
	

	@RequestMapping("/index")
	public String index() {
		
		return "index";
		
	}
	
	@Autowired
	BookRepository bookRepository; 
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public String getBooks(Model model) {
			List<Book> books =  (List<Book>) bookRepository.findAll();
			model.addAttribute("books", books); // välitetään kirjalista templatelle model-olion avulla
			return "booklist"; 
								
	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String getNewBookForm(Model model) {
		model.addAttribute("book", new Book()); // "tyhjä" kirja-olio
		return "addbook";
	}
	
	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String saveBook(@ModelAttribute Book book) {
		// talletetaan yhden auton tiedot tietokantaan
		bookRepository.save(book);
		return "redirect:/books";
	}
	
	@RequestMapping(value = "/deletebook/{id}", method = RequestMethod.GET)
	public String deleteBook(@PathVariable("id") Long bookId) {
		bookRepository.deleteById(bookId);
		return "redirect:../books";
	}

	
}

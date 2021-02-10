package fi.hh.swd20.BookStore.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.swd20.BookStore.Domain.Book;

@Controller
public class BookController {
	

	@RequestMapping("/index")
	public String index() {
		
		return "index";
		
	}
}

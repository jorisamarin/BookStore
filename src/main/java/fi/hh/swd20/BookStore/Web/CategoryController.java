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

import fi.hh.swd20.BookStore.Domain.Book;
import fi.hh.swd20.BookStore.Domain.Category;
import fi.hh.swd20.BookStore.Domain.CategoryRepository;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value = "/categories", method = RequestMethod.GET)
	public String getCategories(Model model) {
			List<Category> categories =  (List<Category>) categoryRepository.findAll();
			model.addAttribute("categories", categories); 
			return "categorylist"; 
								
	}
	
	@RequestMapping(value = "/addcategory", method = RequestMethod.GET)
	public String getNewCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	   
	
	@RequestMapping(value = "/addcategory", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute Category category) {
		
		categoryRepository.save(category);
		return "redirect:/categories";
	}
	
	@RequestMapping(value = "/deletecategory/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") Long categoryId) {
		categoryRepository.deleteById(categoryId);
		return "redirect:../categories";
	}
	

}

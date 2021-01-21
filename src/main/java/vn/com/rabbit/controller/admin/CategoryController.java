package vn.com.rabbit.controller.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import vn.com.rabbit.entity.Category;
import vn.com.rabbit.service.CategoryService;
import vn.com.rabbit.service.model.ModelBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping(value = "/quan-tri/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping(value = "")
	public String categoryPage(Model model,
			@RequestParam(defaultValue = "", value = "tu-khoa") String name,
			@RequestParam(defaultValue = "1") Integer pageNo,
			@RequestParam(defaultValue = "15") Integer pageSize,
			@RequestParam(defaultValue = "DESC") String sortType,
			@RequestParam(defaultValue = "name") String sortBy,
			HttpSession session) {
		ModelBase<Category> categoryMess = categoryService.getAllCategorys(pageNo, pageSize, name, sortType, sortBy);
		model.addAttribute("categoryModel", categoryMess);
		model.addAttribute("activeCategory", "active");
		return "admin/bl_category";
	}

	@PostMapping(value = "/add-update-category")
	public String saveAndUpdate(HttpServletRequest request, Principal principal) {
		categoryService.saveAndUpdate(request, principal);
		System.out.println("add or update thanh cong category thanh cong");
		return "redirect:" + request.getHeader("Referer");
	}

	@GetMapping(value = "/get-category-by-id")
	public @ResponseBody String getCategory(HttpServletRequest request) throws JsonProcessingException {
		Optional<Category> category = categoryService.getOneCategoryById(request);
		
		ObjectMapper mapper = new ObjectMapper();
		System.out.println(category.get().getName());
		return mapper.writeValueAsString(category.get());
	}
	
	@RequestMapping(value = "/xoa-the-loai", method = RequestMethod.POST)
	public String deleteCategory(HttpServletRequest request, HttpSession session) {
		
		String name = request.getParameter("name");
		session.setAttribute("delete", name);
		
		categoryService.deleteCategory(request);
		System.out.println("xóa thành công "+ request.getParameter("name"));

		return "redirect:" +  request.getHeader("Referer");
	}
	
}

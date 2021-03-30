package vn.com.rabbit.controller.admin;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import vn.com.rabbit.common.Helper;
import vn.com.rabbit.entity.Category;
import vn.com.rabbit.service.CategoryService;

@Controller
@RequestMapping(value = "/quan-tri/category")
public class CategoryController  {

	
	private final CategoryService categoryService;
	
	public CategoryController(CategoryService service) {

		this.categoryService = service;
	}

	@PostMapping(value = "/add-update-category")
	public String saveAndUpdate(HttpServletRequest request, Principal principal) {

		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Category category = new Category();

		category.setName(name);
		category.setUrl(Helper.pathVariableString(name));
		category.setDescription(description);
		category.setLocked(false);

		//categoryService.saveAndUpdate(category);
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
		UUID id = UUID.fromString(request.getParameter("id"));
		session.setAttribute("delete", name);

		//categoryService.deleteCategory(id);
		System.out.println("xóa thành công " + request.getParameter("name"));

		return "redirect:" + request.getHeader("Referer");
	}

}

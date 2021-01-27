package vn.com.rabbit.controller.admin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import vn.com.rabbit.base.controller.BaseCrudImplController;
import vn.com.rabbit.base.jpa.JpaService;
import vn.com.rabbit.common.Helper;
import vn.com.rabbit.entity.Category;
import vn.com.rabbit.service.CategoryService;
import vn.com.rabbit.service.model.ModelBase;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping(value = "/quan-tri/category")
public class CategoryController extends BaseCrudImplController<Category> {

	
	private final CategoryService categoryService;
	
	protected CategoryController(CategoryService service) {
		super(service);
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

		categoryService.add(category);
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

		categoryService.delete(id);
		System.out.println("xóa thành công " + request.getParameter("name"));

		return "redirect:" + request.getHeader("Referer");
	}

	@Override
	public String postAdd(HttpServletRequest request, Principal principal) throws Exception {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		Category category = new Category();

		category.setName(name);
		category.setUrl(Helper.pathVariableString(name));
		category.setDescription(description);
		category.setLocked(false);

		categoryService.add(category);
		System.out.println("add or update thanh cong category thanh cong");
		return "redirect:" + request.getHeader("Referer");
	}

	@Override
	public String putUpdate(HttpServletRequest request, Principal principal) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

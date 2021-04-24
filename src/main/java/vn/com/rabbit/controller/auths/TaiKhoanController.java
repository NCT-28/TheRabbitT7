package vn.com.rabbit.controller.auths;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.rabbit.common.Page;
import vn.com.rabbit.service.AccountService;

@Controller
@RequestMapping("/quan-tri/tai-khoan")
public class TaiKhoanController {

	private final AccountService userService;
	public TaiKhoanController(AccountService userService) {

		this.userService = userService;
	}

	@GetMapping(value = "")
	public String categoryPage(Model model,
			@RequestParam(defaultValue = "", value = "tu-khoa") String name,
			@RequestParam(defaultValue = "1") Integer pageNo,
			@RequestParam(defaultValue = "15") Integer pageSize,
			@RequestParam(defaultValue = "DESC") String sortType,
			@RequestParam(defaultValue = "name") String sortBy,
			HttpSession session) {
	//	ResponseMess<Category> categoryMess = categoryService.getAllCategorys(pageNo, pageSize, name, sortType, sortBy);
		//model.addAttribute("categoryMess", categoryMess);
		
		return Page.Account;
	}
	
	@PostMapping(value = "/add-update")
	public String saveAndUpdate(HttpServletRequest request, Principal principal) {
		userService.saveAndUpdate(request, principal);
		System.out.println("add or update thanh cong category thanh cong");
		return "redirect:" + request.getHeader("Referer");
	}
}

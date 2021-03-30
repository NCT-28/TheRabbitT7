package vn.com.rabbit.controller.admin;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.rabbit.service.AccountService;
import vn.com.rabbit.service.model.ModelBase;

@Controller
@RequestMapping("/quan-tri/tai-khoan")
public class TaiKhoanController {

	private final AccountService userService;
	public TaiKhoanController(AccountService userService) {

		this.userService = userService;
	}

	@PostMapping(value = "/add-update")
	public String saveAndUpdate(HttpServletRequest request, Principal principal) {
		userService.saveAndUpdate(request, principal);
		System.out.println("add or update thanh cong category thanh cong");
		return "redirect:" + request.getHeader("Referer");
	}
}

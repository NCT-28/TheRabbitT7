package vn.com.rabbit.controller.admin;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.com.rabbit.service.AccountService;

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

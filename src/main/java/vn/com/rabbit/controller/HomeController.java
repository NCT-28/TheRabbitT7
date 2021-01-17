package vn.com.rabbit.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.com.rabbit.service.UserService;

@Controller
@RequestMapping(value = "/")
public class HomeController {

	private final UserService userService;

	public HomeController(UserService service) {
		this.userService = service;
	}

	@GetMapping(value = { "" })
	public String homePage() {
		return "index";
	}

	@GetMapping(value = "auth/login")
	public String loginPage(Model model) {
		return "login";
	}

	@GetMapping(value = "auth/register")
	public String registerPage(Model model) {
		return "register";
	}

	@GetMapping(value = "auth/forget")
	public String forgetPage(Model model) {
		return "forget";
	}

	@GetMapping(value = "/403")
	public String accessDenied(Model model, Principal principal) {
		if (principal == null)
			return "403";
		return "";
	}

	@PostMapping(value = "register")
	public String register(HttpServletRequest request, Principal principal) {
		userService.saveAndUpdate(request, principal);
		return "redirect:" + request.getHeader("Referer");
	}
}

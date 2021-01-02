package vn.com.rabbit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.com.rabbit.service.UserService;

@Controller
public class HomeController {

	private final UserService userService;
	
	public HomeController(UserService service) {
		this.userService = service;
	}
	
	@GetMapping(value = {"/", "/index"})
	public String homePage() {
		return "index";
	}
	@GetMapping(value = "/login")
    public String loginPage(Model model) {
 
        return "login";
    }
}

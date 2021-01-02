package vn.com.rabbit.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller(value = "HomeControllerOfAdmin")
public class HomeController {
	
	
	
	@GetMapping(value = { "/quan-tri" })
	public String homePage(Model model, Principal principal) {
		String userName = principal.getName();
		System.out.println("User Name: " + userName);
		return "admin/index";
	}
	
//	@GetMapping(value = "/quan-tri/category")
//	public String category(Model model, Principal principal) {
////		String userName = principal.getName();
////		System.out.println("User Name: " + userName);
//		return "admin/category";
//	}
}

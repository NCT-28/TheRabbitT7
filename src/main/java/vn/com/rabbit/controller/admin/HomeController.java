package vn.com.rabbit.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller(value = "HomeControllerOfAdmin")
public class HomeController {
	
	@GetMapping(value = { "/quan-tri" })
	public String homePage(Model model, Principal principal) {
//		String userName = principal.getName();
//		System.out.println("User Name: " + userName);
		return "admin/index";
	}
	
	@GetMapping(value = { "/quan-tri/tai-khoan/role" })
	public String taiKhoan_RolePage(Model model, Principal principal) {
		return "admin/tk_role";
	}
	@GetMapping(value = { "/quan-tri/tai-khoan/menu" })
	public String taiKhoan_MenuPage(Model model, Principal principal) {
		return "admin/tk_menu";
	}
	
	@GetMapping(value = { "/quan-tri/tai-khoan/chuc-nang" })
	public String taiKhoan_FunctionPage(Model model, Principal principal) {
		return "admin/tk_function";
	}
}

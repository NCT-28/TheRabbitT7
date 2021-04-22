package vn.com.rabbit.controller.page;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import vn.com.rabbit.common.Page;

@Controller()
public class HomeController {
	
	
	@GetMapping(value = { "" })
	public String homePage() {
		return Page.Index;
	}

	@GetMapping(value = "auth/login")
	public String loginPage() {
		return Page.Login;
	}

	@GetMapping(value = "auth/register")
	public String registerPage() {
		return Page.Register;
	}

	@GetMapping(value = "auth/forget")
	public String forgetPage() {
		return Page.Forget;
	}

	@GetMapping(value = "/403")
	public String accessDenied(Principal principal) {
		if (principal == null)
			return Page.P403;
		return Page.P403;
	}
	
	
	//Phầm admin.
	
	@GetMapping(value = { "/quan-tri" })
	public String homeQTPage() {
		return Page.QuanTri;
	}
	
	
	@GetMapping(value = { "/quan-tri/tai-khoan/role" })
	public String taiKhoan_RolePage() {
		return Page.Role;
	}

	@GetMapping(value = { "/quan-tri/tai-khoan/menu" })
	public String taiKhoan_MenuPage() {
		return Page.Menu;
	}
	
	@GetMapping(value = { "/quan-tri/tai-khoan/chuc-nang" })
	public String taiKhoan_FunctionPage() {
		return Page.Function;
	}
}

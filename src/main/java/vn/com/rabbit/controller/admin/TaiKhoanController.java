package vn.com.rabbit.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.rabbit.entity.User;
import vn.com.rabbit.service.UserService;
import vn.com.rabbit.service.model.ModelBase;

@Controller
@RequestMapping("/quan-tri/tai-khoan")
public class TaiKhoanController {
	
	private final UserService userService;
	public TaiKhoanController(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping(value = "")
	public String categoryPage(Model model,
			@RequestParam(defaultValue = "", value = "tu-khoa") String login,
			@RequestParam(defaultValue = "1") Integer pageNo,
			@RequestParam(defaultValue = "15") Integer pageSize,
			@RequestParam(defaultValue = "DESC") String sortType,
			@RequestParam(defaultValue = "login") String sortBy,
			HttpSession session) {	
		model.addAttribute("activeUser", "active");
		model.addAttribute("active_menu", "active menu-open");
		ModelBase<User> users = userService.getAllUser(pageNo, pageSize, login, sortType, sortBy);
		model.addAttribute("users", users);
		return "admin/tk_taikhoan";
	}
}

//package vn.com.rabbit.controller.admin;
//
//import java.security.Principal;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import vn.com.rabbit.base.controller.BaseSearchImplController;
//import vn.com.rabbit.entity.User;
//import vn.com.rabbit.service.UserService;
//import vn.com.rabbit.service.model.ModelBase;
//
//@Controller
//@RequestMapping("/quan-tri/tai-khoan")
//public class TaiKhoanController extends BaseSearchImplController<User> {
//	
//	private final UserService userService;
//	public TaiKhoanController(UserService userService) {
//		super(userService);
//		this.userService = userService;
//	}
//	
//	@PostMapping(value = "/add-update")
//	public String saveAndUpdate(HttpServletRequest request, Principal principal) {
//		User model = new User();
//		userService.save(model);
//		System.out.println("add or update thanh cong category thanh cong");
//		return "redirect:" + request.getHeader("Referer");
//	}
//}

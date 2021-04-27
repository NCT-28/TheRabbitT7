package vn.com.rabbit.controller.auths;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.rabbit.common.Page;
import vn.com.rabbit.entity.Role;
import vn.com.rabbit.service.RoleService;
import vn.com.rabbit.service.dto.response.ResponseMess;

@Controller
@RequestMapping("/quan-tri/tai-khoan/role")
public class RoleController{

	private final RoleService _service;
	public RoleController(RoleService role) {

		this._service= role;
	}
	
	@GetMapping(value = "")
	public String categoryPage(Model model,
			@RequestParam(defaultValue = "", value = "tu-khoa") String name,
			@RequestParam(defaultValue = "1") Integer pageNo,
			@RequestParam(defaultValue = "15") Integer pageSize,
			@RequestParam(defaultValue = "DESC") String sortType,
			@RequestParam(defaultValue = "name") String sortBy,
			HttpSession session) {
		
		ResponseMess<Role> roleMess = _service.getAllTs(pageNo, pageSize, name, sortType, sortBy);
		model.addAttribute("roleMess", roleMess);
		
		return Page.Role;
	}

}

package vn.com.rabbit.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller(value = "SYS_SettingController")
@RequestMapping(value = "quan-tri/setting")
public class SYS_SettingControlelr {

	@GetMapping(value = "")
	public String settingPage() {
		return "admin/setting";
	}
}

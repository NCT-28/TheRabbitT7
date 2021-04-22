package vn.com.rabbit.controller.auths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/quan-tri/post")
public class PostController {

	@GetMapping("")
	public String postPage() {
		return "admin/bl_post";
	}
	
	@GetMapping("/them-post")
	public String themPostPage() {
		return "admin/them-post";
	}
}

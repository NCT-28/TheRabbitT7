package vn.com.rabbit.controller.auths;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.com.rabbit.common.Helper;
import vn.com.rabbit.common.Page;
import vn.com.rabbit.service.CategoryService;
import vn.com.rabbit.service.PostService;
import vn.com.rabbit.service.dto.CategoryDTO;
import vn.com.rabbit.service.dto.PostDTO;
import vn.com.rabbit.service.dto.form.FormAddPost;

@Controller
@RequestMapping(value = "/quan-tri/post")
public class PostController {

	private final CategoryService categoryService;
	private final PostService _server;

	public PostController(CategoryService categoryService, PostService server) {
		this.categoryService = categoryService;
		this._server = server;
	}

	@GetMapping("")
	public String categoryPage(Model model, @RequestParam(defaultValue = "", value = "tu-khoa") String name,
			@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "15") Integer pageSize,
			@RequestParam(defaultValue = "DESC") String sortType, @RequestParam(defaultValue = "title") String sortBy,
			HttpSession session) {
		var postMess = _server.getAllPosts(pageNo, pageSize, name, sortType, sortBy);
		model.addAttribute("postMess", postMess);

		return Page.Post;
	}

	@GetMapping("/them-post")
	public String themPostPage(Model model, HttpServletRequest request) {
		// Set form add post.
		FormAddPost formAddPost = new FormAddPost();
		formAddPost.setAuthor("admin");

		model.addAttribute("formAddPost", formAddPost);

		return Page.AddPost;
	}

	@PostMapping("/them-post/insert")
	public String insertPost(HttpServletRequest request, Model model,
			@ModelAttribute("formAddPost") @Validated FormAddPost formAddPost, HttpSession session) {

		// Get data.
		var title = formAddPost.getTitle();
		var content = formAddPost.getContent();
		var author = "admin";
		var categorys = formAddPost.getCategory();
		var image = formAddPost.getFeaturedImage();

		// create post new.
		var post = new PostDTO();
		post.setId(null);
		post.setTitle(title);
		post.setUsers(author);
		post.setContent(content);
		post.setUrl(Helper.pathVariableString(title));
		post.setImage(image.getOriginalFilename());
		post.setPublished(true);
		post.setLocked(false);
		post.setCategory(categorys);

		// Up file and save post.
		Helper.doUpload(request, image);
		_server.saveAndUpdate(post);

		return Page.AddPost;
	}

	// Model attribute

	@ModelAttribute("category")
	public List<CategoryDTO> getCategory() {
		var category = categoryService.getAll();
		return category;
	}
}

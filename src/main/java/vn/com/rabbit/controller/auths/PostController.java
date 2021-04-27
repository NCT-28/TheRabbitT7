package vn.com.rabbit.controller.auths;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import vn.com.rabbit.common.Helper;
import vn.com.rabbit.common.Page;
import vn.com.rabbit.entity.Post;
import vn.com.rabbit.service.CategoryService;
import vn.com.rabbit.service.PostService;
import vn.com.rabbit.service.dto.CategoryDTO;
import vn.com.rabbit.service.dto.PostDTO;
import vn.com.rabbit.service.dto.form.FormAddPost;
import vn.com.rabbit.service.dto.response.ResponseMess;
import vn.com.rabbit.service.mapper.PostMapper;

@Controller
@RequestMapping(value = "/quan-tri/post")
public class PostController {

	private final CategoryService categoryService;
	private final PostService _server;
	private final PostMapper _mapper;

	public PostController(CategoryService categoryService, PostService server, PostMapper mapper) {
		this.categoryService = categoryService;
		this._server = server;
		this._mapper = mapper;
	}

	@GetMapping("")
	public String categoryPage(Model model, @RequestParam(defaultValue = "", value = "tu-khoa") String name,
			@RequestParam(defaultValue = "1") Integer pageNo, @RequestParam(defaultValue = "15") Integer pageSize,
			@RequestParam(defaultValue = "DESC") String sortType, @RequestParam(defaultValue = "title") String sortBy,
			HttpSession session) {
		ResponseMess<Post> postMess = _server.getAllPosts(pageNo, pageSize, name, sortType, sortBy);
		model.addAttribute("postMess", postMess);

		return Page.Post;
	}

	@GetMapping("/view/{url}")
	public String viewPostPage(Model model, @PathVariable("url") String url) {

		PostDTO dto = _server.getOnePostByUrl(url);
		model.addAttribute("post", dto);

		return Page.ViewPost;
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
		String title = formAddPost.getTitle();
		String content = formAddPost.getContent();
		String author = "admin";
		UUID[] categorys = formAddPost.getCategory();
		CommonsMultipartFile image = formAddPost.getFeaturedImage();

		// create post new.
		PostDTO post = new PostDTO();
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

	@GetMapping(value = "/get-by-id")
	public @ResponseBody String getCategory(HttpServletRequest request) throws JsonProcessingException {
		UUID id = UUID.fromString(request.getParameter("id"));
		if (id != null) {
			Post model = _server.getOnePostById(id).get();

			PostDTO post = _mapper.entityToDTO(model);

			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString(post);
		}
		return null;
	}

	@PostMapping(value = "/delete")
	public String deletePost(HttpServletRequest request, HttpSession session) {

		String name = request.getParameter("name");
		UUID id = UUID.fromString(request.getParameter("id"));
		
		if(id!=null) {
			session.setAttribute("delete", name);

			_server.delete(id);
			System.out.println("xóa thành công " + request.getParameter("name"));
		}
	
		return "redirect:" + request.getHeader("Referer");
	}

	// Model attribute

	@ModelAttribute("category")
	public List<CategoryDTO> getCategory() {
		List<CategoryDTO> category = categoryService.getAll();
		return category;
	}
}

package vn.com.rabbit.service;


import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.rabbit.base.service.BaseImplService;
import vn.com.rabbit.entity.Category;
import vn.com.rabbit.repository.CategoryReposytory;

@Service
public class CategoryService extends BaseImplService<Category> {
	
	private final CategoryReposytory categoryReposytory;
	protected CategoryService(CategoryReposytory repo) {
		super(repo);
		this.categoryReposytory=  repo;
	}
	
	@Transactional
	public Optional<Category> getOneCategoryById(HttpServletRequest request) {
		UUID id = UUID.fromString(request.getParameter("id"));
		return categoryReposytory.findById(id);
	}
	
}

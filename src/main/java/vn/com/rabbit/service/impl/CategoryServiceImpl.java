package vn.com.rabbit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.rabbit.common.Helper;
import vn.com.rabbit.entity.Category;
import vn.com.rabbit.repository.CategoryReposytory;
import vn.com.rabbit.service.CategoryService;
import vn.com.rabbit.service.mess.CategoryMess;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Service

public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryReposytory categoryRepository;

	@Override
	@Transactional
	public void saveAndUpdate(HttpServletRequest request, Principal principal) {
		Category category = new Category();
		
		//category.setId(request.getParameter("id"));
		
		category.setName(request.getParameter("name"));
		category.setUrl(Helper.pathVariableString(request.getParameter("name")));
		category.setDescription(request.getParameter("description"));
		category.setLocked((request.getParameter("id") != null) && Boolean.parseBoolean(request.getParameter("locked")));
		
		System.out.println(Boolean.parseBoolean(request.getParameter("locked")));
		category.setCreatedBy((request.getParameter("id") == null) ? principal.getName() : null);
		category.setUpdatedBy((request.getParameter("id") != null) ? null : principal.getName());

		// save or update category
		categoryRepository.save(category);

	}
	@Override
	@Transactional
	public CategoryMess getAllCategorys(Integer pageNo, Integer pageSize, String name, String sortType, String sortBy) {

		Pageable pageable = null;

		if (sortType.equals("ASC")) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.ASC, sortBy));
		} else if (sortType.equals("DESC")) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.DESC, sortBy));
		}
		Page<Category> enties = categoryRepository.findAllCategory(pageable, name);

		CategoryMess categoryMess = new CategoryMess();
		categoryMess.setMessage("");
		categoryMess.setTotalCategorys(enties.getTotalElements());
		categoryMess.setListCategorys(enties.getContent());

		return categoryMess;
		
	}

	@Override
	@Transactional
	public Category getOneCategoryById(HttpServletRequest request) {
		return categoryRepository.findOneCategoryById(Long.parseLong(request.getParameter("id")));
	}
	@Override
	@Transactional
	public void deleteCategory(HttpServletRequest request) {
		categoryRepository.deleteById(Long.parseLong(request.getParameter("id")));
	}

}

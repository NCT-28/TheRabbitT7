package vn.com.rabbit.service.impl;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

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
import vn.com.rabbit.service.model.ModelBase;

@Service
public class CategoryServiceImpl implements CategoryService {

	
	private final CategoryReposytory categoryRepository;
	
	public CategoryServiceImpl(CategoryReposytory categoryRepository) {
		// TODO Auto-generated constructor stub
		this.categoryRepository = categoryRepository;
	}

	@Override
	@Transactional
	public void saveAndUpdate(HttpServletRequest request, Principal principal) {

		String name = request.getParameter("name");
		String description = request.getParameter("description");
		// Boolean lock = Boolean.parseBoolean(request.getParameter("locked"));

		Category category = new Category();

		if (request.getParameter("id") == null) {
			category.setName(name);
			category.setUrl(Helper.pathVariableString(name));
			category.setDescription(description);
			category.setLocked(false);
			category.setCreatedBy(/* principal.getName() != null ? principal.getName() : */ "Anonymous");
		} else {
			UUID id = UUID.fromString(request.getParameter("id"));
			category = categoryRepository.findById(id).get();
			category.setName(name);
			category.setUrl(Helper.pathVariableString(name));
			category.setDescription(description);
			category.setUpdatedBy(/* principal.getName() != null ? principal.getName() : */"Anonymous");
		}

		categoryRepository.save(category);

	}

	@Override
	@Transactional
	public ModelBase<Category> getAllCategorys(Integer pageNo, Integer pageSize, String name, String sortType,
			String sortBy) {

		Pageable pageable = null;

		if (sortType.equals("ASC")) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.ASC, sortBy));
		} else if (sortType.equals("DESC")) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.DESC, sortBy));
		}
		Page<Category> enties = categoryRepository.findAllCategory(pageable, name);

		ModelBase<Category> categoryMess = new ModelBase<Category>();
		categoryMess.setMessage("");
		categoryMess.setCount(enties.getTotalElements());
		categoryMess.setValue(enties.getContent());

		return categoryMess;

	}

	@Override
	@Transactional
	public Optional<Category> getOneCategoryById(HttpServletRequest request) {
		UUID id = UUID.fromString(request.getParameter("id"));
		return categoryRepository.findById(id);
	}

	@Override
	@Transactional
	public void deleteCategory(HttpServletRequest request) {
		UUID id = UUID.fromString(request.getParameter("id"));
		categoryRepository.deleteById(id);
	}

}

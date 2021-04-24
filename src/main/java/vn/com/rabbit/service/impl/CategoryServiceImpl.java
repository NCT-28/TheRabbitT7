package vn.com.rabbit.service.impl;

import java.util.List;
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
import vn.com.rabbit.service.dto.CategoryDTO;
import vn.com.rabbit.service.dto.response.ResponseMess;
import vn.com.rabbit.service.mapper.CategoryMapper;


@Service
public class CategoryServiceImpl implements CategoryService {

	
	private final CategoryReposytory categoryRepository;
	private final CategoryMapper _mapper;
	
	public CategoryServiceImpl(CategoryReposytory categoryRepository, CategoryMapper mapper) {
		// TODO Auto-generated constructor stub
		this.categoryRepository = categoryRepository;
		this._mapper = mapper;
	}
	
	@Override
	@Transactional
	public List<CategoryDTO> getAll() {
		List<Category> _items= categoryRepository.findAll();
		return _mapper.categorysToCategoryDTOS(_items);
	}


	@Override
	@Transactional
	public void saveAndUpdate(CategoryDTO dto) {


		Category category = new Category();

		if (dto.getId() ==null) {
			category.setName(dto.getName());
			category.setUrl(Helper.pathVariableString(dto.getName()));
			category.setDescription(dto.getDescription());
			category.setLocked(false);
			category.setCreatedBy(/* principal.getName() != null ? principal.getName() : */ "Anonymous");
		} else {
			category = categoryRepository.findById(dto.getId()).get();
			category.setName(dto.getName());
			category.setUrl(Helper.pathVariableString(dto.getName()));
			category.setDescription(dto.getDescription());
			category.setUpdatedBy(/* principal.getName() != null ? principal.getName() : */"Anonymous");
		}

		categoryRepository.save(category);

	}

	@Override
	@Transactional
	public ResponseMess<Category> getAllCategorys(Integer pageNo, Integer pageSize, String name, String sortType,
			String sortBy) {

		Pageable pageable = null;

		if (sortType.equals("ASC")) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.ASC, sortBy));
		} else if (sortType.equals("DESC")) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.DESC, sortBy));
		}
		Page<Category> enties = categoryRepository.findAllCategory(pageable, name);

		ResponseMess<Category> categoryMess = new ResponseMess<Category>();
		categoryMess.setMessage("");
		categoryMess.setTotal(enties.getTotalElements());
		categoryMess.setValues(enties.getContent());

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
	public void deleteCategory(UUID id) {
		categoryRepository.deleteById(id);
	}

	
}

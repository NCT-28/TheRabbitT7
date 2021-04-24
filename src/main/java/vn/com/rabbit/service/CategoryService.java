package vn.com.rabbit.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import vn.com.rabbit.entity.Category;
import vn.com.rabbit.service.dto.CategoryDTO;
import vn.com.rabbit.service.dto.response.ResponseMess;

public interface CategoryService {

	List<CategoryDTO> getAll();
	
	void saveAndUpdate(CategoryDTO dto);
	ResponseMess<Category> getAllCategorys(Integer pageNo, Integer pageSize, String name, String sortType,
										String sortBy);
	Optional<Category> getOneCategoryById(HttpServletRequest request);
	void deleteCategory(UUID id);
}

package vn.com.rabbit.service;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import vn.com.rabbit.entity.Category;
import vn.com.rabbit.service.dto.CategoryDTO;
import vn.com.rabbit.service.dto.response.ResponseMess;

public interface CategoryService {

	void saveAndUpdate(CategoryDTO dto);
	ResponseMess<Category> getAllCategorys(Integer pageNo, Integer pageSize, String name, String sortType,
										String sortBy);
	Optional<Category> getOneCategoryById(HttpServletRequest request);
	void deleteCategory(HttpServletRequest request);
}

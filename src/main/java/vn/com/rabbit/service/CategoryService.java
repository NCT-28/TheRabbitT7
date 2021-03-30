package vn.com.rabbit.service;

import org.springframework.stereotype.Service;
import vn.com.rabbit.entity.Category;
import vn.com.rabbit.service.model.ModelBase;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

public interface CategoryService {

	void saveAndUpdate(HttpServletRequest request, Principal principal);
	ModelBase<Category> getAllCategorys(Integer pageNo, Integer pageSize, String name, String sortType,
										String sortBy);
	Optional<Category> getOneCategoryById(HttpServletRequest request);
	void deleteCategory(HttpServletRequest request);
}

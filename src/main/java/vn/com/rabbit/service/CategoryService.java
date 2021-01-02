package vn.com.rabbit.service;


import vn.com.rabbit.entity.Category;
import vn.com.rabbit.service.mess.CategoryMess;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

public interface CategoryService {
	
	void saveAndUpdate(HttpServletRequest request, Principal principal);
	
	CategoryMess getAllCategorys(Integer pageNo, Integer pageSize, String name, String sortType, String sortBy);
	
	Category getOneCategoryById(HttpServletRequest request);
	
	void deleteCategory(HttpServletRequest request);
}

package vn.com.rabbit.service.mapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import vn.com.rabbit.entity.Category;
import vn.com.rabbit.service.dto.CategoryDTO;

@Service
public class CategoryMapper {
	
	
	public List<CategoryDTO> categorysToCategoryDTOS(List<Category> categories) {
		return categories.stream().filter(Objects :: nonNull).map(this:: categoryToCategoryDTO).collect(Collectors.toList());		
	}
	
	public CategoryDTO categoryToCategoryDTO(Category category) {
		return new CategoryDTO(category);
	}

}

package vn.com.rabbit.service.dto;

import lombok.Data;
import vn.com.rabbit.entity.Category;

import java.util.UUID;

@Data
public class CategoryDTO {
	private UUID id;

	private String name;

	private String description;

	private String url;

	private boolean locked;

	
	
	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CategoryDTO(Category category) {
		this.id=category.getUuid();
		this.name=category.getName();
		this.url=category.getUrl();
		this.locked=category.isLocked();
	}
	
}

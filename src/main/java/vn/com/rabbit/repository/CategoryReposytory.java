package vn.com.rabbit.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import vn.com.rabbit.base.repository.BaseImplRepository;
import vn.com.rabbit.entity.Category;

@Repository
public class CategoryReposytory extends BaseImplRepository<Category> {

	protected CategoryReposytory(EntityManager e) {
		super(Category.class, e);
		// TODO Auto-generated constructor stub
	}
	
	
}

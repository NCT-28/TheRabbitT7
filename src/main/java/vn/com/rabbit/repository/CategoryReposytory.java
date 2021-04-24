package vn.com.rabbit.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.rabbit.entity.Category;

@Repository
public interface CategoryReposytory extends JpaRepository<Category, UUID> {

	@Query(" SELECT ca FROM Category ca WHERE ca.name LIKE %:name% ")
	Page<Category> findAllCategory(Pageable pageable, @Param("name") String name);

	@Query(" SELECT ca FROM Category ca WHERE ca.id = :id ")
	Category findOneCategoryById(@Param("id") UUID id);
}

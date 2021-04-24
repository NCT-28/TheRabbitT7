package vn.com.rabbit.repository;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.rabbit.entity.Post;


@Repository
public interface PostRepository extends JpaRepository<Post,UUID> {

	@Query(" SELECT ps FROM Post ps WHERE ps.title LIKE %:title% ")
	Page<Post> findAllPost(Pageable pageable, @Param("title") String title);
}

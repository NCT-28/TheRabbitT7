package vn.com.rabbit.service;

import java.util.Optional;
import java.util.UUID;

import vn.com.rabbit.entity.Post;
import vn.com.rabbit.service.dto.PostDTO;
import vn.com.rabbit.service.dto.response.ResponseMess;

public interface PostService {

	void saveAndUpdate(PostDTO dto);

	ResponseMess<Post> getAllPosts(Integer pageNo, Integer pageSize, String name, String sortType,
			String sortBy);

	Optional<Post> getOnePostById(UUID id);

	void delete(UUID id);
}

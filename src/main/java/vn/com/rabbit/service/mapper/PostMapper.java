package vn.com.rabbit.service.mapper;

import java.time.Instant;

import org.springframework.stereotype.Service;

import vn.com.rabbit.entity.Post;
import vn.com.rabbit.service.dto.PostDTO;

@Service
public class PostMapper extends BaseMapper<Post, PostDTO> {

	@Override
	public PostDTO entityToDTO(Post entity) {
		return new PostDTO(entity);
	}

	@Override
	public Post dtoToEntity(PostDTO dto) {
		if(dto != null) {
			var post = new Post();
			
			
			post.setTitle(dto.getTitle());
			post.setSunmary(dto.getSunmary());
			post.setContent(dto.getContent());
			post.setUrl(dto.getUrl());
			post.setImage(dto.getImage());
			post.setPublished(dto.isPublished());
			post.setLocked(dto.isLocked());
			
			if(dto.getId() ==null)
			{
				post.setId(dto.getId());
				post.setCreatedBy(dto.getCreatedBy());
				post.setCreatedDate(Instant.now());
			}
			else {
				post.setId(dto.getId());
				post.setUpdatedBy(dto.getUpdatedBy());
				post.setUpdatedDate(Instant.now());
			}
			
			return post;
		}
		return null;
	}
	
	
}

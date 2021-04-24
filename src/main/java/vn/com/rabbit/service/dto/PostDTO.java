package vn.com.rabbit.service.dto;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import vn.com.rabbit.entity.Post;

@Getter
@Setter
public class PostDTO extends BaseAuditDTO {
	
	private UUID id;
	
	private String users;

	private String title;

	private String sunmary;

	private String content;

	private String url;

	private String image;

	private boolean published;

	private boolean locked;

	private UUID category[];
	
	public PostDTO() {
		super();
	}
	
	public PostDTO(Post post) {
		this.id = post.getId();
		this.title = post.getTitle();
		this.sunmary = post.getSunmary();
		this.content = post.getContent();
		this.url = post.getUrl();
		this.image = post.getImage();
		this.published = post.isPublished();
		this.locked = post.isLocked();
		
	}
	
}

package vn.com.rabbit.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "bl_comment")
public class Comment extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "post_id", nullable = false)
	private Post posts;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "published")
	private boolean published;

	@Column(name = "content")
	private String content;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "locked")
	private boolean locked;

}

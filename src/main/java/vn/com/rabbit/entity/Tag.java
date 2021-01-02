package vn.com.rabbit.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bl_tag")
@Data
@EqualsAndHashCode(callSuper = false)
public class Tag extends AbstractEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;


	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "locked")
	private boolean locked;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tags", cascade = CascadeType.ALL)
	private List<TagPost> tagPosts;
}

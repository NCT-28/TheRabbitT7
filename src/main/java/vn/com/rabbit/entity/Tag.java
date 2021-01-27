package vn.com.rabbit.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vn.com.rabbit.base.entity.BaseEntity;

@Entity
@Table(name = "bl_tag")
@Data
@EqualsAndHashCode(callSuper = false)
public class Tag extends BaseEntity {
	
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

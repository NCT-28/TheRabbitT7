package vn.com.rabbit.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import vn.com.rabbit.base.entity.BaseEntity;
import vn.com.rabbit.base.models.annotation.ReportTableName;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table
@ReportTableName(value = "Post", name = "Post")
@NoArgsConstructor
public class Post extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Account users;
	
	@Column(name = "title")
	private String title;

	@Column(name = "summary")
	private String sunmary;

	@Column(name = "content")
	private String content;

	@Column(name = "url")
	private String url;

	@Column(name = "image")
	private String image;

	@Column(name = "published")
	private boolean published;

	@Column(name = "locked")
	private boolean locked;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "posts", cascade = CascadeType.ALL)
	private List<Comment> comment;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "posts", cascade = CascadeType.ALL)
	private List<TagPost> tagPosts;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "posts", cascade = CascadeType.ALL)
	private List<CategoryPost> categoryPosts;
}

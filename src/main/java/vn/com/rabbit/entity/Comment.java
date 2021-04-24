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

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table
@NoArgsConstructor
public class Comment extends AbstractEntity {

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

package vn.com.rabbit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@ReportTableName(value = "Comment", name = "Comment")
@NoArgsConstructor
public class Comment extends BaseEntity {

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

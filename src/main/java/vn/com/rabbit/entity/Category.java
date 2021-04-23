package vn.com.rabbit.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table
@NoArgsConstructor
public class Category extends AbstractEntity {
	private static final long serialVersionUID = 1L;

	@Column(name = "name", columnDefinition = "nvarchar")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "url")
	private String url;

	@Column(name = "locked")
	private boolean locked;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categorys", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<CategoryPost> categoryPosts;

}

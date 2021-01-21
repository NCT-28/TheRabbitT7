package vn.com.rabbit.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "bl_category")
public class Category extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name = "name")
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

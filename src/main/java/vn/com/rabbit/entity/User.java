package vn.com.rabbit.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vn.com.rabbit.base.entity.BaseEntity;

@Entity
@Table(name = "bl_user")
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity{

	private static final long serialVersionUID = 1L;

	@Column(length = 50, unique = true, nullable = false)
	private String login;

	@JsonIgnore
	@Column(name = "password_hash", length = 60, nullable = false)
	private String password;

	@Column(name = "email")
	private String email;

	@Column(name = "image_url", length = 50)
	private String imageUrl;

	@Column(name = "activated", nullable = false)
	private boolean activated = false;

	@Column(name = "locked", nullable = false)
	private boolean locked = false;


	@Column(name = "url")
	private String url;

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
	private List<RoleUser> roleUsers;

	@JsonIgnore
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@BatchSize(size = 1)
	private UserInfo userInfo;

}

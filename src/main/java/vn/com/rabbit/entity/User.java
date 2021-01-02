package vn.com.rabbit.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.BatchSize;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "bl_user")
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends AbstractEntity implements Serializable {

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

	@Column(name = "can_change", nullable = false)
	private boolean canChange = false;

	@Column(name = "must_chage", nullable = false)
	private boolean mustChage = false;

	@Column(name = "activation_key", length = 20)
	@JsonIgnore
	private String activationKey;

	@Column(name = "reset_key", length = 20)
	@JsonIgnore
	private String resetKey;

	@Column(name = "reset_date")
	private Instant resetDate = null;

	@Column(name = "url")
	private String url;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "users", cascade = CascadeType.ALL)
	private List<RoleUser> roleUsers;

	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@BatchSize(size = 1)
	private UserInfo userInfo;

}

package vn.com.rabbit.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "bl_user_info")
public class UserInfo extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "initials")
	private String initials;

	@Column(name = "comment")
	private String comment;

	@Column(name = "mobile")
	private String mobile;
}

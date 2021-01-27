package vn.com.rabbit.entity;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;
import vn.com.rabbit.base.entity.BaseEntity;

@Data
@Entity
@Table(name = "bl_user_role")
@EqualsAndHashCode(callSuper = false)
public class RoleUser extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
    @JoinColumn(name = "user_id")
    private User users;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private  Role roles;

}

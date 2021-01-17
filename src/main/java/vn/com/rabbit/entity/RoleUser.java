package vn.com.rabbit.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "bl_user_role")
@EqualsAndHashCode(callSuper = false)
public class RoleUser extends AbstractEntity implements Serializable {

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

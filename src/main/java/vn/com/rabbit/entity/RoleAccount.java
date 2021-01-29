package vn.com.rabbit.entity;


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
@Entity
@Table
@ReportTableName(value = "RoleAccount", name = "RoleAccount")
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class RoleAccount extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
    @JoinColumn(name = "account_id")
    private Account accounts;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private  Role roles;

}

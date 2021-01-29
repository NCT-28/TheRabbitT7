package vn.com.rabbit.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@NoArgsConstructor
@ReportTableName(value = "AccountInfo", name = "AccountInfo")
public class AccountInfo extends BaseEntity {
	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Account account;

	@Column(name = "full_name")
	private String fullName;

	@Column(name = "initials")
	private String initials;

	@Column(name = "comment")
	private String comment;

	@Column(name = "mobile")
	private String mobile;
}

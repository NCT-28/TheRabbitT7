package vn.com.rabbit.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "sys_setting_group")
@EqualsAndHashCode(callSuper = false)
public class SettingGroup extends AbstractEntity implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "order_no")
	private String orderNo;
	
	@ManyToOne
    @JoinColumn(name = "setting_group_id")
    private Setting settings;
}

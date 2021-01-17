package vn.com.rabbit.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "sys_setting")
@EqualsAndHashCode(callSuper = false)
public class Setting extends AbstractEntity implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 1L;

	@Column(name = "key")
	private String key;
	
	@Column(name = "value")
	private String value;
	
	@Column(name = "type")
	private String type;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "settings", cascade = CascadeType.ALL)
	private List<SettingGroup> settingGroups;

}

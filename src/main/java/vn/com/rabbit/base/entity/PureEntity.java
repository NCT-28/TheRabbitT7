package vn.com.rabbit.base.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;

@Getter
@Setter
@MappedSuperclass
public abstract class PureEntity extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
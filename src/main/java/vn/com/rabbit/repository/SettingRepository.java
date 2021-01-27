package vn.com.rabbit.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import vn.com.rabbit.base.repository.BaseImplRepository;
import vn.com.rabbit.entity.Setting;

@Repository
public class SettingRepository extends BaseImplRepository<Setting> {

	protected SettingRepository(EntityManager e) {
		super(Setting.class, e);
		// TODO Auto-generated constructor stub
	}

}

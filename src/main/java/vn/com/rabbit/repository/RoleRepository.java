package vn.com.rabbit.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import vn.com.rabbit.base.repository.BaseImplRepository;
import vn.com.rabbit.entity.Role;

@Repository
public class RoleRepository extends BaseImplRepository<Role> {

	protected RoleRepository(EntityManager e) {
		super(Role.class, e);
		// TODO Auto-generated constructor stub
	}

}

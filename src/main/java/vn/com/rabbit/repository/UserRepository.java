package vn.com.rabbit.repository;
import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import vn.com.rabbit.base.repository.BaseImplRepository;
import vn.com.rabbit.entity.User;


@Repository
public class UserRepository extends BaseImplRepository<User>{

	protected UserRepository(EntityManager e) {
		super(User.class, e);
		// TODO Auto-generated constructor stub
	}


}

package vn.com.rabbit.repository;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import vn.com.rabbit.base.repository.BaseImplRepository;
import vn.com.rabbit.entity.Account;

@Repository
public class AccountRepository extends BaseImplRepository<Account> {

	protected AccountRepository(EntityManager e) {
		super(Account.class, e);
		// TODO Auto-generated constructor stub
	}
 
}

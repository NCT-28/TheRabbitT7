package vn.com.rabbit.repository;

import java.util.UUID;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import vn.com.rabbit.base.repository.ManyToManyImplRepository;
import vn.com.rabbit.base.repository.manager.EMUtils;
import vn.com.rabbit.base.repository.utils.QueryUtils;
import vn.com.rabbit.entity.Account;
import vn.com.rabbit.entity.Role;
import vn.com.rabbit.entity.RoleAccount;

@Repository
public class AccountRoleRepository extends ManyToManyImplRepository<Account, RoleAccount, Role> {

	protected AccountRoleRepository(EntityManager em, AccountRepository ur, RoleRepository rr) {
		super(Account.class, RoleAccount.class, Role.class, em, ur, rr);
		// TODO Auto-generated constructor stub
	}	

    public void deleteAllWithIdAccount(UUID id) {
        EMUtils.execute(getEM(), getEM().createQuery("delete " + QueryUtils.GetNameEntity(getDomainClass()) + " where account." + baseIDName + "=:i")
                .setParameter("i", id));
    }

}

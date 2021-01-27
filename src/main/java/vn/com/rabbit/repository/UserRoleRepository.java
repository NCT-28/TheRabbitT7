package vn.com.rabbit.repository;

import java.util.UUID;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import vn.com.rabbit.base.repository.ManyToManyImplRepository;
import vn.com.rabbit.base.repository.manager.EMUtils;
import vn.com.rabbit.base.repository.utils.QueryUtils;
import vn.com.rabbit.entity.Role;
import vn.com.rabbit.entity.RoleUser;
import vn.com.rabbit.entity.User;

@Repository
public class UserRoleRepository extends ManyToManyImplRepository<User, RoleUser, Role> {

	protected UserRoleRepository(EntityManager em, UserRepository ur, RoleRepository rr) {
		super(User.class, RoleUser.class, Role.class, em, ur, rr);
		// TODO Auto-generated constructor stub
	}
	
	/**
     * Xóa tất cả vai trò theo id {@link Account}
     *
     * @param id id {@link Account}
     */
    public void deleteAllWithIdAccount(UUID id) {
        EMUtils.execute(getEM(), getEM().createQuery("delete " + QueryUtils.GetNameEntity(getDomainClass()) + " where account." + baseIDName + "=:i")
                .setParameter("i", id));
    }

}

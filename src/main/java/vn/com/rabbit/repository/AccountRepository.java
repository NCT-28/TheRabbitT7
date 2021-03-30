package vn.com.rabbit.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.rabbit.entity.Account;
import vn.com.rabbit.entity.Category;
import vn.com.rabbit.entity.Role;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account,UUID> {

	String USERS_BY_LOGIN_CACHE = "usersByLogin";
	Optional<Account> findOneByLogin(String login);

	@Query(" SELECT us FROM Account us WHERE us.login LIKE %:login% ")
	Page<Account> findAllAccount(Pageable pageable, @Param("login") String login);

	@Query(value = "Select r.* "
			+" FROM ((bl_role r INNER JOIN bl_user_role ur ON r.id = ur.role_id)"
			+" INNER JOIN bl_user us ON us.id = ur.user_id)"
			+" WHERE us.login= :login", nativeQuery = true)
	List<Role> findAllRoleByUserId(@Param("login") String login);
 
}

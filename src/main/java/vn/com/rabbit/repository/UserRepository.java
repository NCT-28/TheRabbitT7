package vn.com.rabbit.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.rabbit.entity.Role;
import vn.com.rabbit.entity.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	String USERS_BY_LOGIN_CACHE = "usersByLogin";
	Optional<User> findOneByLogin(String login);

	@Query(value = "Select r.* "
			+" FROM ((bl_role r INNER JOIN bl_user_role ur ON r.id = ur.role_id)"
			+" INNER JOIN bl_user us ON us.id = ur.user_id)"
			+" WHERE us.login= :login", nativeQuery = true)
	List<Role> findAllRoleByUserId(@Param("login") String login);
}

package vn.com.rabbit.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.rabbit.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {

	@Query(" SELECT r FROM Role r WHERE r.name LIKE %:name% ")
	Page<Role> findAllRole(Pageable pageable, @Param("name") String name);
	
	@Query(" SELECT r FROM Role r WHERE r.name = :name ")
	Optional<Role> findOneByName(@Param("name") String name);
	
	@Query(value = "Select r.* "
			+" FROM ((Role r INNER JOIN RoleAccount ur ON r.id = ur.role_id)"
			+" INNER JOIN Account us ON us.id = ur.account_id)"
			+" WHERE us.login= :login", nativeQuery = true)
	List<Role> findAllRoleByUserId(@Param("login") String login);
}

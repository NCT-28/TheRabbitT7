package vn.com.rabbit.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import vn.com.rabbit.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,UUID> {

	@Query(" SELECT us FROM Account us WHERE us.login = :login ")
	Optional<Account> findOneByLogin(@Param("login") String login);

	@Query(" SELECT us FROM Account us WHERE us.login LIKE %:login% ")
	Page<Account> findAllAccount(Pageable pageable, @Param("login") String login);
	
	@Query(" SELECT us FROM Account us WHERE us.email = :email ")
	Account findByEmail(@Param("email") String email);	
	
	@Query(" SELECT us FROM Account us WHERE us.login = :login ")
	Account findByUserName(@Param("login") String login);
}

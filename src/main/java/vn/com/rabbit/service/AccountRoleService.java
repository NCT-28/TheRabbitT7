package vn.com.rabbit.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.rabbit.base.service.ManyToManyImplService;
import vn.com.rabbit.entity.Account;
import vn.com.rabbit.entity.Role;
import vn.com.rabbit.entity.RoleAccount;
import vn.com.rabbit.repository.AccountRoleRepository;

@Service
public class AccountRoleService extends ManyToManyImplService<Account, RoleAccount, Role> {

	@Autowired
	private AccountRoleRepository accountRoleRepository;
	protected AccountRoleService(AccountRoleRepository repository) {
		super(repository);
	}
	
	/**
     * Lấy danh sách tên vài trò theo id Tài khoản
     *
     * @param idAccount id tài khoản
     * @return danh sách tên vài trò
     */
    @Transactional
    public List<String> getNames(UUID idAccount) {
        return accountRoleRepository.findAllJoinTableByID(idAccount, "login", String.class);
    }

}

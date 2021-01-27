package vn.com.rabbit.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.rabbit.base.service.ManyToManyImplService;
import vn.com.rabbit.entity.Role;
import vn.com.rabbit.entity.RoleUser;
import vn.com.rabbit.entity.User;
import vn.com.rabbit.repository.UserRoleRepository;

@Service
public class UserRoleService extends ManyToManyImplService<User, RoleUser, Role> {

	private UserRoleRepository userRoleRepository;
	protected UserRoleService(UserRoleRepository repository) {
		super(repository);
		this.userRoleRepository = repository;
	}
	
	/**
     * Lấy danh sách tên vài trò theo id Tài khoản
     *
     * @param idAccount id tài khoản
     * @return danh sách tên vài trò
     */
    @Transactional
    public List<String> getNames(UUID idAccount) {
        return userRoleRepository.findAllJoinTableByID(idAccount, "login", String.class);
    }

}

package vn.com.rabbit.service;

import org.springframework.stereotype.Service;

import vn.com.rabbit.base.service.BaseImplService;
import vn.com.rabbit.entity.Role;
import vn.com.rabbit.repository.RoleRepository;

@Service
public class RoleService extends BaseImplService<Role> {
	
	private final RoleRepository repository;
	
	protected RoleService(RoleRepository repo) {
		super(repo);
		this.repository = repo;
		// TODO Auto-generated constructor stub
	}
}

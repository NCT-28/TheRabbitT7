package vn.com.rabbit.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import vn.com.rabbit.common.Helper;
import vn.com.rabbit.entity.Account;
import vn.com.rabbit.entity.AccountInfo;
import vn.com.rabbit.entity.Role;
import vn.com.rabbit.entity.RoleAccount;
import vn.com.rabbit.repository.AccountRepository;
import vn.com.rabbit.repository.RoleRepository;
import vn.com.rabbit.service.AccountService;
import vn.com.rabbit.service.dto.AccountDto;
import vn.com.rabbit.service.dto.response.ResponseMess;


@Service
public class AccountServiceImpl implements AccountService {

	private final AccountRepository userRepository;
	private final RoleRepository roleRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	public AccountServiceImpl(AccountRepository user, BCryptPasswordEncoder pass, RoleRepository role) {
		this.userRepository = user;
		this.passwordEncoder = pass;
		this.roleRepository = role;
	}

	public void saveAndUpdate(HttpServletRequest request, Principal principal) {
		// Param
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String hoTen = request.getParameter("name");
		String[] roles = request.getParameterValues("roles");

		Account user = new Account();
		AccountInfo userInfo = new AccountInfo();

		if (request.getParameter("id") == null) {
			// New user
			user.setLogin(userName);
			user.setPassword(passwordEncoder.encode(passWord));
			user.setEmail(email);
			user.setActivated(true);
			user.setCreatedBy("Anonymous");

			// New UserInfo.
			userInfo.setMobile(phoneNumber);
			userInfo.setFullName(hoTen);
			userInfo.setAccount(user);
			userInfo.setCreatedBy("Anonymous");
			user.setAccountInfo(userInfo);

			// Set role by user.
			List<RoleAccount> model = new ArrayList<RoleAccount>();
			for (String name : roles) {
				Role role = roleRepository.findOneByName(name).get();
				
				if (role != null) {
					RoleAccount roleUser = new RoleAccount();
					roleUser.setRoles(role);
					roleUser.setAccounts(user);
					model.add(roleUser);
				}
			}
			user.setRoleAccount(model);

		} else {
			user.setUpdatedBy("admin");
			userInfo.setUpdatedBy("Anonymous");
		}

		// Save user.
		userRepository.save(user);

	}

	@Override
	public void save(AccountDto accountDto, Principal principal) {

		Account user = new Account();
		AccountInfo userInfo = new AccountInfo();

		if (accountDto.getId() == null) {
			// New user
			user.setLogin(accountDto.getUsername());
			user.setPassword(passwordEncoder.encode(accountDto.getPassword()));
			user.setEmail(accountDto.getEmail());
			user.setActivated(true);
			user.setCreatedBy("Anonymous");
			user.setUrl(Helper.pathVariableString(accountDto.getUsername()));

			// New UserInfo.
			userInfo.setMobile(accountDto.getPhoneNumber());
			userInfo.setFullName(accountDto.getHoTen());
			userInfo.setAccount(user);
			userInfo.setCreatedBy("Anonymous");
			user.setAccountInfo(userInfo);

			// Set role by user.
			List<RoleAccount> model = new ArrayList<RoleAccount>();
			if (accountDto.getRoles() != null) {
				for (String name : accountDto.getRoles()) {

					Role role = roleRepository.findOneByName(name).get();

					if (role == null) {
						role = new Role();
						role.setName(name);
					}

					RoleAccount roleUser = new RoleAccount();

					roleUser.setAccounts(user);
					roleUser.setRoles(role);
					model.add(roleUser);
				}
				user.setRoleAccount(model);
			}
		} else {
			user.setUpdatedBy("Anonymous");
			userInfo.setUpdatedBy("Anonymous");
		}

		// Save user.
		userRepository.save(user);
	}

	public ResponseMess<Account> getAllUser(Integer pageNo, Integer pageSize, String login, String sortType,
			String sortBy) {

		Pageable pageable = null;

		if (sortType.equals("ASC")) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.ASC, sortBy));
		} else if (sortType.equals("DESC")) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.DESC, sortBy));
		}
		Page<Account> enties = userRepository.findAllAccount(pageable, login);

		ResponseMess<Account> model = new ResponseMess<Account>();
		model.setMessage("");
		model.setTotal(enties.getTotalElements());
		model.setValues(enties.getContent());
		return model;
	}

	public AccountDto getUserWithAuthoritiesByLogin(String login) {
		Account _account = userRepository.findOneByLogin(login).get();
		List<Role> _roles = roleRepository.findAllRoleByUserId(login);

		AccountDto _model = new AccountDto();

		List<String> _roleModel = new ArrayList<String>();

		for (Role role : _roles) {

			_roleModel.add(role.getName());
		}

		_model.setRoles(_roleModel);
		_model.setUsername(_account.getLogin());
		_model.setPassword(_account.getPassword());

		return _model;
	}

}

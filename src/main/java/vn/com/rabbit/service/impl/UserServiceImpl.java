package vn.com.rabbit.service.impl;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import vn.com.rabbit.entity.Account;
import vn.com.rabbit.entity.AccountInfo;
import vn.com.rabbit.entity.RoleAccount;
import vn.com.rabbit.repository.AccountRepository;
import vn.com.rabbit.repository.RoleRepository;
import vn.com.rabbit.service.AccountService;
import vn.com.rabbit.service.model.ModelBase;

@Service
public class UserServiceImpl implements AccountService {


	private final AccountRepository userRepository;
	private final RoleRepository roleRepository;
	private final BCryptPasswordEncoder passwordEncoder;

	public UserServiceImpl(AccountRepository user, BCryptPasswordEncoder pass, RoleRepository role) {
		this.userRepository = user;
		this.passwordEncoder= pass;
		this.roleRepository = role;
	}

	public void saveAndUpdate(HttpServletRequest request, Principal principal) {
		//Param
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");
		String hoTen = request.getParameter("name");
		String[] roles = request.getParameterValues("roles");

        Account user = new Account();
		AccountInfo userInfo = new AccountInfo();

		if(request.getParameter("id") ==null) {
			//New user
			user.setLogin(userName);
			user.setPassword(passwordEncoder.encode(passWord));
			user.setEmail(email);
			user.setActivated(true);
			user.setCreatedBy("Anonymous");

			//New UserInfo.
			userInfo.setMobile(phoneNumber);
			userInfo.setFullName(hoTen);
			userInfo.setAccount(user);
			userInfo.setCreatedBy("Anonymous");
			user.setAccountInfo(userInfo);

			//Set role by user.
			List<RoleAccount>  model= new ArrayList<RoleAccount>();
			for (String name : roles) {
				//Role role = roleRepository.findOne("name");
				RoleAccount roleUser = new RoleAccount();
				//roleUser.setRoles(role);
				roleUser.setAccounts(user);
				model.add(roleUser);
			}
			user.setRoleAccount(model);

		}
		else {
			user.setUpdatedBy("admin");
			userInfo.setUpdatedBy("Anonymous");
		}


		// Save user.
		userRepository.save(user);

	}

	public ModelBase<Account> getAllUser(Integer pageNo, Integer pageSize, String login, String sortType, String sortBy) {

		Pageable pageable = null;

		if (sortType.equals("ASC")) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.ASC, sortBy));
		} else if (sortType.equals("DESC")) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.DESC, sortBy));
		}
		Page<Account> enties = userRepository.findAllAccount(pageable, login);

		ModelBase<Account> model = new ModelBase<Account>();
		model.setMessage("");
		model.setCount(enties.getTotalElements());
		model.setValue(enties.getContent());
		return model;
	}

	public Optional<Account> getUserWithAuthoritiesByLogin(String login) {
		return userRepository.findOneByLogin(login);
	}

}

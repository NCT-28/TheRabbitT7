package vn.com.rabbit.service.impl;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.rabbit.entity.Category;
import vn.com.rabbit.entity.User;
import vn.com.rabbit.entity.UserInfo;
import vn.com.rabbit.repository.UserRepository;
import vn.com.rabbit.service.UserService;
import vn.com.rabbit.service.model.ModelBase;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public void saveAndUpdate(HttpServletRequest request, Principal principal) {
		// TODO Auto-generated method stub
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("passWord");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phoneNumber");

		User user = new User();
		user.setLogin(userName);
		user.setPassword(passwordEncoder.encode(passWord));
		user.setEmail(email);
		user.setActivated(true);
		user.setCreatedBy((request.getParameter("id") != null) ? principal.getName() : "Anonymous");
		user.setUpdatedBy((request.getParameter("id") == null) ? "Anonymous" : principal.getName());

		UserInfo userInfo = new UserInfo();
		userInfo.setMobile(phoneNumber);
		userInfo.setUser(user);
		userInfo.setCreatedBy((request.getParameter("id") != null) ? principal.getName() : "Anonymous");
		userInfo.setUpdatedBy((request.getParameter("id") == null) ? "Anonymous" : principal.getName());

		user.setUserInfo(userInfo);

		// Save user.
		userRepository.save(user);

	}

	@Override
	public ModelBase<User> getAllUser(Integer pageNo, Integer pageSize, String login, String sortType, String sortBy) {
		
		Pageable pageable = null;

		if (sortType.equals("ASC")) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.ASC, sortBy));
		} else if (sortType.equals("DESC")) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.DESC, sortBy));
		}
		Page<User> enties = userRepository.findAllUser(pageable, login);

		ModelBase<User> model = new ModelBase<User>();
		model.setMessage("");
		model.setCount(enties.getTotalElements());
		model.setValue(enties.getContent());
		return model;
	}

	@Transactional(readOnly = true)
	public Optional<User> getUserWithAuthoritiesByLogin(String login) {
		return userRepository.findOneByLogin(login);
	}

}

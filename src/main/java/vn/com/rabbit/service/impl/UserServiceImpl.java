package vn.com.rabbit.service.impl;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.rabbit.entity.User;
import vn.com.rabbit.entity.UserInfo;
import vn.com.rabbit.repository.UserRepository;
import vn.com.rabbit.service.UserService;

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
		
		UserInfo userInfo= new UserInfo();
		userInfo.setMobile(phoneNumber);
		userInfo.setUser(user);
		userInfo.setCreatedBy((request.getParameter("id") != null) ? principal.getName() : "Anonymous");
		userInfo.setUpdatedBy((request.getParameter("id") == null) ? "Anonymous" : principal.getName());
		
		user.setUserInfo(userInfo);
		
		//Save user.
		userRepository.save(user);
		
	}
	
	@Transactional(readOnly = true)
	public Optional<User> getUserWithAuthoritiesByLogin(String login) {
		return userRepository.findOneByLogin(login);
	}

	
}

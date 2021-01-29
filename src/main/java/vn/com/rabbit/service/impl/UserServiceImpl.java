//package vn.com.rabbit.service.impl;
//
//import java.security.Principal;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import vn.com.rabbit.entity.Role;
//import vn.com.rabbit.entity.RoleUser;
//import vn.com.rabbit.entity.User;
//import vn.com.rabbit.entity.UserInfo;
//import vn.com.rabbit.repository.RoleRepository;
//import vn.com.rabbit.repository.UserRepository;
//import vn.com.rabbit.service.UserService;
//import vn.com.rabbit.service.model.ModelBase;
//
//public class UserServiceImpl {
//
//	
//	private final UserRepository userRepository;
//	private final RoleRepository roleRepository;
//	private final BCryptPasswordEncoder passwordEncoder;
//	
//	public UserServiceImpl(UserRepository user, BCryptPasswordEncoder pass, RoleRepository role) {
//		this.userRepository = user;
//		this.passwordEncoder= pass;
//		this.roleRepository = role;
//	}
//
////	public void saveAndUpdate(HttpServletRequest request, Principal principal) {
////		//Param 
////		String userName = request.getParameter("userName");
////		String passWord = request.getParameter("passWord");
////		String email = request.getParameter("email");
////		String phoneNumber = request.getParameter("phoneNumber");
////		String hoTen = request.getParameter("name");
////		String[] roles = request.getParameterValues("roles");
////		
////		User user = new User();
////		UserInfo userInfo = new UserInfo();
////		
////		if(request.getParameter("id") ==null) {
////			//New user
////			user.setLogin(userName);
////			user.setPassword(passwordEncoder.encode(passWord));
////			user.setEmail(email);
////			user.setActivated(true);
////			user.setCreatedBy("Anonymous");
////			
////			//New UserInfo.
////			userInfo.setMobile(phoneNumber);
////			userInfo.setFullName(hoTen);
////			userInfo.setUser(user);
////			userInfo.setCreatedBy("Anonymous");
////			user.setUserInfo(userInfo);	
////			
////			//Set role by user.
////			List<RoleUser>  model= new ArrayList<RoleUser>();
////			for (String name : roles) {
////				Role role = roleRepository.findOneByName(name).get();
////				RoleUser roleUser = new RoleUser();
////				roleUser.setRoles(role);
////				roleUser.setUsers(user);
////				model.add(roleUser);
////			}
////			user.setRoleUsers(model);		
////			
////		}
////		else {
////			user.setUpdatedBy("admin");
////			userInfo.setUpdatedBy("Anonymous");
////		}
////		
////		
////		// Save user.
////		userRepository.save(user);
////
////	}
////
////	public ModelBase<User> getAllUser(Integer pageNo, Integer pageSize, String login, String sortType, String sortBy) {
////		
////		Pageable pageable = null;
////
////		if (sortType.equals("ASC")) {
////			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.ASC, sortBy));
////		} else if (sortType.equals("DESC")) {
////			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.DESC, sortBy));
////		}
////		Page<User> enties = userRepository.findAllUser(pageable, login);
////
////		ModelBase<User> model = new ModelBase<User>();
////		model.setMessage("");
////		model.setCount(enties.getTotalElements());
////		model.setValue(enties.getContent());
////		return model;
////	}
////
////	public Optional<User> getUserWithAuthoritiesByLogin(String login) {
////		return userRepository.findOneByLogin(login);
////	}
//
//}

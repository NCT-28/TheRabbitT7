package vn.com.rabbit.service;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import vn.com.rabbit.entity.User;
import vn.com.rabbit.service.model.ModelBase;

public interface UserService {

	void saveAndUpdate(HttpServletRequest request, Principal principal);

	ModelBase<User> getAllUser(Integer pageNo, Integer pageSize, String name, String sortType, String sortBy);
	
	Optional<User> getUserWithAuthoritiesByLogin(String login);

}

package vn.com.rabbit.service;


import vn.com.rabbit.entity.User;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;


public interface UserService {
	
	 void saveAndUpdate(HttpServletRequest request, Principal principal);
    Optional<User> getUserWithAuthoritiesByLogin(String login);
   
}

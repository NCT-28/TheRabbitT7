package vn.com.rabbit.service;


import vn.com.rabbit.entity.User;

import java.util.Optional;


public interface UserService {
	
    Optional<User> getUserWithAuthoritiesByLogin(String login);
    
}

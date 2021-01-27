package vn.com.rabbit.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import vn.com.rabbit.repository.UserRepository;
import vn.com.rabbit.service.UserRoleService;

@Service
public class MyUserDetailsService implements UserDetailsService {
 
    private final UserRepository userRepository;
  
    private final UserRoleService userRoleService;
    
    public MyUserDetailsService (UserRepository userRepository, UserRoleService userRoleService) {
    	this.userRepository = userRepository;
    	this.userRoleService = userRoleService;
    }
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        vn.com.rabbit.entity.User user = userRepository.findByName("login", username);
        System.out.println("UserInfo= " + user);

        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
         
        // [USER,ADMIN,..]
        List<String> roles= userRoleService.getNames(user.getUuid());
         
        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        if(roles!= null)  {
            for(String role: roles)  {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        UserDetails userDetails = new User(user.getLogin(), //
                user.getPassword(),grantList);
 
        return userDetails;
    }
     
}

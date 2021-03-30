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

import vn.com.rabbit.entity.Account;
import vn.com.rabbit.entity.Role;
import vn.com.rabbit.repository.AccountRepository;


@Service
public class MyUserDetailsService implements UserDetailsService {

	
    private final AccountRepository  accountRepository;
    
    public MyUserDetailsService(AccountRepository  accountRepository) {
    	this.accountRepository = accountRepository;
    }
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account user = accountRepository.findOneByLogin(username).get();
        System.out.println("UserInfo= " + user);

        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
         
        // [USER,ADMIN,..]
        List<Role> roles= accountRepository.findAllRoleByUserId(username);
         
        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        if(roles!= null)  {
            for(Role role: roles)  {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
                grantList.add(authority);
            }
        }
        UserDetails userDetails = new User(user.getLogin(), //
                user.getPassword(),grantList);
 
        return userDetails;
    }
     
}

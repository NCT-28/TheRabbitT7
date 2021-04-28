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
import org.springframework.social.security.SocialUserDetails;
import org.springframework.stereotype.Service;

import vn.com.rabbit.service.AccountService;
import vn.com.rabbit.service.dto.AccountDto;
import vn.com.rabbit.service.mapper.AccountMapper;
import vn.com.rabbit.service.user.MySocialUserDetails;


@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
    private AccountService  _service;
	
	@Autowired
	private AccountMapper  _mapper;
    
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	
    	AccountDto _account = _service.getUserWithAuthoritiesByLogin(username);
         	
        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
        
        if(_account.getRoles() != null)  {
            for(String role: _account.getRoles())  {            	
                GrantedAuthority authority = new SimpleGrantedAuthority(role);
                grantList.add(authority);
            }
        }
        // Chú ý: SocialUserDetails mở rộng từ interface UserDetails.
        SocialUserDetails principal = new MySocialUserDetails(_mapper.dtoToEntity(_account));
 
        return principal;
    }
     
}

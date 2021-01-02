package vn.com.rabbit.common;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class test {
	public static void main(String[] args) {
		 Set<String> r= new HashSet<String>();
		 r.add("role_admin");
		 r.add("role_user");
         
	        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
	        if(r!= null)  {
	            for(String role: r)  {
	                // ROLE_USER, ROLE_ADMIN,..
	                GrantedAuthority authority = new SimpleGrantedAuthority(role);
	                grantList.add(authority);
	            }
	        } 
	        System.out.println(r);
	        
	        String password = "admin";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);

			System.out.println(hashedPassword);
	        
	}
}

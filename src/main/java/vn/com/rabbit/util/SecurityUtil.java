package vn.com.rabbit.util;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import vn.com.rabbit.entity.Account;
import vn.com.rabbit.service.user.MySocialUserDetails;

public class SecurityUtil {

	// Tự động đăng nhập.
	public static void logInUser(Account user) {

		MySocialUserDetails userDetails = new MySocialUserDetails(user);

		Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null,
				userDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
	}
}

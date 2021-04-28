package vn.com.rabbit.service.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.social.security.SocialUserDetails;

import vn.com.rabbit.entity.Account;

public class MySocialUserDetails implements SocialUserDetails {

	private static final long serialVersionUID = -5246117266247684905L;

	private List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

	private Account _account;

	public MySocialUserDetails(Account myUserAccount) {
		this._account = myUserAccount;
		String role = "ROLE_ADMIN";

		GrantedAuthority grant = new SimpleGrantedAuthority(role);
		this.list.add(grant);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return _account.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return _account.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getUserId() {
		// TODO Auto-generated method stub
		return null;
	}

}

package vn.com.rabbit.service;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import vn.com.rabbit.entity.Account;
import vn.com.rabbit.service.model.ModelBase;

public interface AccountService {

	void saveAndUpdate(HttpServletRequest request, Principal principal);
	ModelBase<Account> getAllUser(Integer pageNo, Integer pageSize, String login, String sortType, String sortBy);
	Optional<Account> getUserWithAuthoritiesByLogin(String login);
}

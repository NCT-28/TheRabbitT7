package vn.com.rabbit.service;

import org.springframework.stereotype.Service;
import vn.com.rabbit.entity.Account;
import vn.com.rabbit.service.model.ModelBase;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

public interface AccountService {

	void saveAndUpdate(HttpServletRequest request, Principal principal);
	ModelBase<Account> getAllUser(Integer pageNo, Integer pageSize, String login, String sortType, String sortBy);
	Optional<Account> getUserWithAuthoritiesByLogin(String login);
}

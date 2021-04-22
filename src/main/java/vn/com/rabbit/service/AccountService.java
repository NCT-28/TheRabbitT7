package vn.com.rabbit.service;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import vn.com.rabbit.entity.Account;
import vn.com.rabbit.service.dto.AccountDto;
import vn.com.rabbit.service.dto.response.ResponseMess;

public interface AccountService {

	void saveAndUpdate(HttpServletRequest request, Principal principal);

	void save(AccountDto accountDto, Principal principal);

	ResponseMess<Account> getAllUser(Integer pageNo, Integer pageSize, String login, String sortType, String sortBy);

	AccountDto getUserWithAuthoritiesByLogin(String login);
}

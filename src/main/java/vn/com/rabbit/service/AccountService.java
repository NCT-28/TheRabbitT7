package vn.com.rabbit.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.rabbit.base.service.BaseImplService;
import vn.com.rabbit.entity.Account;
import vn.com.rabbit.repository.AccountRepository;

@Service
public class AccountService extends BaseImplService<Account> {

	@Autowired
	private AccountRepository accountRepository;

	protected AccountService(AccountRepository repo) {
		super(repo);
		
	}

	@Transactional
	public Account save(Account model) {

		Account user = new Account();
		// Save user.
		return accountRepository.save(user);

	}

	@Transactional(readOnly = true)
	public Optional<Account> getUserWithAuthoritiesByLogin(String login) {
		return Optional.of(accountRepository.findByName("login", login));
	}

}

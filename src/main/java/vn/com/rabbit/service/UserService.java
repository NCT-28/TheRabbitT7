package vn.com.rabbit.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.com.rabbit.base.service.BaseImplService;
import vn.com.rabbit.entity.User;
import vn.com.rabbit.repository.UserRepository;

@Service
public class UserService extends BaseImplService<User> {

	private final UserRepository userRepository;

	protected UserService(UserRepository repo) {
		super(repo);
		this.userRepository = repo;
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public User save(User model) {

		User user = new User();
		// Save user.
		return userRepository.save(user);

	}

	@Transactional(readOnly = true)
	public Optional<User> getUserWithAuthoritiesByLogin(String login) {
		return Optional.of(userRepository.findByName("login", login));
	}

}

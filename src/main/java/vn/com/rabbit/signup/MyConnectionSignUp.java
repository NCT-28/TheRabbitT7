package vn.com.rabbit.signup;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

import vn.com.rabbit.entity.Account;
import vn.com.rabbit.service.AccountService;

public class MyConnectionSignUp implements ConnectionSignUp {

	private AccountService myUserAccountDAO;

	public MyConnectionSignUp(AccountService myUserAccountDAO) {
		this.myUserAccountDAO = myUserAccountDAO;
	}

	// Sau khi đăng nhập mạng xã hội xong.
	// Phương thức này sẽ được gọi để tạo ra một bản ghi User_Account tương ứng
	// nếu nó chưa tồn tại.
	@Override
	public String execute(Connection<?> connection) {

		Account account = myUserAccountDAO.createUserAccount(connection);
		return account.getId().toString();
	}
}

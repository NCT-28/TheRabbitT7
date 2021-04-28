package vn.com.rabbit.service.mapper;

import org.springframework.stereotype.Service;

import vn.com.rabbit.entity.Account;
import vn.com.rabbit.service.dto.AccountDto;

@Service
public class AccountMapper extends BaseMapper<Account, AccountDto> {

	@Override
	public AccountDto entityToDTO(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account dtoToEntity(AccountDto dto) {
		if(dto !=null) {
			
			Account a = new Account();
			///
			a.setLogin(dto.getUsername());
			a.setPassword(dto.getPassword());
			
			
			return a;
			
		}
		return null;
	}

	

}

package vn.com.rabbit.service.impl;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import vn.com.rabbit.entity.Role;
import vn.com.rabbit.repository.RoleRepository;
import vn.com.rabbit.service.RoleService;
import vn.com.rabbit.service.dto.RoleDTO;
import vn.com.rabbit.service.dto.response.ResponseMess;

@Service
public class RoleServiceImpl implements RoleService {

	private final RoleRepository roleRepository;

	public RoleServiceImpl(RoleRepository role) {
		this.roleRepository = role;
	}


	@Override
	public void delete(UUID id) {
		roleRepository.deleteById(id);
	}

	@Override
	public void saveAndUpdate(RoleDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResponseMess<Role> getAllTs(Integer pageNo, Integer pageSize, String name, String sortType, String sortBy) {
		// TODO Auto-generated method stub
		Pageable pageable = null;

		if (sortType.equals("ASC")) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.ASC, sortBy));
		} else if (sortType.equals("DESC")) {
			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.DESC, sortBy));
		}
		Page<Role> enties = roleRepository.findAllRole(pageable, name);

		ResponseMess<Role> model = new ResponseMess<Role>();
		model.setMessage("");
		model.setTotal(enties.getTotalElements());
		model.setValues(enties.getContent());
		return model;
	}

	@Override
	public Optional<Role> getOneTById(UUID id) {
		// TODO Auto-generated method stub
		return roleRepository.findById(id);
	}

}

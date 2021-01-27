//package vn.com.rabbit.service.impl;
//
//import java.security.Principal;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.domain.Sort.Direction;
//import org.springframework.stereotype.Service;
//
//import vn.com.rabbit.entity.Role;
//import vn.com.rabbit.repository.RoleRepository;
//import vn.com.rabbit.service.RoleService;
//import vn.com.rabbit.service.model.ModelBase;
//
//@Service
//public class RoleServiceImpl implements RoleService {
//
//	private final RoleRepository roleRepository;
//
//	public RoleServiceImpl(RoleRepository role) {
//		this.roleRepository = role;
//	}
//
//	@Override
//	public void saveAndUpdate(HttpServletRequest request, Principal principal) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public ModelBase<Role> getAll(Integer pageNo, Integer pageSize, String name, String sortType, String sortBy) {
//		Pageable pageable = null;
//
//		if (sortType.equals("ASC")) {
//			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.ASC, sortBy));
//		} else if (sortType.equals("DESC")) {
//			pageable = PageRequest.of(pageNo - 1, pageSize, Sort.by(Direction.DESC, sortBy));
//		}
//		Page<Role> enties = roleRepository.findAllRoles(pageable, name);
//
//		ModelBase<Role> model = new ModelBase<Role>();
//		model.setMessage("");
//		model.setCount(enties.getTotalElements());
//		model.setValue(enties.getContent());
//		return model;
//	}
//
//}

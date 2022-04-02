package ca.sheridancollege.tapnioc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.sheridancollege.tapnioc.domain.Role;
import ca.sheridancollege.tapnioc.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Optional<Role> getRoleByRoleId(Long id) {
		return roleRepository.findById(id);
	}

	@Override
	public Role save(Role role) {
		return roleRepository.save(role);
	}

}

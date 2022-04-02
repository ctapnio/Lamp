package ca.sheridancollege.tapnioc.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import ca.sheridancollege.tapnioc.domain.Role;

@Service
public interface RoleService {
	Optional<Role> getRoleByRoleId(Long id);

	public Role save(Role role);
}

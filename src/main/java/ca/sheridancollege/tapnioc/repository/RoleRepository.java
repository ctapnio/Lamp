package ca.sheridancollege.tapnioc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.tapnioc.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	Role getRoleByRoleId(Long id);
}

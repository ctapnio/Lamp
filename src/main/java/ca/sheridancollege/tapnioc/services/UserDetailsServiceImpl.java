package ca.sheridancollege.tapnioc.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ca.sheridancollege.tapnioc.domain.Role;
import ca.sheridancollege.tapnioc.repository.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		ca.sheridancollege.tapnioc.domain.User user = userRepository.findByEmail(email);
		if (user == null) {
			System.out.println("User not found:" + email);
			throw new UsernameNotFoundException("User " + email + " was not found in the database");
		}

		List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		for (Role role : user.getRoleList()) {

			grantList.add(new SimpleGrantedAuthority(role.getRoleName()));
		}

		UserDetails userDetails = (UserDetails) new org.springframework.security.core.userdetails.User(user.getEmail(),
				user.getEncryptedPassword(), grantList);

		return userDetails;

	}

}

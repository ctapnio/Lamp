package ca.sheridancollege.tapnioc.web.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.tapnioc.domain.Role;
import ca.sheridancollege.tapnioc.domain.User;
import ca.sheridancollege.tapnioc.models.AuthenticationRequest;
import ca.sheridancollege.tapnioc.models.AuthenticationResponse;
import ca.sheridancollege.tapnioc.services.JwtUtil;
import ca.sheridancollege.tapnioc.services.RoleService;
import ca.sheridancollege.tapnioc.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/auth")
@CrossOrigin("http://localhost:4200")
public class AuthenticationController {

	private UserDetailsService userDetailsService;
	private AuthenticationManager authenticationManager;
	private UserService userService;
	private RoleService roleService;
	private JwtUtil jwtUtil;

	//authenticate and generate jwt for user
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		return ResponseEntity.ok(new AuthenticationResponse(jwtUtil.generateToken(userDetails)));
	}

	//register user
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		try {
			if (userService.existsByEmail(authenticationRequest.getUsername())) {
				throw new Exception("Email address already in use.");

			} else {
				User user = new User();
				user.setEmail(authenticationRequest.getUsername());
				user.setEncryptedPassword(authenticationRequest.getPassword());
				Optional<Role> role = roleService.getRoleByRoleId(1l);
				List<Role> roleList = new ArrayList<Role>();
				roleList.add(role.get());
				user.setRoleList(roleList);
				userService.save(user);
				System.out.println("User successfully created");
			}
		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);

		}
		return login(authenticationRequest);
	}

}

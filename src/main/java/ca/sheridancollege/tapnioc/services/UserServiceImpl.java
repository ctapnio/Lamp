package ca.sheridancollege.tapnioc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ca.sheridancollege.tapnioc.domain.Post;
import ca.sheridancollege.tapnioc.domain.User;
import ca.sheridancollege.tapnioc.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public Boolean existsByEmail(String email) {

		return userRepository.existsByEmail(email);
	}

	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> findByPostListContains(Post post) {
		
		return userRepository.findByPostListContains(post);
	}

}

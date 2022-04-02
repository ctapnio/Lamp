package ca.sheridancollege.tapnioc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ca.sheridancollege.tapnioc.domain.Post;
import ca.sheridancollege.tapnioc.domain.User;

@Service
public interface UserService {
	public List<User> findAll();

	public Optional<User> findById(Long id);

	public User save(User user);

	Boolean existsByEmail(String email);

	User findByEmail(String email);

	List<User> findByPostListContains(Post post);
}

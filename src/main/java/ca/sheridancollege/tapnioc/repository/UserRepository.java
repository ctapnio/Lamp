package ca.sheridancollege.tapnioc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.tapnioc.domain.Post;
import ca.sheridancollege.tapnioc.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

	public List<User> findAll();

	public Optional<User> findById(Long id);

	Boolean existsByEmail(String email);

	User findByEmail(String email);

	List<User> findByPostListContains(Post post);

}

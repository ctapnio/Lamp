package ca.sheridancollege.tapnioc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import ca.sheridancollege.tapnioc.domain.Post;

@Service
public interface PostService {
	List<Post> findByHeading(String heading);

	List<Post> findByAuthorOrderByIdDesc(String author);

	Optional<Post> findById(Long id);

	List<Post> findAll();

	Post save(Post post);

	List<Post> findAllByOrderByIdDesc();

	List<Post> search(@Param("keyword") String keyword);
	
	void deleteById(Long id);
}

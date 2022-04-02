package ca.sheridancollege.tapnioc.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.tapnioc.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	List<Post> findByHeading(String heading);

	List<Post> findByAuthorOrderByIdDesc(String author);

	@Query("select DISTINCT p from Post p where p.author like %:#{#keyword}% OR p.heading like %:#{#keyword}% OR p.body like %:#{#keyword}%")
	List<Post> search(@Param("keyword") String keyword);
	
	Optional<Post> findById(Long id);
}

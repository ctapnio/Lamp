package ca.sheridancollege.tapnioc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ca.sheridancollege.tapnioc.domain.Post;
import ca.sheridancollege.tapnioc.repository.PostRepository;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public Optional<Post> findById(Long id) {
		return postRepository.findById(id);
	}

	@Override
	public List<Post> findByHeading(String heading) {
		return postRepository.findByHeading(heading);
	}

	@Override
	public List<Post> findByAuthorOrderByIdDesc(String author) {
		return postRepository.findByAuthorOrderByIdDesc(author);
	}

	@Override
	public Post save(Post post) {
		return postRepository.save(post);
	}

	@Override
	public List<Post> findAllByOrderByIdDesc() {
		return postRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
	}

	@Override
	public void deleteById(Long id) {
		postRepository.deleteById(id);
	}

	@Override
	public List<Post> search(String keyword) {
		return postRepository.search(keyword);
	}

}

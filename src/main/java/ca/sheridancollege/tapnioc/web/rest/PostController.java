package ca.sheridancollege.tapnioc.web.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.sheridancollege.tapnioc.domain.Post;
import ca.sheridancollege.tapnioc.domain.User;
import ca.sheridancollege.tapnioc.services.PostService;
import ca.sheridancollege.tapnioc.services.UserService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/posts")
@CrossOrigin(value = "http://localhost:8080")
public class PostController {

	private PostService postService;
	private UserService userService;

	// get all posts ~ latest first
	@GetMapping(value = { "", "/", "/search" })
	public List<Post> findAllByOrderByDateDesc() {
		return postService.findAllByOrderByIdDesc();
	}

	// search by keyword
	@GetMapping("/search/{keyword}")
	public List<Post> findByAuthorOrHeadingOrBodyContains(@PathVariable String keyword) {
		return postService.search(keyword);

	}

	// add post
	@PostMapping(value = { "", "/" })
	public Post savePost(@RequestBody Post post) {
		return postService.save(post);
	}

	// edit post
	@PostMapping("/myPosts/edit/{id}")
	public Post editPost(@RequestBody Post post) {
		return postService.save(post);
	}

	// get all my posts
	@GetMapping("/myPosts/{author}")
	public List<Post> findByAuthor(@PathVariable String author) {
		return postService.findByAuthorOrderByIdDesc(author);
	}

	// delete post
	@PostMapping("/delete/{id}")
	public void findById(@PathVariable Long id) {
		for (User user : userService.findByPostListContains(postService.findById(id).get())) {
			user.getPostList().remove(postService.findById(id).get());
			userService.save(user);
		}
		postService.deleteById(id);
	}

}

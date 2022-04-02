package ca.sheridancollege.tapnioc.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import lombok.*;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@NonNull
	private String email;

	@NonNull
	private String encryptedPassword;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Role> roleList = new ArrayList<Role>();

	@OneToMany(fetch = FetchType.LAZY)
	private List<Post> postList;
}

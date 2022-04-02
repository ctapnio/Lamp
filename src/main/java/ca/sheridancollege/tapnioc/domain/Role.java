package ca.sheridancollege.tapnioc.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long roleId;
	
	@NonNull
	private String roleName;
	
	
	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "roleList") 
	private List<User> userList = new ArrayList<User>();

}

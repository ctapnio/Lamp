package ca.sheridancollege.tapnioc.bootstrap;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.tapnioc.domain.Post;
import ca.sheridancollege.tapnioc.domain.Role;
import ca.sheridancollege.tapnioc.domain.User;
import ca.sheridancollege.tapnioc.services.PostService;
import ca.sheridancollege.tapnioc.services.RoleService;
import ca.sheridancollege.tapnioc.services.UserService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class PostBootstrap implements CommandLineRunner{

	
	private PostService postService;
	private UserService userService;
	private RoleService roleService;
	
	@Override
	public void run(String... args) throws Exception {
		
		User user1 = userService.save(new User("guccimane", "atlanta"));  
		Role role1 = roleService.save(new Role("ROLE_USER"));
		
		List<Role> roleList1 = new ArrayList<Role>(); 
		roleList1.add(role1);
		
		List<User> userList1 = new ArrayList<User>();
		userList1.add(user1);
		
		role1.setUserList(userList1); 
		user1.setRoleList(roleList1);
		
		
		userService.save(user1); 
		roleService.save(role1);

		Post s1 = new Post("guccimane", "PodReco v1.0 Release", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas interdum massa sit amet nisi gravida aliquet. Fusce et feugiat eros. Donec id laoreet eros. Suspendisse eu congue felis. Pellentesque ac libero in lectus finibus volutpat dignissim nec dui. Donec suscipit nibh leo, vel consequat urna porta vitae. Mauris iaculis augue eget diam pretium placerat. Aenean sem ligula, fringilla aliquet risus ut, interdum pellentesque augue. Duis interdum fermentum nisl, vehicula porta nibh pulvinar in. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris ac faucibus magna, auctor consectetur odio. Curabitur et risus eu dui blandit fermentum a lobortis nunc. Nulla congue sodales urna vulputate iaculis.\n"
				+ "\n"
				+ "Etiam venenatis quis libero non consectetur. Fusce scelerisque augue ut bibendum bibendum. Praesent id dapibus velit, sit amet malesuada ex. Etiam a diam eros. Donec vitae odio ac nisi aliquet pellentesque id ac odio. Aenean a vehicula libero. Fusce accumsan ex nec nulla egestas mollis. Morbi efficitur purus id hendrerit blandit. Etiam sed ex urna. Sed vehicula semper massa non aliquam. Praesent mollis luctus malesuada. Nulla dapibus dolor in ex eleifend, id imperdiet eros mollis.\n"
				+ "\n"
				+ "Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aliquam eleifend bibendum tellus et fringilla. Duis condimentum turpis id purus posuere, eu facilisis ante feugiat. Aenean at aliquam odio. Sed ut nulla non libero faucibus lacinia. Donec mollis magna et massa consectetur pellentesque. Sed faucibus vehicula nisi, vitae vehicula urna elementum eu. Sed id consectetur nisl. Morbi sit amet euismod lorem, in auctor ex. Etiam id dolor ex.\n"
				+ "\n"
				+ "Quisque tristique euismod purus, quis molestie nisi efficitur eu. Etiam vestibulum quam sit amet enim tristique, lobortis vulputate libero finibus. Donec porttitor a leo non porta. Morbi a nisi leo. Mauris mollis tellus sem, non imperdiet magna gravida pulvinar. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aenean egestas sodales odio ut iaculis. In sit amet orci sed dui fermentum blandit vel at lectus. Curabitur maximus mauris nibh, non finibus nisl feugiat vitae. Curabitur sollicitudin turpis arcu, sed commodo ligula elementum id. Proin et elit metus.\n"
				+ "\n"
				+ "Integer iaculis augue sem, ut convallis ipsum dictum sit amet. Ut ornare, odio quis suscipit vestibulum, dui nibh mollis libero, id blandit velit augue eget dui. Mauris id orci pulvinar, sodales tellus eget, pharetra est. Curabitur sed mi gravida, fringilla turpis non, convallis dolor. Nulla congue ex eu est auctor, at vulputate risus facilisis. Fusce eget purus ut est vulputate euismod ac ut sapien. Proin eget lacus pellentesque velit rutrum fringilla. Vivamus ut dolor nec mi lacinia rutrum. Donec ornare gravida velit. Vestibulum placerat euismod rutrum. Cras vitae risus a erat cursus dictum. Maecenas ut lacus eros.", LocalDate.of(2018, Month.of(9),  8));
		
		
		Post s2 = new Post("guccimane", "Toronto Auto v1.0 Release", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas interdum massa sit amet nisi gravida aliquet. Fusce et feugiat eros. Donec id laoreet eros. Suspendisse eu congue felis. Pellentesque ac libero in lectus finibus volutpat dignissim nec dui. Donec suscipit nibh leo, vel consequat urna porta vitae. Mauris iaculis augue eget diam pretium placerat. Aenean sem ligula, fringilla aliquet risus ut, interdum pellentesque augue. Duis interdum fermentum nisl, vehicula porta nibh pulvinar in. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris ac faucibus magna, auctor consectetur odio. Curabitur et risus eu dui blandit fermentum a lobortis nunc. Nulla congue sodales urna vulputate iaculis.\n"
				+ "\n"
				+ "Etiam venenatis quis libero non consectetur. Fusce scelerisque augue ut bibendum bibendum. Praesent id dapibus velit, sit amet malesuada ex. Etiam a diam eros. Donec vitae odio ac nisi aliquet pellentesque id ac odio. Aenean a vehicula libero. Fusce accumsan ex nec nulla egestas mollis. Morbi efficitur purus id hendrerit blandit. Etiam sed ex urna. Sed vehicula semper massa non aliquam. Praesent mollis luctus malesuada. Nulla dapibus dolor in ex eleifend, id imperdiet eros mollis.\n"
				+ "\n"
				+ "Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aliquam eleifend bibendum tellus et fringilla. Duis condimentum turpis id purus posuere, eu facilisis ante feugiat. Aenean at aliquam odio. Sed ut nulla non libero faucibus lacinia. Donec mollis magna et massa consectetur pellentesque. Sed faucibus vehicula nisi, vitae vehicula urna elementum eu. Sed id consectetur nisl. Morbi sit amet euismod lorem, in auctor ex. Etiam id dolor ex.\n"
				+ "\n"
				+ "Quisque tristique euismod purus, quis molestie nisi efficitur eu. Etiam vestibulum quam sit amet enim tristique, lobortis vulputate libero finibus. Donec porttitor a leo non porta. Morbi a nisi leo. Mauris mollis tellus sem, non imperdiet magna gravida pulvinar. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aenean egestas sodales odio ut iaculis. In sit amet orci sed dui fermentum blandit vel at lectus. Curabitur maximus mauris nibh, non finibus nisl feugiat vitae. Curabitur sollicitudin turpis arcu, sed commodo ligula elementum id. Proin et elit metus.\n"
				+ "\n"
				+ "Integer iaculis augue sem, ut convallis ipsum dictum sit amet. Ut ornare, odio quis suscipit vestibulum, dui nibh mollis libero, id blandit velit augue eget dui. Mauris id orci pulvinar, sodales tellus eget, pharetra est. Curabitur sed mi gravida, fringilla turpis non, convallis dolor. Nulla congue ex eu est auctor, at vulputate risus facilisis. Fusce eget purus ut est vulputate euismod ac ut sapien. Proin eget lacus pellentesque velit rutrum fringilla. Vivamus ut dolor nec mi lacinia rutrum. Donec ornare gravida velit. Vestibulum placerat euismod rutrum. Cras vitae risus a erat cursus dictum. Maecenas ut lacus eros.", LocalDate.of(2019, Month.of(10),  2));
		
		List<Post> postList1 = new ArrayList<Post>();
		postList1.add(s1);
		postList1.add(s2);
		user1.setPostList(postList1);
		
		postService.save(s1);
		postService.save(s2);
		userService.save(user1); 
		
		User user2 = userService.save(new User("kanyewest", "chicago"));  
		
		List<Role> roleList2 = new ArrayList<Role>(); 
		roleList2.add(role1);
		
		List<User> userList2 = new ArrayList<User>();
		userList2.add(user1);
		
		role1.setUserList(userList1); 
		user2.setRoleList(roleList1);
		
		
		userService.save(user1); 
		roleService.save(role1);

		Post s3 = new Post("kanyewest", "PodReco v1.1 Release", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas interdum massa sit amet nisi gravida aliquet. Fusce et feugiat eros. Donec id laoreet eros. Suspendisse eu congue felis. Pellentesque ac libero in lectus finibus volutpat dignissim nec dui. Donec suscipit nibh leo, vel consequat urna porta vitae. Mauris iaculis augue eget diam pretium placerat. Aenean sem ligula, fringilla aliquet risus ut, interdum pellentesque augue. Duis interdum fermentum nisl, vehicula porta nibh pulvinar in. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris ac faucibus magna, auctor consectetur odio. Curabitur et risus eu dui blandit fermentum a lobortis nunc. Nulla congue sodales urna vulputate iaculis.\n"
				+ "\n"
				+ "Etiam venenatis quis libero non consectetur. Fusce scelerisque augue ut bibendum bibendum. Praesent id dapibus velit, sit amet malesuada ex. Etiam a diam eros. Donec vitae odio ac nisi aliquet pellentesque id ac odio. Aenean a vehicula libero. Fusce accumsan ex nec nulla egestas mollis. Morbi efficitur purus id hendrerit blandit. Etiam sed ex urna. Sed vehicula semper massa non aliquam. Praesent mollis luctus malesuada. Nulla dapibus dolor in ex eleifend, id imperdiet eros mollis.\n"
				+ "\n"
				+ "Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aliquam eleifend bibendum tellus et fringilla. Duis condimentum turpis id purus posuere, eu facilisis ante feugiat. Aenean at aliquam odio. Sed ut nulla non libero faucibus lacinia. Donec mollis magna et massa consectetur pellentesque. Sed faucibus vehicula nisi, vitae vehicula urna elementum eu. Sed id consectetur nisl. Morbi sit amet euismod lorem, in auctor ex. Etiam id dolor ex.\n"
				+ "\n"
				+ "Quisque tristique euismod purus, quis molestie nisi efficitur eu. Etiam vestibulum quam sit amet enim tristique, lobortis vulputate libero finibus. Donec porttitor a leo non porta. Morbi a nisi leo. Mauris mollis tellus sem, non imperdiet magna gravida pulvinar. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aenean egestas sodales odio ut iaculis. In sit amet orci sed dui fermentum blandit vel at lectus. Curabitur maximus mauris nibh, non finibus nisl feugiat vitae. Curabitur sollicitudin turpis arcu, sed commodo ligula elementum id. Proin et elit metus.\n"
				+ "\n"
				+ "Integer iaculis augue sem, ut convallis ipsum dictum sit amet. Ut ornare, odio quis suscipit vestibulum, dui nibh mollis libero, id blandit velit augue eget dui. Mauris id orci pulvinar, sodales tellus eget, pharetra est. Curabitur sed mi gravida, fringilla turpis non, convallis dolor. Nulla congue ex eu est auctor, at vulputate risus facilisis. Fusce eget purus ut est vulputate euismod ac ut sapien. Proin eget lacus pellentesque velit rutrum fringilla. Vivamus ut dolor nec mi lacinia rutrum. Donec ornare gravida velit. Vestibulum placerat euismod rutrum. Cras vitae risus a erat cursus dictum. Maecenas ut lacus eros.", LocalDate.of(2021, Month.of(3),  7));
		
		
		Post s4 = new Post("kanyewest", "Sentience v1.0 Release", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas interdum massa sit amet nisi gravida aliquet. Fusce et feugiat eros. Donec id laoreet eros. Suspendisse eu congue felis. Pellentesque ac libero in lectus finibus volutpat dignissim nec dui. Donec suscipit nibh leo, vel consequat urna porta vitae. Mauris iaculis augue eget diam pretium placerat. Aenean sem ligula, fringilla aliquet risus ut, interdum pellentesque augue. Duis interdum fermentum nisl, vehicula porta nibh pulvinar in. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Mauris ac faucibus magna, auctor consectetur odio. Curabitur et risus eu dui blandit fermentum a lobortis nunc. Nulla congue sodales urna vulputate iaculis.\n"
				+ "\n"
				+ "Etiam venenatis quis libero non consectetur. Fusce scelerisque augue ut bibendum bibendum. Praesent id dapibus velit, sit amet malesuada ex. Etiam a diam eros. Donec vitae odio ac nisi aliquet pellentesque id ac odio. Aenean a vehicula libero. Fusce accumsan ex nec nulla egestas mollis. Morbi efficitur purus id hendrerit blandit. Etiam sed ex urna. Sed vehicula semper massa non aliquam. Praesent mollis luctus malesuada. Nulla dapibus dolor in ex eleifend, id imperdiet eros mollis.\n"
				+ "\n"
				+ "Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aliquam eleifend bibendum tellus et fringilla. Duis condimentum turpis id purus posuere, eu facilisis ante feugiat. Aenean at aliquam odio. Sed ut nulla non libero faucibus lacinia. Donec mollis magna et massa consectetur pellentesque. Sed faucibus vehicula nisi, vitae vehicula urna elementum eu. Sed id consectetur nisl. Morbi sit amet euismod lorem, in auctor ex. Etiam id dolor ex.\n"
				+ "\n"
				+ "Quisque tristique euismod purus, quis molestie nisi efficitur eu. Etiam vestibulum quam sit amet enim tristique, lobortis vulputate libero finibus. Donec porttitor a leo non porta. Morbi a nisi leo. Mauris mollis tellus sem, non imperdiet magna gravida pulvinar. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Aenean egestas sodales odio ut iaculis. In sit amet orci sed dui fermentum blandit vel at lectus. Curabitur maximus mauris nibh, non finibus nisl feugiat vitae. Curabitur sollicitudin turpis arcu, sed commodo ligula elementum id. Proin et elit metus.\n"
				+ "\n"
				+ "Integer iaculis augue sem, ut convallis ipsum dictum sit amet. Ut ornare, odio quis suscipit vestibulum, dui nibh mollis libero, id blandit velit augue eget dui. Mauris id orci pulvinar, sodales tellus eget, pharetra est. Curabitur sed mi gravida, fringilla turpis non, convallis dolor. Nulla congue ex eu est auctor, at vulputate risus facilisis. Fusce eget purus ut est vulputate euismod ac ut sapien. Proin eget lacus pellentesque velit rutrum fringilla. Vivamus ut dolor nec mi lacinia rutrum. Donec ornare gravida velit. Vestibulum placerat euismod rutrum. Cras vitae risus a erat cursus dictum. Maecenas ut lacus eros.", LocalDate.of(2022, Month.of(1),  2));
		
		List<Post> postList2 = new ArrayList<Post>();
		postList2.add(s3);
		postList2.add(s4);
		user2.setPostList(postList2);
		
		postService.save(s3);
		postService.save(s4);
		userService.save(user2); 

	}

}

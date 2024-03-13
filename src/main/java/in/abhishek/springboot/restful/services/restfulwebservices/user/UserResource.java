package in.abhishek.springboot.restful.services.restfulwebservices.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		this.service = service;
	}
	
	@GetMapping("/users")
	public List<User> retriveAllUsers(){
		return service.findAllUsers();
	}
	
	@GetMapping("/users/{id}")
	public User retriveAllUsers(@PathVariable int id){
		return service.findOne(id);
	}
	
	@PostMapping("/users")
	public void addUsers(@RequestBody User user){
	    service.save(user);
	}
}


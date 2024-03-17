package in.abhishek.springboot.restful.services.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

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
		User user = service.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id: "+id);
		return user;
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUsers(@PathVariable int id){
		service.deleteById(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<Object> createUsers(@Valid @RequestBody User user){
	    User savedUser = service.save(user);
	    URI location = ServletUriComponentsBuilder
	    		.fromCurrentRequest()
	    		.path("/{id}")
	    		.buildAndExpand(savedUser.getId())
	    		.toUri();
		return ResponseEntity.created(location).build();
	}
}


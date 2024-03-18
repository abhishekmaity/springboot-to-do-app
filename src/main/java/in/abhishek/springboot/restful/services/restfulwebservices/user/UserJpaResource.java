package in.abhishek.springboot.restful.services.restfulwebservices.user;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import in.abhishek.springboot.restful.services.restfulwebservices.Post;
import in.abhishek.springboot.restful.services.restfulwebservices.jpa.PostRepository;
import in.abhishek.springboot.restful.services.restfulwebservices.jpa.UserRepository;
import jakarta.validation.Valid;

@RestController
public class UserJpaResource {

	private UserRepository repository;
	
	private PostRepository postRepository;
	
	public UserJpaResource(UserRepository repository, PostRepository postRepository) {
		this.repository = repository;
		this.postRepository = postRepository;
	}
	
	@GetMapping("/jpa/users")
	public List<User> retriveAllUsers(){
		return repository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public EntityModel<User> retriveAllUsers(@PathVariable int id){
		Optional<User> user = repository.findById(id);
		if(user.isEmpty())
			throw new UserNotFoundException("id: "+id);
		EntityModel<User> entityModel = EntityModel.of(user.get());
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUsers(@PathVariable int id){
		repository.deleteById(id);
	}
	
	@GetMapping("/jpa/users/{id}/posts")
	public List<Post> retrivePostForUsers(@PathVariable int id){
		Optional<User> user = repository.findById(id);
		if(user.isEmpty())
			throw new UserNotFoundException("id: "+id);
		return user.get().getPosts();
		
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUsers(@Valid @RequestBody User user){
	    User savedUser = repository.save(user);
	    URI location = ServletUriComponentsBuilder
	    		.fromCurrentRequest()
	    		.path("/{id}")
	    		.buildAndExpand(savedUser.getId())
	    		.toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createPostForUsers(@PathVariable int id, @Valid @RequestBody Post posts){
		Optional<User> user = repository.findById(id);
		if(user.isEmpty())
			throw new UserNotFoundException("id: "+id);
		
		posts.setUser(user.get());
		Post savedPost = postRepository.save(posts);
		
	    URI location = ServletUriComponentsBuilder
	    		.fromCurrentRequest()
	    		.path("/{id}")
	    		.buildAndExpand(savedPost.getId())
	    		.toUri();
		return ResponseEntity.created(location).build();
		
	}
}


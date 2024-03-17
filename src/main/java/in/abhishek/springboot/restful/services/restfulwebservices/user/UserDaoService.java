package in.abhishek.springboot.restful.services.restfulwebservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	
	private static List<User> users = new ArrayList<>();
	
	private static int counter = 0;
	
	static {
		
		users.add(new User(++counter, "Adam", LocalDate.now().minusYears(20)));
		users.add(new User(++counter, "Eve", LocalDate.now().minusYears(25)));
		users.add(new User(++counter, "Jim", LocalDate.now().minusYears(30)));
	}
	
	public List<User> findAllUsers(){
		return users;
	}

	public User findOne(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		return users.stream().filter(predicate).findFirst().orElse(null);
		
	}
	
	public void deleteById(int id) {
		Predicate<? super User> predicate = user -> user.getId().equals(id);
		users.removeIf(predicate);
	}

	
	public User save(User user) {
		user.setId(++counter);
		users.add(user);
		return user;
	}

}

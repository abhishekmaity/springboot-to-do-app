package in.com.abhishek.springboot.webapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	
	private static List<ToDo> todos = new ArrayList<>();
	static {
		todos.add(new ToDo(1, "Abhishek", "Learn AWS", 
				LocalDate.now().plusYears(1), false));
		todos.add(new ToDo(2, "Abhishek", "Learn DevOps", 
				LocalDate.now().plusMonths(6), false));
		todos.add(new ToDo(3, "Abhishek", "Learn Full Stack Development", 
				LocalDate.now(), true));
	}

	public List<ToDo> findByUsername(String username){
		return todos;
	}
}

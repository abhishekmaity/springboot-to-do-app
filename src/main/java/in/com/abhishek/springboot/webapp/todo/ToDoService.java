package in.com.abhishek.springboot.webapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ToDoService {
	
	private static int todosCount = 0;
	
	private static List<ToDo> todos = new ArrayList<>();
	static {
		todos.add(new ToDo(++todosCount, "Abhishek", "Learn AWS", 
				LocalDate.now().plusYears(1), false));
		todos.add(new ToDo(++todosCount, "Abhishek", "Learn DevOps", 
				LocalDate.now().plusMonths(6), false));
		todos.add(new ToDo(++todosCount, "Abhishek", "Learn Full Stack Development", 
				LocalDate.now(), true));
	}

	public List<ToDo> findByUsername(String username){
		return todos;
	}
	
	public void addTodo (String username, String description, LocalDate targetDate, boolean done) {
		ToDo todo = new ToDo(++todosCount, username, description,targetDate, done);
		todos.add(todo);
	}
	
}

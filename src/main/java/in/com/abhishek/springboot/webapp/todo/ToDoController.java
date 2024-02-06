package in.com.abhishek.springboot.webapp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class ToDoController {
	
	private ToDoService toDoService;
	
	
	
	public ToDoController(ToDoService toDoService) {
		super();
		this.toDoService = toDoService;
	}



	@RequestMapping("list-todos")
	public String listAllToDos(ModelMap model) {
		List<ToDo> todos = toDoService.findByUsername("Abhishek");
		model.addAttribute("todos", todos);
		return "listToDos";
	}

}

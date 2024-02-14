package in.com.abhishek.springboot.webapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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
	
	@GetMapping("add-todos")
	public String showNewToDoPage(ModelMap model) {
		ToDo toDo = new ToDo(0, "Abhishek", "Enter Description", LocalDate.now().plusYears(1), false);
		model.addAttribute("toDo", toDo);
		return "todo";
	}
	
	@PostMapping("add-todos")
	public String addNewToDoPage(ModelMap model, @Valid ToDo toDo, BindingResult result) {
		if(result.hasErrors())
			return "todo";
		String username = "Abhishek";//model.get("name").toString();
		toDoService.addTodo(username, toDo.getDescription(), 
				LocalDate.now().plusYears(1), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteToDos(@RequestParam int id) {
		toDoService.deleteById(id);
		return "redirect:list-todos";
	}
	
	@GetMapping("update-todo")
	public String showUpdateToDos(@RequestParam int id, ModelMap model) {
		ToDo toDo = toDoService.updateById(id);
		model.addAttribute("toDo", toDo);
		return "todo";
	}
	
	@PostMapping("update-todo")
	public String updateToDos(ModelMap model, @Valid ToDo toDo, BindingResult result) {
		if(result.hasErrors())
			return "todo";
		toDo.setUsername(model.get("name").toString());
		toDoService.updateTodo(toDo);
		return "redirect:list-todos";
	}

}

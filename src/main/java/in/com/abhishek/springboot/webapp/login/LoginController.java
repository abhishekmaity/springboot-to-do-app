package in.com.abhishek.springboot.webapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	
//	@RequestMapping(value="login", method=RequestMethod.GET)
//	public String gotoLogin() {
//		return "login";
//	}
//	
//	@RequestMapping(value="login", method=RequestMethod.POST)
//	public String gotoWelcome(@RequestParam String name) {
//		return "welcome";
//	}
	
	@GetMapping("login")
	public String gotoLogin() {
		return "login";
	}
	
	@PostMapping("login")
	public String gotoWelcome(@RequestParam String name, @RequestParam String password, ModelMap model) {
		model.put("name", name);
		model.put("password", password);
		return "welcome";
	}
}

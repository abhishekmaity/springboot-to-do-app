package in.com.abhishek.springboot.webapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
 

//	@RequestMapping(value="login", method=RequestMethod.GET)
//	public String gotoLogin() {
//		return "login";
//	}
//	
//	@RequestMapping(value="login", method=RequestMethod.POST)
//	public String gotoWelcome(@RequestParam String name) {
//		return "welcome";
//	}
	
	@GetMapping("/")
	public String gotoWelcomePage(ModelMap model) {
		model.put("name", getUserLoggedInName());
		return "welcome";
	}
	
	private String getUserLoggedInName() {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
}

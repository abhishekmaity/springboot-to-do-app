package in.com.abhishek.springboot.webapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String password) {
			boolean isValidUsername = username.equalsIgnoreCase("Abhishek");
			boolean isValidPassword = password.equalsIgnoreCase("12345@abc");
		return isValidUsername && isValidPassword;
	}

}

package in.com.abhishek.springboot.webapp.security;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    InMemoryUserDetailsManager createUserDetailsManager() {
		Function<String, String> passwordEncoder
			= input -> passwordEncoder().encode(input);
		UserDetails userDetails = User.builder()
		.passwordEncoder(passwordEncoder)
		.username("Abhishek")
		.password("123@abc")
		.roles("USER", "ADMIN")
		.build();
		
	return new InMemoryUserDetailsManager(userDetails);
	}
    
    @Bean
    PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }
}

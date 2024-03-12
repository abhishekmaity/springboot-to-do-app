package in.com.abhishek.springboot.webapp.security;

import static org.springframework.security.config.Customizer.withDefaults;


import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	
    @Bean
    InMemoryUserDetailsManager createUserDetailsManager() {
    	
		UserDetails userDetails = createNewUser("Abhishek", "123@abc");
		
	return new InMemoryUserDetailsManager(userDetails);
	}

	private UserDetails createNewUser(String username, String password) {
		Function<String, String> passwordEncoder
			= input -> passwordEncoder().encode(input);
			
		
		UserDetails userDetails = User.builder()
				.passwordEncoder(passwordEncoder)
				.username(username)
				.password(password)
				.roles("USER", "ADMIN")
				.build();
		return userDetails;
	}
    
    @Bean
    PasswordEncoder passwordEncoder() {
    	return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    	http.authorizeHttpRequests(
    			auth -> auth.anyRequest().authenticated());
    	http.formLogin(withDefaults());
    	
        http.csrf(csrf -> csrf.disable());
        http.headers().frameOptions().disable();
        
    	return http.build();
    }
}

package spring_security_authentication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// 配置密碼
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/**").authorizeRequests()
			.antMatchers("/", "/logout_success").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
			.and()
			.oauth2Login()
			.and()
			// logout 需多刪除 session 及清空驗證資訊
			.logout()
				.logoutUrl("/logout")
				.logoutSuccessUrl("/logout_success")
				.deleteCookies("JSESSIONID") // 刪除 JSESSION 
				.invalidateHttpSession(true) // http session 失效
				.clearAuthentication(true); // 清空驗證資訊
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		InMemoryUserDetailsManager udm = new InMemoryUserDetailsManager();
		UserDetails uds = User.withUsername("user")
				.password(passwordEncoder().encode("1234"))
				.authorities("read")
				.build();
		udm.createUser(uds);
		return udm;
	}
	
}

package ca.sheridancollege.tapnioc.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import ca.sheridancollege.tapnioc.filters.JwtRequestFilter;
import ca.sheridancollege.tapnioc.services.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;

@SuppressWarnings("deprecation")
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	private JwtRequestFilter jwtRequestFilter;
	private UserDetailsServiceImpl userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		@SuppressWarnings("unused")
		DaoAuthenticationConfigurer<AuthenticationManagerBuilder, UserDetailsServiceImpl> passwordEncoder = auth
				.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/**").permitAll()
			.antMatchers("/api/auth/login").permitAll()
			.antMatchers("/api/auth/register").permitAll()
			.antMatchers("/h2-console/**").permitAll()
			.antMatchers("/api/posts/**")
			.hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")
			.anyRequest()
			.authenticated().
			and().sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

}

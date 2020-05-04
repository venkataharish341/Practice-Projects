package io.javabrains.springsecurityjwt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import io.javabrains.springsecurityjwt.filters.MyOncePerRequestFilter;

@EnableWebSecurity
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService myUserDetailsService;
	@Autowired
	private MyOncePerRequestFilter jwtRequestFilter;

	/**
	 * This is the method which is used to configure the AuthenticationManager. When we set something in AuthenticationManagerBuilder,
	 * it creates the AuthenticationManager with that config. Here we are telling to look for MyUserDetailsService to get the credentials from DB or LDAP etc.
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}

	// We have to make the bean of AuthenticationManager. It will be build according to config given to AuthenticationManagerBuilder.
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * This method defines the authorization. Here we are allowing /authenticate to be permitted for all users,
	 * because that uri is for authentication. If we donot specify that spring default /** secures all the resources.
	 */
	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		// It has to be more restrictive to less restrictive.
		httpSecurity
		.authorizeRequests()
		.antMatchers("/h2-console/**").permitAll()
		.antMatchers("/authenticate").permitAll()
		.antMatchers("/login").permitAll()
		.antMatchers("/admin").hasRole("ADMIN") //This means only user with Role ADMIN will be able to access /admin endpoint.
		.antMatchers("/user").hasAnyRole("ADMIN", "USER") // Users with roles ADMIN, USER will be able to access /user endpoint.
		.antMatchers("/").permitAll()
		.and().exceptionHandling().and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		httpSecurity.csrf().disable();
		httpSecurity.headers().frameOptions().disable(); // In Order to see h2 console in web browser.
		
		//We are configuring the OncePerRequestFilter to intercept before UsernamePasswordAuthenticationFilter.
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}

package me.soulyana.daveslist.security;

import me.soulyana.daveslist.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.hibernate.criterion.Restrictions.and;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter
{
	@Autowired
	private SSUserDetailsService userDetailsService;

	@Autowired
	private RoomRepository roomRepository;

	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception{
		return new SSUserDetailsService(roomRepository);
	}

@Override
protected void configure(HttpSecurity http) throws Exception
		{
		http
		.authorizeRequests()
		.antMatchers("/","/list","/register","/h2-console","/login").permitAll()
		.antMatchers(	"/login").access("hasAuthority('USER')or hasAuthority('ADMIN')")
		.antMatchers("/addingnewlist").access("hasAuthority('ADMIN')")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").permitAll()
		.and()
		.formLogin().defaultSuccessUrl("/", true)
		.and()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login").permitAll().permitAll()
		.and()
		.httpBasic();

		http.csrf().disable();
		http.headers().frameOptions().disable();

		}

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception{
	auth.inMemoryAuthentication().
			withUser("DaveWolf").password("beastmaster").authorities("ADMIN");
			auth.userDetailsService(userDetailsServiceBean());

		}
}

//.antMatchers("/list").access("//hasAuthority('USER')or hasAuthority('ADMIN')")
//.antMatchers(	"/login","list","Main","mainpage","pageone","roomform","show").access("//hasAuthority('USER')or hasAuthority('ADMIN')").
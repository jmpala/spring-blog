package dev.jmpalazzolo.springblog.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.Data;

@EnableWebSecurity
@Data
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final AccessDeniedHandler accessDeniedHandler;

    final DataSource dataSource;
	
    @Value("${spring.admin.username}")
    private String adminUsername;

    @Value("${spring.admin.username}")
    private String adminPassword;

    @Value("${spring.queries.users-query}")
    private String usersQuery;

    @Value("${spring.queries.roles-query}")
    private String rolesQuery;
    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

//        // Database authentication
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder());

        // In memory authentication
        auth.inMemoryAuthentication()
                .withUser(adminUsername).password(adminPassword).roles("ADMIN");
    }
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/home", "/registration", "/error", "/blog/**", "/post/**", "/h2-console/**", "/css/**", "/images/**", "/js/**", "/webjars/**").permitAll()
        .antMatchers("/newPost/**", "/commentPost/**", "/createComment/**").hasAnyRole("USER")
        .anyRequest().authenticated()
        .and()
        .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/home")
        .permitAll()
        .and()
        .logout()
        .permitAll()
        .and()
        .exceptionHandling().accessDeniedHandler(accessDeniedHandler)
        // Fix for H2 console
        .and().headers().frameOptions().disable();
	}
}

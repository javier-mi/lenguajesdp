package edu.caece.lenguajesdeprogramacion.tpfinal.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@ConditionalOnProperty(value = "app.security.basic.enabled", havingValue = "false")
//@Configuration
//@EnableWebSecurity
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.authorizeRequests().antMatchers("/").permitAll();
//        http.csrf().disable();
//    }
//}

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(HttpSecurity http) throws Exception {
//		http.addFilter(new CorsFilter());
		http.authorizeRequests().antMatchers("**").permitAll().anyRequest().anonymous();
		http.csrf().disable();
		http.cors().disable();

	}
}
package storefront.storefront;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import storefront.storefront.web.UserDetailServiceImpl;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailServiceImpl userDetailsService;	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers("/css/**", "/img/**","/register**","/saveUser**").permitAll()
        .and()
        .authorizeRequests().antMatchers(
        		"/delete/**", 
        		"/editlivery/**",
        		"/editvinylgroup/**",
        		"/editlivery/**",
        		"/carmodellist/**",
        		"/addcarmodel/**",
        		"/saveCarmodel/**",
        		"/editcarmodel/**",
        		"/deletecarmodel/**",
        		"/carmanufacturerlist/**",
        		"/addcarmanufacturer/**",
        		"/saveCarmanufacturer/**",
        		"/editcarmanufacturer/**",
        		"/deletecarmanufacturer/**",
        		"/countrylist/**",
        		"/addcountry/**",
        		"/savecountry/**",
        		"/editcountry/**",
        		"/deletecountry/**",
        		"/userlist/**",
        		"/edituser/**",
        		"/deleteuser/**",
        		"/deletevinylgroup/**")
        .hasAuthority("ADMIN") 
        .and()
        .authorizeRequests()
          .anyRequest().authenticated()
          .and()
      .formLogin()
      	  .loginPage("/login")  // Pakottaa käyttäjän loginsivun
          .defaultSuccessUrl("/index")
          .permitAll()
          .and()
      .logout()
          .permitAll();
        
        http.cors().and().csrf().disable();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}
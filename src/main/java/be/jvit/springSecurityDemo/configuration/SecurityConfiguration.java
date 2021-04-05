package be.jvit.springSecurityDemo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static be.jvit.springSecurityDemo.configuration.ApplicationUserPermission.CATALOG_WRITE;
import static be.jvit.springSecurityDemo.configuration.ApplicationUserRole.*;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    private final PasswordEncoder passwordEncoder;

    public SecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*").permitAll()
                .antMatchers("/api/**").hasRole(FAN.name() )
                .antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(CATALOG_WRITE.name())
                .antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(CATALOG_WRITE.name())
                .antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(CATALOG_WRITE.name())
                .antMatchers(HttpMethod.GET, "/management/api/**").hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }

    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails johnUser = User.builder()
                .username("john")
                .password(passwordEncoder.encode("password"))
                .roles(FAN.name()).build();

        UserDetails jojoUser = User.builder()
                .username("jojo")
                .password(passwordEncoder.encode("ohmygod"))
                .roles(ADMIN.name()).build();

        UserDetails jotaroUser = User.builder()
                .username("jotaro")
                .password(passwordEncoder.encode("password"))
                .roles(ADMINTRAINEE.name()).build();

        return new InMemoryUserDetailsManager(johnUser,jojoUser,jotaroUser);
    }
}

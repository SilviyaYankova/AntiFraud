package antifraud.configs;

import antifraud.services.impl.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    final RestAuthenticationEntryPoint restAuthenticationEntryPoint;
    final UserDetailsServiceImpl userDetailsServiceImpl;
    final PasswordEncoder passwordEncoder;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
            .authenticationEntryPoint(restAuthenticationEntryPoint)
            .and()
            .csrf().disable().headers().frameOptions().disable()
            .and()
            .authorizeRequests()
            .mvcMatchers(HttpMethod.POST, "/api/auth/user").permitAll()
            .mvcMatchers(HttpMethod.DELETE, "/api/auth/user/**").hasRole("ADMINISTRATOR")
            .mvcMatchers(HttpMethod.GET, "/api/auth/list").hasAnyRole("ADMINISTRATOR", "SUPPORT")
            .mvcMatchers(HttpMethod.POST, "/api/antifraud/transaction").hasRole("MERCHANT")
            .mvcMatchers(HttpMethod.PUT, "/api/auth/access/**").hasRole("ADMINISTRATOR")
            .mvcMatchers(HttpMethod.PUT, "/api/auth/role/**").hasRole("ADMINISTRATOR")
            .mvcMatchers(HttpMethod.POST, "/api/antifraud/suspicious-ip").hasRole("SUPPORT")
            .mvcMatchers(HttpMethod.GET, "/api/antifraud/suspicious-ip").hasRole("SUPPORT")
            .mvcMatchers(HttpMethod.DELETE, "/api/antifraud/suspicious-ip").hasRole("SUPPORT")
            .mvcMatchers(HttpMethod.POST, "/api/antifraud/stolencard").hasRole("SUPPORT")
            .mvcMatchers(HttpMethod.GET, "/api/antifraud/stolencard").hasRole("SUPPORT")
            .mvcMatchers(HttpMethod.DELETE, "/api/antifraud/stolencard").hasRole("SUPPORT")
            .antMatchers("/actuator/shutdown").permitAll()
            .antMatchers("/api/**").authenticated()
            .anyRequest().denyAll()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl)
            .passwordEncoder(passwordEncoder);
    }
}

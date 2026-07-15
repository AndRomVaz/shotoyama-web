package com.shotoyama.web.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
public class SecurityConfig {
    @Bean PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
    @Bean UserDetailsService users(PasswordEncoder encoder,
        @Value("${app.admin.username:admin}") String username,
        @Value("${app.admin.password:CambiarShotoyama2026!}") String password){
        return new InMemoryUserDetailsManager(User.withUsername(username).password(encoder.encode(password)).roles("ADMIN").build());
    }
    @Bean SecurityFilterChain filter(HttpSecurity http)throws Exception{
        http.authorizeHttpRequests(a->a
            .requestMatchers("/admin/login","/css/**","/js/**","/images/**","/api/eventos").permitAll()
            .requestMatchers("/admin/**").hasRole("ADMIN").anyRequest().permitAll())
          .formLogin(f->f.loginPage("/admin/login").loginProcessingUrl("/admin/login").defaultSuccessUrl("/admin",true).failureUrl("/admin/login?error").permitAll())
          .logout(l->l.logoutUrl("/admin/logout").logoutSuccessUrl("/"));
        return http.build();
    }
}

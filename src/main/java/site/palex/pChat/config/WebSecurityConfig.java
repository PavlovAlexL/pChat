package site.palex.pChat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import site.palex.pChat.service.UserService;

import javax.sql.DataSource;


//Класс WebSecurityConfig содержит аннотацию @EnableWebMvcSecurity для включения поддержки безопасности Spring Security и Spring MVC интеграцию.
// Он также расширяет WebSecurityConfigurerAdapter и переопределяет пару методов для установки некоторых настроек безопасности.
//Метод configure(HttpSecurity) определяет, какие URL пути должны быть защищены, а какие нет. В частности, "/" настроены без требования к авторизации.
// Ко всем остальным путям должна быть произведена аутентификация.

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/", "/registration").permitAll()
                    .anyRequest().authenticated()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }

   //Хотим брать пользователей из базы данных


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());  //будет шифровать парольи
                //.usersByUsernameQuery("select username, password, active from usr where username=?")    //Нужно чтобы система могла найти пользователя по его имени
                //.authoritiesByUsernameQuery("select u.username, ur.roles from usr u inner join user_role ur on u.id = ur.user_id where u.username=?");  //Помогает получить список пользователей с их ролями


    }
}

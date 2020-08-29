package com.wf.task.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

/**
 * @author wf
 * @create 2020-08-29 10:55
 * @desc
 **/
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Resource
    private BCryptPasswordEncoder encoder;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
            .antMatchers("/userLogin").permitAll()
            .antMatchers("/level1/**").hasRole("VIP1")
            .antMatchers("/level2/**").hasRole("VIP2")
            .antMatchers("/level3/**").hasRole("VIP3");

        // 开启登录功能
        http.formLogin().usernameParameter("user").passwordParameter("pwd").loginPage("/userLogin");
        // 开启注销功能
        http.logout().logoutSuccessUrl("/");
        // 开启记住我功能
        http.rememberMe().rememberMeParameter("rememberME");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(encoder).withUser("mofei").password(encoder.encode("123456")).roles("VIP1", "VIP2")
                .and()
                .withUser("zhangsan").password(encoder.encode("123456")).roles("VIP1", "VIP3");

    }

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }
}

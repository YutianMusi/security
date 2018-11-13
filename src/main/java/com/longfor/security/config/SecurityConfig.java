package com.longfor.security.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @Author: gaoleijie.
 * @Description:SpringSecurity 核心配置类
 * @Date:Created in 2018/8/25 22:01.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());//添加自定义的userDetailsService认证
    }
    // 装载BCrypt密码编码器
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /**  http
               // 关闭csrf
               .csrf().disable()
              // .anonymous().disable()
               //.cors().and().httpBasic()

              .authorizeRequests()
               // 任何用户都可以访问URL以"/resources/", equals "/signup", 或者 "/about"开头的URL。
               .antMatchers("/resources/**","/login").permitAll()
               //以 "/admin/" 开头的URL只能由拥有 "ROLE_ADMIN"角色的用户访问。请注意我们使用 hasRole 方法
               .antMatchers("/admin/**").hasRole("ADMIN")
               // 任何以"/db/" 开头的URL需要用户同时具有 "ROLE_ADMIN" 和 "ROLE_DBA"。.
               .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
               // 尚未匹配的任何URL要求用户进行身份验证
               .anyRequest().authenticated()
              .and().formLogin()
              .loginPage("/login")
               // 登陆成功
              .loginProcessingUrl("/login").defaultSuccessUrl("/index",true)
            /**   // 认证成功
               .successHandler(new GoAuthenticationSuccessHandler())
               // 认证失败
               .failureHandler(new GoAuthenticationFailureHandler())
               .and().exceptionHandling()
               // 已经认证的用户访问自己没有权限的资源处理
               .accessDeniedHandler(new GoAccessDeniedHandler())
               // 未经过认证的永固访问受保护的资源
               .authenticationEntryPoint(new GoAuthenticationEntryPoint())**/
               /**.and().logout().permitAll()
               // 注销功能
               //.logoutUrl("/login")
               // 注销之后跳转的URL。默认是/login?logout。具体查看 the JavaDoc文档.
             //  .logoutSuccessUrl("/login")
               // 让你设置定制的 LogoutSuccessHandler。如果指定了这个选项那么logoutSuccessUrl()的设置会被忽略
              // .logoutSuccessHandler()
               // 指定是否在注销时让HttpSession无效。 默认设置为 true。
                .invalidateHttpSession(true)
               // 允许指定在注销成功时将移除的cookie。
               .deleteCookies("\"JSESSIONID\"")
               // cookie 失效时间,默认有效期为14天
               .and().rememberMe()
               .tokenValiditySeconds(1800)
               .key("token_key");*/

       http
                .authorizeRequests()
               // 任何用户都可以访问URL以"/resources/", equals "/signup", 或者 "/about"开头的URL。
               .antMatchers("/resources/**","/login","/auth/**").permitAll()
               //以 "/admin/" 开头的URL只能由拥有 "ROLE_ADMIN"角色的用户访问。请注意我们使用 hasRole 方法
               .antMatchers("/admin").hasRole("ADMIN")
               .antMatchers("/user").access("hasRole('USER') or hasRole('ADMIN') ")
               // 任何以"/db/" 开头的URL需要用户同时具有 "ROLE_ADMIN" 和 "ROLE_DBA"。.
               .antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login").defaultSuccessUrl("/index",true).failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .permitAll()
               // 指定是否在注销时让HttpSession无效。 默认设置为 true。
               //.invalidateHttpSession(true)
               // 允许指定在注销成功时将移除的cookie。
              // .deleteCookies("\"JSESSIONID\"")
               // cookie 失效时间,默认有效期为14天
               .and().rememberMe()
               .tokenValiditySeconds(1800)
               .key("token_key")
                .and().csrf().disable()
               /**
                *  // 认证成功
                *                .successHandler(new GoAuthenticationSuccessHandler())
                *                // 认证失败
                *                .failureHandler(new GoAuthenticationFailureHandler())
                *                .and().exceptionHandling()
                *                // 已经认证的用户访问自己没有权限的资源处理
                *                .accessDeniedHandler(new GoAccessDeniedHandler())
                *                // 未经过认证的永固访问受保护的资源
                *                .authenticationEntryPoint(new GoAuthenticationEntryPoint())**/
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                .csrf().disable()
                .cors().and().httpBasic();

    }




}

package com.pknu.backboard.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;



// 스프링시큐리티 핵심파일!!
@Configuration // 스프링 환경설정 파일
@EnableWebSecurity // 스프링 시큐리티 제어 활성화
public class SecurityConfig {

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests((ahr) -> ahr.requestMatchers("/**") // 인증되지 않은 모든 페이지 요청을 허락(로그인창 안뜸)
                                               .permitAll()
                                               .anyRequest()
                                               .authenticated())
            .csrf((csrf)->csrf.ignoringRequestMatchers("/h2-console/**")) // h2-console URL은 CSRF에 예외라고 설정
            .headers((hdr) -> hdr.addHeaderWriter(new XFrameOptionsHeaderWriter(
                XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN // h2-console이 frame방식(구시대방식)으로 개발되어 필요한 설정
            )))
            // 로그인 URL 접근 지정. 로그인페이지URL와 로그인 성공 후 페이지URL 지정
            .formLogin((fl) -> fl.loginPage("/member/Signin")
                                 .defaultSuccessUrl("/"))
            // 로그아웃 URL 지정
            .logout((lo) -> lo.logoutUrl("/member/Signout")
                              .logoutSuccessUrl("/")
                              .invalidateHttpSession(true))
        ; // ;을 분리해놓으면 chain method 추가시 간편함

        return http.build();
    }

}

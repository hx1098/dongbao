package com.hx.dongbao.config;

import com.hx.dongbao.advice.AuthIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author hx
 * @version 1.0.0
 * @createTime 2022/4/30 10:26
 * @description
 * @editUser hx
 * @editTime 2022/4/30 10:26
 * @editDescription
 */
@Configuration
public class IntercepterConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authIntercepter())
                .addPathPatterns("/**")
                .excludePathPatterns("/register");
    }


    @Bean
    public AuthIntercepter authIntercepter() {
        return new AuthIntercepter();
    }
}

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
 * @editDescription  这里配置后是用拦截器生效
 */
@Configuration
public class IntercepterConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authIntercepter())
                .addPathPatterns("/**")
                //需要配置成这种的路径才会生效, 不知道为啥会这样....
                .excludePathPatterns("/**/user-member/login/**", "/**/user-member/register/**");
    }


    @Bean
    public AuthIntercepter authIntercepter() {
        return new AuthIntercepter();
    }
}

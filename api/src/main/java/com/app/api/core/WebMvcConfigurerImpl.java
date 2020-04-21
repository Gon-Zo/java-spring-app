package com.app.api.core;

import com.app.api.core.auth.JwtAuthInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer {


    /**
     * crose orgin setting
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080");
    }


    private String [] INTERCEPTOR_WHITE_LIST = {
            "/signUp/**" ,
            "/signIn/**"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new JwtAuthInterceptor())
               .addPathPatterns("/*")
               .excludePathPatterns("/signUp" , "/signIn");
    }

}

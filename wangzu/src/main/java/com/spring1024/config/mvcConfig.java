package com.spring1024.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class mvcConfig implements WebMvcConfigurer{
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("User/index");
        registry.addViewController("/index").setViewName("User/index");
    }

    @Bean
    public LocaleResolver localeResolver(){//因为自动注入的原因，无法更换方法名。局限性。
        return new localeResolver();
    }
}

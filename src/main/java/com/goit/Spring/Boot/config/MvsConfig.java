package com.goit.Spring.Boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// класс налаштування маршрутизації веб-додатка на основі Spring MVC
@Configuration
public class MvsConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/note").setViewName("main-page");
        registry.addViewController("/").setViewName("main-page");
        registry.addViewController("/edit").setViewName("edit-page");
        registry.addViewController("/create").setViewName("creating-new-node-page");
        registry.addViewController("/login").setViewName("login");
    }

}

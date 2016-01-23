package com.empl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 * Created by faust on 23.01.16.
 */
public class MySpringWebConfig {
@Configuration
@EnableWebMvc
@ComponentScan("com.empl")
public class WebAppConfig {
        @Bean
        public UrlBasedViewResolver setupViewResolver() {
            UrlBasedViewResolver resolver = new UrlBasedViewResolver();
            resolver.setPrefix("/pages/");// указываем где будут лежать наши веб-страницы
            resolver.setSuffix(".jsp");// формат View который мы будем использовать
            resolver.setViewClass(JstlView.class);
            return resolver;
        }

    }
}

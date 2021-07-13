package com.codegym.exam;

import com.codegym.exam.formatter.CountryFormatter;
import com.codegym.exam.service.country.CountryService;
import com.codegym.exam.service.country.CountryServiceImpl;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Module4ExamApplication {

    public static void main(String[] args) {
        SpringApplication.run(Module4ExamApplication.class, args);
    }

    @Configuration
    static class MyConfig implements WebMvcConfigurer, ApplicationContextAware {
        private ApplicationContext applicationContext;

        @Override
        public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            this.applicationContext = applicationContext;
        }

        @Override
        public void addFormatters(FormatterRegistry registry) {
            registry.addFormatter(new CountryFormatter(applicationContext.getBean(CountryService.class)));
        }
    }
}

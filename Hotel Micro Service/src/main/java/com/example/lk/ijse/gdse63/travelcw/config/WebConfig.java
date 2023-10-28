package com.example.lk.ijse.gdse63.travelcw.config;


import com.example.lk.ijse.gdse63.travelcw.utill.StringToPricesListConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new StringToPricesListConverter());
    }
}
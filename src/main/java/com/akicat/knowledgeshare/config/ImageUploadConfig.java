package com.akicat.knowledgeshare.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ImageUploadConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        System.out.println("ImageUpload配置生效");
        registry.addResourceHandler("/images/**").addResourceLocations("file:D:\\GraduationProject\\BackEnd\\KnowledgeShareBack\\src\\main\\resources\\images\\");
    }
}

package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@MapperScan("com.example.mapper")
//@SpringBootApplication(scanBasePackages = "com.example")
@SpringBootApplication
public class XiaochengxuApplication {

    public static void main(String[] args) {
        SpringApplication.run(XiaochengxuApplication.class, args);
    }

    // 为了打包springboot项目
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder builder) {
        return builder.sources(this.getClass());
    }

//    /*
//     * 配置JSP视图解析器
//     */
//    @Bean
//    public InternalResourceViewResolver setupViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        /** 设置视图路径的前缀 */
//        resolver.setPrefix("/WEB-INF/jsp/");
//        /** 设置视图路径的后缀 */
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }
}

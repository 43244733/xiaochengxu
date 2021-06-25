package com.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// 访问外部静态资源文件
@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    /**
     * 日志记录器
     */
    private static final Logger logger = LoggerFactory.getLogger(WebMvcConfiguration.class);


    //windows系统下访问路径
    private static final String filePathWindow = "C:\\img\\";
    //Linux系统下访问路径
    private static final String filePathLinux = "/usr/img/";

    /**
     * 配置静态访问资源
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 获取操作系统名称
        String os = System.getProperty("os.name");

        //如果是Windows系统
        if (os.toLowerCase().startsWith("win")) {
            registry.addResourceHandler("/image/**")
                    // /image/**: 表示在磁盘filePathWindow目录下的所有资源会被解析为以下的路径
                    .addResourceLocations("file:" + filePathWindow);
        } else {
            //linux 和 mac
            registry.addResourceHandler("/image/**")
                    .addResourceLocations("file:" + filePathLinux);
        }

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/templates/");
    }

    /**
     * 配置请求视图映射
     *
     * @return
     */
    @Bean
    public InternalResourceViewResolver resourceViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        //请求视图文件的前缀地址
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        //请求视图文件的后缀
        internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
    }

    /**
     * 视图配置
     *
     * @param registry
     */
    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(resourceViewResolver());
        registry.jsp("/WEB-INF/jsp/", ".jsp");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowCredentials(true)
                .allowedHeaders("*");
    }
}


// 不推荐的继承 （没有配置JSP视图解析器的方法）
/*
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    //windows系统下访问路径
    private static final String filePathWindow = "C:\\img\\";
    //Linux系统下访问路径
    private static final String filePathLinux = "/user/img/";

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 获取操作系统名称
        String os = System.getProperty("os.name");

        //如果是Windows系统
        if (os.toLowerCase().startsWith("win")) {
            registry.addResourceHandler("/image/**")
                    // /image/**: 表示在磁盘filePathWindow目录下的所有资源会被解析为以下的路径
                    .addResourceLocations("file:" + filePathWindow);
        } else {
            //linux 和 mac
            registry.addResourceHandler("/image/**")
                    .addResourceLocations("file:" + filePathLinux);
        }

        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/templates/");

        super.addResourceHandlers(registry);
    }


    */
/*
        跨域配置
     *//*

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")
                .allowCredentials(true)
                .allowedHeaders("*")
                .maxAge(3600);
    }
}
*/

// 已废弃
/*
public class WebMvcConfiguration extends WebMvcConfigurerAdapter
{
    //windows系统下访问路径
    private static final String filePathWindow = "C:\\img\\";
    //Linux系统下访问路径
    private static final String filePathLinux = "/user/img/";

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        // 获取操作系统名称
        String os = System.getProperty("os.name");

        //如果是Windows系统
        if (os.toLowerCase().startsWith("win")) {
            registry.addResourceHandler("/image/**")
                    // /image/**: 表示在磁盘filePathWindow目录下的所有资源会被解析为以下的路径
                    .addResourceLocations("file:" + filePathWindow);
        } else {
            //linux 和 mac
            registry.addResourceHandler("/image/**")
                    .addResourceLocations("file:" + filePathLinux);
        }

        //addResourceHandler：在url请求的路径
        //addResourceLocations：图片存放的真实路径
//        registry.addResourceHandler("/image/**").addResourceLocations("file:C://img/");
        super.addResourceHandlers(registry);
    }
}
*/



package com.example.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

/**
 * Spring Boot应用程序启动类
 * 负责启动Spring Boot应用并配置基本组件
 */
@Configuration
@ComponentScan
@EnableCaching
@EnableTransactionManagement
@EnableAutoConfiguration
@MapperScan("com.example.simple.Mapper")
public class SimpleApplication {

    /**
     * 应用程序入口方法
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class, args);
    }

    /**
     * 跨域配置类
     * 用于配置CORS跨域访问策略
     */
    @Configuration
    public class CorsConfig {

        /**
         * 构建CORS配置
         * @return CorsConfiguration对象
         */
        private CorsConfiguration buildConfig() {
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.addAllowedOrigin("*");
            corsConfiguration.addAllowedHeader("*");
            corsConfiguration.addAllowedMethod("*");
            return corsConfiguration;
        }

        /**
         * 创建CORS过滤器Bean
         * @return CorsFilter对象
         */
        @Bean
        public CorsFilter corsFilter() {
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", buildConfig());
            return new CorsFilter(source);
        }
    }
}

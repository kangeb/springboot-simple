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
 * Spring Boot应用启动类
 * 配置组件扫描、缓存、事务管理、MyBatis Mapper扫描等
 */
@Configuration
@ComponentScan
@EnableCaching // 开启缓存
@EnableTransactionManagement // 开启事务管理
@EnableAutoConfiguration
@MapperScan("com.example.simple.Mapper") // 指定Mapper接口扫描包路径
public class SimpleApplication {

    /**
     * 应用入口方法
     *
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        SpringApplication.run(SimpleApplication.class, args);
    }

    /**
     * 跨域配置类
     * 配置全局跨域访问规则
     */
    @Configuration
    public class CorsConfig {

        /**
         * 构建跨域配置
         *
         * @return CorsConfiguration对象
         */
        private CorsConfiguration buildConfig() {
            CorsConfiguration corsConfiguration = new CorsConfiguration();
            corsConfiguration.addAllowedOrigin("*"); // 允许所有来源
            corsConfiguration.addAllowedHeader("*"); // 允许所有请求头
            corsConfiguration.addAllowedMethod("*"); // 允许所有请求方法
            return corsConfiguration;
        }

        /**
         * 创建跨域过滤器
         *
         * @return CorsFilter对象
         */
        @Bean
        public CorsFilter corsFilter() {
            UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
            source.registerCorsConfiguration("/**", buildConfig()); // 对所有路径应用跨域配置
            return new CorsFilter(source);
        }
    }
}

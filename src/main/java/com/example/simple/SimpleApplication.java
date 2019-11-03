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

@Configuration
@ComponentScan
@EnableCaching //开启缓存
@EnableTransactionManagement // 开启事务管理
@EnableAutoConfiguration
@MapperScan("com.example.simple.Mapper")//告诉mapper所在的包名
public class SimpleApplication {
	public static void main(String[] args) {
		SpringApplication.run(SimpleApplication.class, args);
	}
	@Configuration
	public class CorsConfig {
		private CorsConfiguration buildConfig() {
			CorsConfiguration corsConfiguration = new CorsConfiguration();
			corsConfiguration.addAllowedOrigin("*");
			corsConfiguration.addAllowedHeader("*");
			corsConfiguration.addAllowedMethod("*");
			return corsConfiguration;
		}

		@Bean
		public CorsFilter corsFilter() {
			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", buildConfig());
			return new CorsFilter(source);
		}
	}
}

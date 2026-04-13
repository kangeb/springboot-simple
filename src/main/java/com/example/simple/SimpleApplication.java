package com.example.simple;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableSwagger2
@EnableTransactionManagement
@MapperScan("com.example.simple.Mapper")
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

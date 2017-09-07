package me.blog.kei8205.lpsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = { "me.blog.kei8205" })
@SpringBootApplication
public class LowPriceSearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(LowPriceSearchApplication.class, args);
	}
}

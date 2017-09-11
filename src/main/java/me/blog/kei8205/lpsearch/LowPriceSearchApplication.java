package me.blog.kei8205.lpsearch;

import javax.annotation.PostConstruct;

import lombok.extern.slf4j.Slf4j;
import me.blog.kei8205.lpsearch.initialize.InitializeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@Slf4j
@ComponentScan(basePackages = { "me.blog.kei8205" })
@SpringBootApplication
public class LowPriceSearchApplication {

	@Autowired private InitializeService initializeService;

	public static void main(String[] args) {
		SpringApplication.run(LowPriceSearchApplication.class, args);
	}

	@PostConstruct
	public void initialize() {
		log.error("## LowPriceSearchApplication.initialize ## {} created", this.getClass());
		if (!initializeService.isInitialized()) {
			initializeService.initializeTables();
		}
	}
}

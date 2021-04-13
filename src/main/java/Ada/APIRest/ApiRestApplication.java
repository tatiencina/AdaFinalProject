package Ada.APIRest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiRestApplication {
	private static final Logger log = LoggerFactory.getLogger(ApiRestApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ApiRestApplication.class, args);
	}

	@Bean
	public CommandLineRunner logs() {
		return(args) -> {
			log.info("Ada - APIRest");
			log.info("=====================");
			log.info("This is a Java project, using Spring Boot");
			log.info("Final project for Ada ITW Backend 3a Online");
			log.info("--------------------------------");


		};



	}

}








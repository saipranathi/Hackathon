package fr.ing.interview;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SpringBootCrudOperationApplication {

	private static Logger LOGGER = LoggerFactory.getLogger(SpringBootCrudOperationApplication.class);

	public static void main(String[] args) {

		LOGGER.info("This is France Interview Application");
		SpringApplication.run(SpringBootCrudOperationApplication.class, args);

	}

}

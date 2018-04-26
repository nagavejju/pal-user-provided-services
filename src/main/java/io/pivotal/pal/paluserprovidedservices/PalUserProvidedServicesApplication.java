package io.pivotal.pal.paluserprovidedservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class PalUserProvidedServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PalUserProvidedServicesApplication.class, args);
	}

	@Bean
	CohortRepository cohortRepository(DataSource dataSource) {
		return new CohortRepository(dataSource);
	}

}

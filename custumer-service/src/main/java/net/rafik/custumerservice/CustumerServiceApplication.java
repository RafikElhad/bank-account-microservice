package net.rafik.custumerservice;

import net.rafik.custumerservice.config.GlobalConfig;
import net.rafik.custumerservice.entities.Customer;
import net.rafik.custumerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties(GlobalConfig.class)
public class CustumerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustumerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
		return args -> {

			List<Customer> customerList= List.of(
					Customer.builder()
							.firstName("Rafik")
							.lastName("Elhad")
							.email("rafik@gmail.com")
							.build(),
					Customer.builder()
							.firstName("Mohamed")
							.lastName("Rafiou")
							.email("rafiou@gmail.com")
							.build()

			);
			customerRepository.saveAll(customerList);
		};
	}
}

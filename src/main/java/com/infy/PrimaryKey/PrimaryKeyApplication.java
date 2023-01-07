package com.infy.PrimaryKey;

import com.infy.PrimaryKey.dto.CustomerDTO;
import com.infy.PrimaryKey.service.CustomerServiceImpl;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.time.LocalDate;

@SpringBootApplication
public class PrimaryKeyApplication implements CommandLineRunner {

	public static final Log LOGGER = LogFactory.getLog(PrimaryKeyApplication.class);

	@Autowired
	CustomerServiceImpl customerService;

	@Autowired
	Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(PrimaryKeyApplication.class, args);
	}

	public void run(String... args) throws Exception{
		addCustomer();
	}

	public void addCustomer(){
		CustomerDTO customerDTO = new CustomerDTO();
		customerDTO.setEmailId("buhari@infy.com");
		customerDTO.setName("Buhari");
		customerDTO.setDateOfBirth(LocalDate.now());

		try{
			Integer id = customerService.addCustomer(customerDTO);
			LOGGER.info(environment.getProperty("UserInterface.INSERT_SUCCESS") + id);
		} catch (Exception e){
			if(e.getMessage() != null)
				LOGGER.info(environment.getProperty(e.getMessage(), "Something went wrong. Please check log file for more details"));
		}
	}

}

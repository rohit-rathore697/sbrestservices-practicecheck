package com.cognizant.truyum;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@SpringBootApplication
@ComponentScan("com.*")
public class TruyumApplication {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	
	@Autowired
	private static MenuItemService service;
	
	public static void getItems() {
		LOGGER.info("START");
		List<MenuItem> list = service.getMenuItemListCustomer();
		for(MenuItem m : list) {
			System.out.println(m.getName());
		}
		LOGGER.info("END");
	}

	public static void main(String[] args) {
		SpringApplication.run(TruyumApplication.class, args);
	}

}

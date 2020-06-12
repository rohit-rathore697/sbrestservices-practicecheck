package com.cognizant.truyum.controller;

import java.util.List; 

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;

@RestController
@RequestMapping(value = "/menu-items")
public class MenuItemController {

	private final static Logger LOGGER = LoggerFactory.getLogger(MenuItemController.class);

	@Autowired
	private MenuItemService service;

	@GetMapping(value = "/list")
	public List<MenuItem> getAllMenuItems() {
		LOGGER.info("START");
		List<MenuItem> customerList = service.getMenuItemListCustomer();
		LOGGER.info("END");
		return customerList;
	}

	@GetMapping(value = "/{id}")
	public MenuItem getMenuItem(@PathVariable("id") long id) {
		LOGGER.info("START");
		LOGGER.info("END");
		return service.getMenuItem(id);
	}

	@PostMapping()
	public void modifyMenuItem(@RequestBody @Valid MenuItem menuItem) {
		LOGGER.info("START");
		service.modifyMenuItem(menuItem);
		LOGGER.info("END");
	}

}

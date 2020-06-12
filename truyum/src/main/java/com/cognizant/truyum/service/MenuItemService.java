package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;

@Service
public class MenuItemService {

	private final static Logger LOGGER = LoggerFactory.getLogger(MenuItemService.class);

	@Autowired
	private MenuItemDaoCollectionImpl daoimpl;

	public List<MenuItem> getMenuItemListCustomer() {
		LOGGER.info("START");
		List<MenuItem> customerList = daoimpl.getMenuItemListCustomer();
		LOGGER.info("END");
		return customerList;
	}

	public MenuItem getMenuItem(long id) {
		LOGGER.info("START");
		LOGGER.info("END");
		return daoimpl.getMenuItem(id);
	}

	public void modifyMenuItem(MenuItem menuItem) {
		LOGGER.info("START");
		LOGGER.info("END");
		daoimpl.modifyMenuItem(menuItem);
	}

}

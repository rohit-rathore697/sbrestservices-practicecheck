package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList;
	private final static Logger LOGGER = LoggerFactory.getLogger(MenuItemDaoCollectionImpl.class);

	public MenuItemDaoCollectionImpl() {
		super();
		LOGGER.info("START");
		if (menuItemList == null) {
			menuItemList = new ArrayList<MenuItem>();
			ApplicationContext context = new ClassPathXmlApplicationContext("truyum.xml");
			menuItemList=(ArrayList<MenuItem>)context.getBean("menulist");
		}
		LOGGER.info("END");
	}

	@Override
	public List<MenuItem> getMenuItemListAdmin() {
		// TODO Auto-generated method stub
		LOGGER.info("START");
		LOGGER.info("END");
		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		// TODO Auto-generated method stub
		LOGGER.info("START");
		List<MenuItem> customerList = new ArrayList<MenuItem>();
		for (int i = 0; i < menuItemList.size(); i++) {
			MenuItem menuItem = menuItemList.get(i);
			if ((menuItem.getDateOfLaunch().equals(new Date()) || menuItem.getDateOfLaunch().before(new Date()))
					&& menuItem.isActive()) {
				customerList.add(menuItem);
			}
		}
		LOGGER.info("END");
		return customerList;
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		LOGGER.info("START");
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).equals(menuItem)) {
				menuItemList.set(i, menuItem);
				break;
			}
		}
		LOGGER.info("END");
	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		LOGGER.info("START");
		MenuItem menuItem = null;
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItem = menuItemList.get(i);
				break;
			}
		}
		LOGGER.info("END");
		return menuItem;
	}

}

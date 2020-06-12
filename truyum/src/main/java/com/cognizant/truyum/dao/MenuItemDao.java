package com.cognizant.truyum.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

public interface MenuItemDao {
	
	public List<MenuItem> getMenuItemListAdmin();

	public List<MenuItem> getMenuItemListCustomer();

	public void modifyMenuItem(MenuItem menuItem);

	public MenuItem getMenuItem(long menuItemId);

}

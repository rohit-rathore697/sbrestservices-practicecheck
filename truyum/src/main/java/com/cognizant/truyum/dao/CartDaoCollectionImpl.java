package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao {

	private static HashMap<String, Cart> userCarts;

	private final static Logger LOGGER = LoggerFactory.getLogger(CartDaoCollectionImpl.class);

	public CartDaoCollectionImpl() {
		super();
		LOGGER.info("START");
		if (userCarts == null) {
			userCarts = new HashMap<String, Cart>();
		}
		LOGGER.info("END");
	}

	@Override
	public void addCartItem(String userId, long menuItemId) {
		// TODO Auto-generated method stub
		LOGGER.info("START");
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);

		if (userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
			menuItemList.add(menuItem);
		} else {
			Cart cart = new Cart(new ArrayList<MenuItem>(), 0.0);
			cart.getMenuItemList().add(menuItem);
			userCarts.put(userId, cart);
		}
		LOGGER.info("END");

	}

	@Override
	public List<MenuItem> getAllCartItems(String userId) {
		// TODO Auto-generated method stub
		LOGGER.info("START");
		if (userCarts.containsKey(userId)) {
			List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();

			double total = 0.0;
			for (int i = 0; i < menuItemList.size(); i++) {
				total += menuItemList.get(i).getPrice();
			}
			userCarts.get(userId).setTotal(total);

			return menuItemList;
		}
		LOGGER.info("END");
		return null;
	}

	@Override
	public void removeCartItem(String userId, long menuItemId) {
		// TODO Auto-generated method stub
		LOGGER.info("START");
		List<MenuItem> menuItemList = userCarts.get(userId).getMenuItemList();
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItemId) {
				menuItemList.remove(i);
				break;
			}
		}
		LOGGER.info("END");

	}

}

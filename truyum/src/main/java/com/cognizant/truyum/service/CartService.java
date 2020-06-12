package com.cognizant.truyum.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.model.MenuItem;

@Service
public class CartService {

	private final static Logger LOGGER = LoggerFactory.getLogger(CartService.class);

	@Autowired
	private CartDao cartdao;

	public void addCartItem(String userId, long menuItemId) {
		LOGGER.info("START");
		cartdao.addCartItem(userId, menuItemId);
		LOGGER.info("END");
	}

	public List<MenuItem> getAllCartItems(String userId) {
		LOGGER.info("START");
		LOGGER.info("END");
		return cartdao.getAllCartItems(userId);
	}

	public void removeCartItem(String userId, long menuItemId) {
		LOGGER.info("START");
		cartdao.removeCartItem(userId, menuItemId);
		LOGGER.info("END");
	}

}

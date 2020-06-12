package com.cognizant.truyum.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.CartService;

@RestController
public class CartController {

	private final static Logger LOGGER = LoggerFactory.getLogger(CartController.class);

	@Autowired
	private CartService service;

	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@RequestBody String userId, @RequestBody long menuItemId) {
		service.addCartItem(userId, menuItemId);
	}

	@GetMapping("/{userId}")
	public List<MenuItem> getAllCartItems(String userId) {
		return service.getAllCartItems(userId);
	}

	@DeleteMapping("/{userId}/{menuItemId}")
	public void removeCartItem(@PathVariable("userId") String userId, @PathVariable("menuItemId") long menuItemId) {
		service.removeCartItem(userId, menuItemId);
	}

}

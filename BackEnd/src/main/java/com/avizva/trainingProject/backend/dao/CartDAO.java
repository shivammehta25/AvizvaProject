package com.avizva.trainingProject.backend.dao;

import java.util.List;

import com.avizva.trainingProject.backend.model.Cart;

public interface CartDAO {
	public boolean addProductToCart(Cart cart);
	public boolean removeProductFromCart(Cart cart);
	public boolean updateCartQuantity(Cart cart);
	public Long priceCalculator(Long ...discount);
	public Cart getCartById(int cartId);
	public List<Cart> getAllCartByUser(String username);
}

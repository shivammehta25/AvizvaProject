package com.avizva.trainingProject.backend.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.avizva.trainingProject.backend.model.Cart;
import com.avizva.trainingProject.backend.model.Product;

public interface CartService {
	public boolean addProductToCart(int productId , int productQuantity , HttpSession session);
	public boolean removeProductFromCart(int cartId);
	public boolean updateCartQuantity(int productId,int CartQuantity,String username);
	public Long priceCalculator(String username,Long ...discount);
	public boolean hasCartProduct(int productId,String username);
	public List<Product> allProductInCart(String username);
	public List<Integer> getQuantityOfProductInCart(List<Product> listCart,String username);
	public int getQuantity(int productId , String username);
	public Cart getCartFromProductId(int productId , String username);
	
}

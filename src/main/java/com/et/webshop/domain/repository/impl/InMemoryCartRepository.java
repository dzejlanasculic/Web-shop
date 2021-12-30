/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.webshop.domain.repository.impl;

import com.et.webshop.domain.Cart;
import com.et.webshop.domain.repository.CartRepository;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
/**
 *
 * @author Džejlana Ščulić
 */
public class InMemoryCartRepository implements CartRepository{
    private Map<String, Cart> listOfCarts;
  
  public InMemoryCartRepository() {
    listOfCarts =  new HashMap<String,Cart>();   
  }
 
  public Cart create(Cart cart) {
    if(listOfCarts.keySet().contains(cart.getCartId())) {
      throw new IllegalArgumentException(String.format("Ne možete kreirati korpu.",cart.getCartId()));
    }
    listOfCarts.put(cart.getCartId(), cart);
    return cart;
  }
  
  public Cart read(String cartId) {
    return listOfCarts.get(cartId);
  }

  public void update(String cartId, Cart cart) {
    if(!listOfCarts.keySet().contains(cartId)) {
      throw new IllegalArgumentException(String.format("Ne možete ažurirati korpu.",cartId));
    }
    listOfCarts.put(cartId, cart);
  }

  public void delete(String cartId) {
    if(!listOfCarts.keySet().contains(cartId)) {
      throw new IllegalArgumentException(String.format("Ne možete izbrisati korpu.",cartId));
    }
    listOfCarts.remove(cartId);
  }
}

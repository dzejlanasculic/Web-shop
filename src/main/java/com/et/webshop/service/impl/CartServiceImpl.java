/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.webshop.service.impl;

import com.et.webshop.domain.Cart;
import com.et.webshop.domain.repository.CartRepository;
import com.et.webshop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Component;
/**
 *
 * @author Džejlana Ščulić
 */

public class CartServiceImpl implements CartService{
  @Autowired
  private CartRepository cartRepository;

  public Cart create(Cart cart) {
    return cartRepository.create(cart);
  }

  public Cart read(String cartId) {
    return cartRepository.read(cartId);
  }

  public void update(String cartId, Cart cart) {
    cartRepository.update(cartId, cart);
  }

  public void delete(String cartId) {
    cartRepository.delete(cartId);
  }
}

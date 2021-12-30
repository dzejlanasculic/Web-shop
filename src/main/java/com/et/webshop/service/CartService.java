/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.et.webshop.service;

import com.et.webshop.domain.Cart;



/**
 *
 * @author Džejlana Ščulić
 */

public interface CartService {
  Cart create(Cart cart); 
  Cart read(String cartId);
  void update(String cartId, Cart cart); 
  void delete(String cartId);
}
